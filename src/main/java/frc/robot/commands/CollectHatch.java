package frc.robot.commands;
//Evan is the coolest Senior Ever™
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.HatchCollector;
import edu.wpi.first.wpilibj.command.Command;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class CollectHatch extends Command
{
    private HatchCollector hatchCollector;
    public static final Logger logger = Log.configureLog(CollectHatch.class.getName());
    
    public CollectHatch()
    {
        logger.fine("Spinup CollectHatch");
        requires(Robot.hatchCollector);

        this.hatchCollector = Robot.hatchCollector;
    }

    @Override
    public void initialize()
    {
        logger.fine("CollectHatch Initialize"); 
        setTimeout(.1);
    }

    @Override
    public void execute()
    {
        logger.finest("CollectHatch Execute(＾ω＾)");
//      System.out.println("Hello! Collecting Hatches... (＾ω＾)");
        hatchCollector.liftHatch();
    }

    @Override
    public boolean isFinished()
    {
        return isTimedOut();
    }

    @Override
    public void interrupted()
    {
        logger.fine("CollectHatch Interrupted");
        end();
    }

    @Override
    public void end()
    {
        logger.fine("(◕‿◕✿)");
//      System.out.println("(◕‿◕✿)");
        hatchCollector.stopHatch();
    }
}