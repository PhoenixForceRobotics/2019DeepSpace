package frc.robot.commands.rotation;

import frc.robot.Robot;
import frc.robot.subsystems.Rotation;
import frc.robot.subsystems.OI;
import frc.robot.Constants;
import frc.robot.commands.rotation.CollectorPID;
import edu.wpi.first.wpilibj.command.Command;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Timer;


public class RotateCollector extends Command
{
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private double setpoint;
    private double lastSet;
    private Timer killTimer;
    private boolean timer = false;

    private Rotation rotation;
    private CANEncoder encoder;
    private OI oi;
    
    private CollectorPID collectorPID;

    public RotateCollector() {
        requires(Robot.rotation);
        this.rotation = Robot.rotation;
        this.encoder = rotation.collectorEncoder;
        this.oi = Robot.oi;
        collectorPID = new CollectorPID();
        killTimer = new Timer();
    }
    
    @Override
    protected void initialize() { 
        
    }

    @Override
    protected void execute() {
        a = oi.operatorController.bButton.get();
        b = oi.operatorController.yButton.get();
        c = oi.operatorController.xButton.get();
        d = oi.operatorController.aButton.get();
        
        if(a && !b && !c && !d){
            setpoint = Constants.CollectorSetPoints.BACK;
        } else if(!a && b && !c && !d){
            setpoint = Constants.CollectorSetPoints.MIDDLE;
        } else if(!a && !b && c && !d) {
            setpoint = Constants.CollectorSetPoints.FRONT;
        } else if(!a && !b && !c && d){
            setpoint = Constants.CollectorSetPoints.SHOOT;
        }

        if(lastSet!=setpoint){
            newCom();
        }
        if(java.lang.Math.abs(rotation.collectorEncoder.getPosition() - setpoint) < .05 
            && (setpoint == Constants.CollectorSetPoints.FRONT || setpoint == Constants.CollectorSetPoints.BACK))
       {
           if(timer){
               killTimer.start();
               timer = true;
           }
           if(killTimer.get() > .5){
                System.out.println("killed");
                collectorPID.end();
                killTimer.reset();
                timer = false;
           }
       }
        lastSet = setpoint;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        collectorPID.end();
    }

    private void newCom(){
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