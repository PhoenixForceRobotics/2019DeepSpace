package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import frc.robot.Constants;
import frc.robot.utility.Log;
import edu.wpi.first.wpilibj.command.Command;
import java.util.logging.Logger;

public class BallHoldIntake extends Command
{
    private Collector collector;
    private static final Logger logger = Log.configureLog(BallHoldIntake.class.getName());

    public BallHoldIntake()
    {
        logger.fine("Spinup BallHoldIntake");
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
        logger.finest("Excecute BallHoldIntake");
        collector.intake(1);
    }

    @Override
    public boolean isFinished()
    {
        logger.finest("BallHoldIntake is finished");
        return false;
    }

    @Override
    public void interrupted()
    {
        logger.fine("BallHoldIntake interrupted");
        end();
    }

    @Override
    public void end()
    {
        logger.fine("BallHoldIntake end");
        collector.intake(0);
        collector.intake(0);
    }
}