package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.BallCollector;
import frc.robot.Constants;
import frc.robot.utility.Log;
import edu.wpi.first.wpilibj.command.Command;
import java.util.logging.Logger;

public class BallHoldIntake extends Command
{
    private BallCollector ballCollector;
    private static final Logger logger = Log.configureLog(BallHoldIntake.class.getName());

    public BallHoldIntake()
    {
        logger.fine("Spinup BallHoldIntake");
        requires(Robot.ballCollector);
        this.ballCollector = Robot.ballCollector;
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {    
        logger.finest("Excecute BallHoldIntake");
        ballCollector.intake(Constants.SubsystemSpeeds.BallCollectorValues.BCIntakeSpeed);
    }

    @Override
    public boolean isFinished()
    {
        logger.finest("BallHoldIntake is finished");
        return false;
    }

    @Override
    public void interrupted()
    {
        logger.fine("BallHoldIntake interrupted");
        end();
    }

    @Override
    public void end()
    {
        logger.fine("BallHoldIntake end");
        ballCollector.intake(0);
        ballCollector.intake(0);
    }
}