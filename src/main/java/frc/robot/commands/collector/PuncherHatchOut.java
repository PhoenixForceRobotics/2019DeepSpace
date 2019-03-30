package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.Command;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class PuncherHatchOut extends Command 
{
    private Collector hatchCollector;

    private static final Logger logger = Log.configureLog(PuncherHatchOut.class.getName());
    
    public PuncherHatchOut()
    {
        logger.fine("Spinup Puncher Hatch Out");
        requires(Robot.collector);

        this.hatchCollector = Robot.collector;
    } 

    @Override
    public void initialize()
    {
        logger.fine("Hatch Collector puncher out initialize");
        setTimeout(.3);
    }
  
    @Override
    public void execute()
    {
        logger.finest("Hatch Collector puncher out execute");
        hatchCollector.pinDown();
    }

    @Override 
    public boolean isFinished()
    {
        return isTimedOut();
    }

    @Override
    public void interrupted()
    {
        
        end();
    }

    @Override
    public void end()
    {
        logger.fine("Hatch Collector puncher out end");
        hatchCollector.pinOff();
    }
}