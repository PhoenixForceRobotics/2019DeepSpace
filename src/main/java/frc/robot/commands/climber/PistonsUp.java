package frc.robot.commands.climber;

import frc.robot.Robot;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.command.Command;

//These are the imports for loggin
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class PistonsUp extends Command
{
    private Climber climber;
    public static final Logger logger = Log.configureLog(PistonsUp.class.getName());

    public PistonsUp()
    {
        logger.fine("PistonsUp SpinUp");
        requires(Robot.climber);
        this.climber = Robot.climber;
    }

    @Override
    protected void initialize()
    {
        setTimeout(2);
    }

    @Override
    protected void execute()
    {
        logger.finest("Climber.unlevitate");
        climber.unlevitate();
    }

    @Override
    protected boolean isFinished()
    {
     
        return isTimedOut();
    }

    @Override
    protected void interrupted()
    {
       
        end();
    }

    @Override
    protected void end()
    {
        logger.fine("PistonsUp Was ended");
        climber.killPistons();
    }
}