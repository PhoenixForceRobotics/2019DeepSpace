package frc.robot.commands.collector;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.PIDCommand;
import java.util.logging.Logger;
import frc.robot.utility.Log;


public class CollectorPID extends PIDCommand
{   
    private Collector collector;

    private static final Logger logger = Log.configureLog(CollectorPID.class.getName());

    public CollectorPID() {
        
        super(0,0,0);
        
        requires(Robot.collector);
        this.collector = Robot.collector;
    }
    
    @Override
    protected double returnPIDInput() {
        return collector.collectorEncoder.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        collector.collectorrotate.set(output);
    }

    public void PIDBack(double setpoint){
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.RotateCollectorPIDConstants.BACK.kp,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.BACK.ki,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.BACK.kd);
        super.getPIDController().enable();;
        super.setSetpoint(setpoint);
    }

    public void PIDForward(double setpoint){
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.RotateCollectorPIDConstants.FORWARD.kp,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.FORWARD.ki,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.FORWARD.kd);
        super.getPIDController().enable();
        super.setSetpoint(setpoint);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        super.getPIDController().disable();
    }
}