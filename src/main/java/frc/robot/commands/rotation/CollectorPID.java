package frc.robot.commands.rotation;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Rotation;
import frc.robot.subsystems.OI;
import edu.wpi.first.wpilibj.command.PIDCommand;
import java.util.logging.Logger;
import frc.robot.utility.Log;


public class CollectorPID extends PIDCommand
{   
    private Rotation rotation;
    private OI oi;
    private double fineControl;
    private double newOutput;

    private static final Logger logger = Log.configureLog(CollectorPID.class.getName());

    public CollectorPID() {
        super(0,0,0);
        logger.info("Collector PID Init");        
        requires(Robot.rotation);
        this.rotation = Robot.rotation;
        this.oi = Robot.oi;
    }
    
    @Override
    protected double returnPIDInput() {
        //System.out.println(rotation.collectorEncoder.getPosition());
        //logger.severe("issue: " + rotation.collectorEncoder.getPosition());
        return rotation.collectorEncoder.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        fineControl = -oi.operatorController.leftStick.getX();
        newOutput = output + fineControl;
        rotation.collectorrotate.set(newOutput);
        rotation.collectorrotate1.set(newOutput);
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