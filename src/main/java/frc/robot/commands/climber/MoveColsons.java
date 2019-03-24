package frc.robot.commands.climber;

import frc.robot.Robot;
import frc.robot.subsystems.Climber;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.command.Command;

//These are the imports for logging
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class MoveColsons extends Command
{
    private Climber climber;
    public static final Logger logger = Log.configureLog(MoveColsons.class.getName());

    public MoveColsons()
    {
        logger.fine("MoveColsons SpinUp");
        requires(Robot.climber);
        this.climber = Robot.climber;
    }

    @Override
    protected void initialize()
    {
        logger.finest("MoveColsons Init");
        
    }

    @Override
    protected void execute()
    {
        logger.finest("MoveColsons was Executed");
        climber.move(Constants.SubsystemSpeeds.ClimberValues.ColsonSpeed);
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
        logger.fine("MoveColsons Was ended");
        climber.move(0);
    }
}