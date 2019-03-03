package frc.robot.commands.rotation;

import frc.robot.Robot;
import frc.robot.subsystems.Rotation;
import frc.robot.subsystems.OI;
import frc.robot.Constants;
import frc.robot.commands.rotation.CollectorPID;
import edu.wpi.first.wpilibj.command.Command;
import com.revrobotics.CANEncoder;


public class RotateCollector extends Command
{
    private boolean a;
    private boolean b;
    private boolean c;
    private double setpoint;
    private double lastSet;

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
    }
    
    @Override
    protected void initialize() {     

    }

    @Override
    protected void execute() {
        a = oi.operatorController.aButton.get();
        b = oi.operatorController.bButton.get();
        c = oi.operatorController.xButton.get();
        
        if(a && !b && !c){
            setpoint = Constants.CollectorSetPoints.BACK;
        } else if(!a && b && !c){
            setpoint = Constants.CollectorSetPoints.MIDDLE;
        } else if(!a && !b && c) {
            setpoint = Constants.CollectorSetPoints.FRONT;
        }

        if(lastSet!=setpoint){
            newCom();
        }
    //     if(java.lang.Math.abs(collector.collectorEncoder.getPosition() - setpoint) < .05)
    //    {
    //         steady();
    //    }
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