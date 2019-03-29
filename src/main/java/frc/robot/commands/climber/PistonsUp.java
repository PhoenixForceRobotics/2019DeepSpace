package frc.robot.commands.climber;

import frc.robot.Robot;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.command.Command;

public class PistonsUp extends Command
{
    private Climber climber;

    public PistonsUp()
    {
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
        climber.killPistons();
    }
}