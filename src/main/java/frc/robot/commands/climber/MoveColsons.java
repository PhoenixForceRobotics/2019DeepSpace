package frc.robot.commands.climber;

import frc.robot.Robot;
import frc.robot.subsystems.Climber;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.command.Command;

public class MoveColsons extends Command
{
    private Climber climber;

    public MoveColsons()
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
        climber.move(0);
    }
}