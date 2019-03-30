package frc.robot.commands.rotation;

import frc.robot.Robot;
import frc.robot.subsystems.Rotation;
import edu.wpi.first.wpilibj.command.Command;

//These are the loggin imports
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class Jenktate extends Command
{
    private Rotation rotation;
    public static final Logger logger = Log.configureLog(Jenktate.class.getName());

    public Jenktate()
    {
        logger.fine("Spinup Jenktate -- Jenky Rotation");
        requires(Robot.rotation);
        this.rotation = Robot.rotation;
    }

    @Override
    protected void initialize()
    {
        
    }

    @Override
    protected void execute()
    {
        logger.finest("Jenktate execute");
        rotation.janktateDown(-1);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void interrupted()
    {
      

    }

    @Override
    protected void end()
    {
        logger.fine("Jenktate end");
        rotation.janktateDown(0);
    }
}