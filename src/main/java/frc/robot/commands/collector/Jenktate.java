package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.Command;

public class Jenktate extends Command
{
    private Collector collector;

    public Jenktate()
    {
        requires(Robot.collector);
        this.collector = Robot.collector;
    }

    @Override
    protected void initialize()
    {
        
    }

    @Override
    protected void execute()
    {
        collector.janktateDown(1);
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
        collector.janktateDown(0);
    }
}