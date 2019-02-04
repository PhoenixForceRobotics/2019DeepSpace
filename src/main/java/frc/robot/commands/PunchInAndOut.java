package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.PuncherHatchIn;
import frc.robot.commands.PuncherHatchOut;
import edu.wpi.first.wpilibj.command.CommandGroup;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class PunchInAndOut extends CommandGroup 
{

    private static final Logger logger = Log.configureLog(PunchInAndOut.class.getName());

    public PunchInAndOut() {
        logger.info("Punch in and out");
        addSequential(new PuncherHatchOut());
        addSequential(new PuncherHatchIn());
    }

   
}