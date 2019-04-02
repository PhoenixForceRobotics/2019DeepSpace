package frc.robot.commands.collector;

import frc.robot.commands.collector.PuncherHatchIn;
import frc.robot.commands.collector.PuncherHatchOut;
import edu.wpi.first.wpilibj.command.CommandGroup;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class PunchInAndOut extends CommandGroup 
{

    private static final Logger logger = Log.configureLog(PunchInAndOut.class.getName());

    //This pushes the punches out for a portion of a second then pulls them back in to pop the hatch out
    public PunchInAndOut() {
        logger.fine("Punch in and out");
        addSequential(new PuncherHatchIn());
        addSequential(new PuncherHatchOut());
    }

   
}