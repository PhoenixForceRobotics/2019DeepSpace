package frc.robot.commands.drivebase;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivebase;

//These are the imports for logging
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class Shifter extends Command
{
    Drivebase mydrive;
    public static final Logger logger = Log.configureLog(Shifter.class.getName());

    public Shifter(){
        logger.finest("Shifer spinup");
        requires(Robot.drivebase);
        this.mydrive = Robot.drivebase;
    }

    //This shifts the drivebase from full power to .25 power or the other way around
    @Override
    public void initialize()

    {
        logger.finest("Shifter init");
        mydrive.shift();
    }

    @Override
    public void execute()
    {
        logger.finest("Shifter was executed");
    }

    @Override
    public boolean isFinished()
    {
        
        return true;
    }

    @Override
    public void interrupted()
    {
    
        end();
    }

    @Override
    public void end()
    {
        logger.fine("Shifter was ended");
        Robot.addDriveBase();
    }
}