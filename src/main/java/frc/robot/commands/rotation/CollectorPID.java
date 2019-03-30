package frc.robot.commands.rotation;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Rotation;
import edu.wpi.first.wpilibj.command.PIDCommand;
import java.util.logging.Logger;
import frc.robot.utility.Log;


public class CollectorPID extends PIDCommand
{   
    private Rotation rotation;

    private static final Logger logger = Log.configureLog(CollectorPID.class.getName());

    public CollectorPID() {
        super(0,0,0);
        logger.fine("Collector PID Init");        
        requires(Robot.rotation);
        this.rotation = Robot.rotation;
    }
    
    @Override
    protected double returnPIDInput() {
        //System.out.println(rotation.collectorEncoder.getPosition());
        return rotation.collectorEncoder.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        rotation.collectorrotate.set(output);
        rotation.collectorrotate1.set(output);
    }

    public void PIDBack(double setpoint){
        logger.fine("Collector PID Back");
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.RotateCollectorPIDConstants.BACK.kp,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.BACK.ki,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.BACK.kd);
        super.getPIDController().enable();
        super.setSetpoint(setpoint);
    }

    public void PIDForward(double setpoint){
        logger.fine("Collector PID Forward");
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.RotateCollectorPIDConstants.FORWARD.kp,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.FORWARD.ki,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.FORWARD.kd);
        super.getPIDController().enable();
        super.setSetpoint(setpoint);
    }
    
    public void CollectorClimb(double setpoint){
        logger.fine("Collector PID Climb");
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.RotateCollectorPIDConstants.CLIMB.kp,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.CLIMB.ki,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.CLIMB.kd);
        super.getPIDController().enable();
        super.setSetpoint(setpoint);
    }

    public void PIDSteady(double setpoint){
        logger.fine("Collector PID Steady");
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.RotateCollectorPIDConstants.STEADY.kp,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.STEADY.ki,
                                        Constants.SubsystemSpeeds.RotateCollectorPIDConstants.STEADY.kd);
        super.getPIDController().enable();
        super.setSetpoint(setpoint);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        logger.fine("Collector PID End");
        super.getPIDController().disable();
    }
}