package frc.robot.commands.rotation;

import frc.robot.Robot;
import frc.robot.subsystems.Rotation;
import edu.wpi.first.wpilibj.command.Command;

public class Jenktate extends Command
{
    private Rotation rotation;

    public Jenktate()
    {
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
        rotation.janktateDown(1);
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
        rotation.janktateDown(0);
    }
}