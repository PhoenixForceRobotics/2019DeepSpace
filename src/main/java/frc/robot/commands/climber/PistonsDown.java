package frc.robot.commands.climber;

import frc.robot.Robot;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.command.Command;

//These are the imports for logging
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class PistonsDown extends Command
{
    private Climber climber;
    public static final Logger logger = Log.configureLog(PistonsDown.class.getName());

    public PistonsDown()
    {
        logger.fine("PistonsDown SpinUp");
        requires(Robot.climber);
        this.climber = Robot.climber;
    }

    @Override
    protected void initialize()
    {
        logger.finest("PistonsDown init");
        //JT set timeout
        // setTimeout(2);
    }

    @Override
    protected void execute()
    {
        logger.finest("PistonsDown was executed");
        climber.levitate();
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void interrupted()
    {
        
        end();
    }

    @Override
    protected void end()
    {
        logger.fine("PistonsDown Was ended");
        climber.killPistons();
    }
}