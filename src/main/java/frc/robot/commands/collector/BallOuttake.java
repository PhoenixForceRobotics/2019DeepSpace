package frc.robot.commands.collector;

// import frc.robot.subsystems.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import frc.robot.Constants;
import frc.robot.utility.Log;
import edu.wpi.first.wpilibj.command.Command;
import java.util.logging.Logger;

public class BallOuttake extends Command
{
    private Collector collector;
    private static final Logger logger = Log.configureLog(BallOuttake.class.getName());

    public BallOuttake()
    {
        logger.fine("Spinup BallOuttake");
        requires(Robot.collector);
        this.collector = Robot.collector;
    }

    public void initialize() {
        logger.fine("Initialize BallOuttake");
        setTimeout(.2);
    }


    public void execute() {
        logger.finest("Excecute BallOuttake");
        collector.outtake(Constants.SubsystemSpeeds.BallCollectorValues.BCOuttakeSpeed);
    }


    public boolean isFinished()
    {
        logger.finest("BallOuttake is Finished");
        return isTimedOut();
    }

    @Override
    public void interrupted() {
        logger.fine("BallOuttake Interrupted");
        end();
    }
    
    public void end() {
        logger.fine("BallOuttake end");
        collector.outtake(0);
    }

}