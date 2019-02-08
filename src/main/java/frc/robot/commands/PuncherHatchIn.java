package frc.robot.commands;

// import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.HatchCollector;
import edu.wpi.first.wpilibj.command.Command;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class PuncherHatchIn extends Command 
{
    private HatchCollector hatchCollector;

    private static final Logger logger = Log.configureLog(PuncherHatchIn.class.getName());
    
    public PuncherHatchIn()
    {
        logger.fine("Spinup Puncher Hatch In");
        requires(Robot.hatchCollector);

        this.hatchCollector = Robot.hatchCollector;
    } 

    @Override
    public void initialize()
    {
        logger.fine("Hatch Collector puncher in initialize");
        setTimeout(.1);
    }
  
    @Override
    public void execute()
    {
        logger.finest("Hatch Collector puncher in execute");
        hatchCollector.puncherControl('i');
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
        logger.fine("Hatch Collector puncher end");
        hatchCollector.puncherControl('n');
    }
}