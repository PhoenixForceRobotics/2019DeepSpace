package frc.robot.commands.rotation;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Rotation;
import edu.wpi.first.wpilibj.command.PIDCommand;
import java.util.logging.Logger;
import frc.robot.utility.Log;


public class CollectorClimb extends PIDCommand
{   
    private Rotation rotation;

    private static final Logger logger = Log.configureLog(CollectorClimb.class.getName());

    public CollectorClimb() {
        super(Constants.SubsystemSpeeds.RotateCollectorPIDConstants.CLIMB.kp,
                Constants.SubsystemSpeeds.RotateCollectorPIDConstants.CLIMB.ki,
                Constants.SubsystemSpeeds.RotateCollectorPIDConstants.CLIMB.kd);        
        requires(Robot.rotation);
        this.rotation = Robot.rotation;
        super.getPIDController().enable();
        super.setSetpoint(Constants.CollectorSetPoints.CLIMB);
    }
    
    @Override
    protected double returnPIDInput() {
        // System.out.println("climbinggggg");
        return rotation.collectorEncoder.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        rotation.collectorrotate.set(output);
        rotation.collectorrotate1.set(output);
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