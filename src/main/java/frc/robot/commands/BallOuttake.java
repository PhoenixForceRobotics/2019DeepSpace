package frc.robot.commands;

// import frc.robot.subsystems.OI;
import frc.robot.Robot;
import frc.robot.subsystems.BallCollector;
import edu.wpi.first.wpilibj.command.Command;

public class BallOuttake extends Command
{
    private BallCollector ballCollector;
    // private OI oi;

    public BallOuttake()
    {
        requires(Robot.ballCollector);
        this.ballCollector = Robot.ballCollector;
    }

    public void initialize() {
        // this.oi = Robot.oi;
        setTimeout(.2);
    }


    public void execute() {
        System.out.println("executing...");
        ballCollector.outtake(1);
    }


    public boolean isFinished()
    {
        return isTimedOut();
    }


    public void end() {
        ballCollector.outtake(0);
    }

    @Override
    public void interrupted() {
        end();
    }
}