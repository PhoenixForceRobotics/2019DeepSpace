package frc.robot.commands.rotation;

//Andrew added the loggin to this file, may need some more logging

import frc.robot.Robot;
import frc.robot.subsystems.Rotation;
import frc.robot.subsystems.OI;
import frc.robot.Constants;
import frc.robot.commands.rotation.CollectorPID;
import edu.wpi.first.wpilibj.command.Command;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Timer;

//import the logging thing
import frc.robot.utility.Log;
import java.util.logging.Logger;

public class RotateCollector extends Command
{
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private double setpoint;
    private double lastSet;
    private Timer killTimer;
    private boolean timer = false;

    private Rotation rotation;
    private CANEncoder encoder;
    private OI oi;

    public static final Logger logger = Log.configureLog(RotateCollector.class.getName());

    
    private CollectorPID collectorPID;

    public RotateCollector() {

        logger.fine("Rotate Collector spin up");
        requires(Robot.rotation);
        this.rotation = Robot.rotation;
        this.encoder = rotation.collectorEncoder;
        this.oi = Robot.oi;
        collectorPID = new CollectorPID();
        killTimer = new Timer();
    }
    
    @Override
    protected void initialize() { 
        logger.finest("RotateCollector init");
        
    }

    @Override
    protected void execute() {

        logger.finest("Rotate Collector execute");
        a = oi.operatorController.xButton.get();
        b = oi.operatorController.yButton.get();
        c = oi.operatorController.bButton.get();
        d = oi.operatorController.aButton.get();
        e = oi.driverController.yButton.get();
        
        if(a && !b && !c && !d && !e){
            logger.fine("Collector BACK");
            setpoint = Constants.CollectorSetPoints.BACK;
        } else if(!a && b && !c && !d && !e){
            logger.fine("Collector MIDDLE");
            setpoint = Constants.CollectorSetPoints.MIDDLE;
        } else if(!a && !b && c && !d && !e) {
            logger.fine("Collector FRONT");
            setpoint = Constants.CollectorSetPoints.FRONT;
        } else if(!a && !b && !c && d && !e){
            logger.fine("Collector SHOOT");
            setpoint = Constants.CollectorSetPoints.SHOOT;
        } else if (!a && !b && !c && !d && e){
            logger.fine("Juggle!");
            setpoint = Constants.CollectorSetPoints.JUGGLE;
        }

        if(lastSet!=setpoint){
            newCom();
        }
    //     if(java.lang.Math.abs(rotation.collectorEncoder.getPosition() - setpoint) < .05 
    //         && (setpoint == Constants.CollectorSetPoints.FRONT || setpoint == Constants.CollectorSetPoints.BACK))
    //    {
    //        if(timer){
    //            killTimer.start();
    //            timer = true;
    //        }
    //        if(killTimer.get() > .5){
    //             System.out.println("killed");
    //             collectorPID.end();
    //             killTimer.reset();
    //             timer = false;
    //        }
    //    }
        lastSet = setpoint;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        logger.fine("Was interrupted");
        end();
    }

    @Override
    protected void end() {

        collectorPID.end();
    }

    private void newCom(){
        logger.fine("Collector PID New Command");
        if(encoder.getPosition() < setpoint){
            collectorPID.PIDForward(setpoint);
        } else {
            collectorPID.PIDBack(setpoint);
        }
    }
    private void steady(){
        collectorPID.PIDSteady(setpoint);
    }
}