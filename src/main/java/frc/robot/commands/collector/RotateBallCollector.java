package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import frc.robot.Constants;
import frc.robot.utility.Log;
import java.util.logging.Logger;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class RotateBallCollector extends PIDCommand
{
    private Collector collector;
    private static final Logger logger = Log.configureLog(RotateBallCollector.class.getName());

    public RotateBallCollector()
    {
        super("RotateBallCollector", Constants.SubsystemSpeeds.RotateBallCollectorPIDConstants.kp, Constants.SubsystemSpeeds.RotateBallCollectorPIDConstants.ki, Constants.SubsystemSpeeds.RotateBallCollectorPIDConstants.kd);
        logger.fine("Spinup RotateBallCollector");
        requires(Robot.collector);
        this.collector = Robot.collector;
    }

    @Override
    protected double returnPIDInput() {
    //TODO put encoder here
        return 0;
    }

    @Override
    protected void usePIDOutput(double output) {
        
    }

    @Override
    public void initialize()
    {
        logger.fine("Initialize RotateBallCollector");
        setTimeout(.6);
    }

    @Override
    public void execute()
    {  
        logger.finest("Execute RotateBallCollector");  
        collector.rotate(Constants.SubsystemSpeeds.BallCollectorValues.BCRotateSpeed);
    }

    @Override
    public boolean isFinished()
    {
        logger.finest("RotateBallCollector isFinished");
        return isTimedOut();
    }

    @Override
    public void interrupted()
    {
        logger.fine("RotateBallCollector interrupted");
        end();
    }

    @Override
    public void end()
    {
        logger.fine("end RotateBallCollector");
        collector.rotate(0);
    }
}