package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import frc.robot.Constants;
import frc.robot.utility.Log;
import edu.wpi.first.wpilibj.command.Command;
import java.util.logging.Logger;

public class BallHoldOuttake extends Command
{
    private Collector collector;
    private static final Logger logger = Log.configureLog(BallHoldOuttake.class.getName());

    public BallHoldOuttake()
    {
        logger.fine("Spinup BallHoldOuttake");
        requires(Robot.collector);
        this.collector = Robot.collector;
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {    
        logger.finest("Excecute BallHoldOuttake");
        collector.outtake(Constants.SubsystemSpeeds.BallCollectorValues.BCOuttakeSpeed);
    }

    @Override
    public boolean isFinished()
    {
        logger.finest("BallHoldOuttake is finished");
        return false;
    }

    @Override
    public void interrupted()
    {
      
        end();
    }

    @Override
    public void end()
    {
        logger.fine("BallHoldOuttake end");
        collector.intake(0);
    }
}