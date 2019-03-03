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
        
    }

    @Override
    protected void execute()
    {
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
        climber.killPistons();
    }
}