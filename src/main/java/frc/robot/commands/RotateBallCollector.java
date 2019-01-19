package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.BallCollector;

import edu.wpi.first.wpilibj.command.Command;

public class RotateBallCollector extends Command
{
    private BallCollector ballCollector;

    public RotateBallCollector()
    {
        requires(ballCollector);
        this.ballCollector = Robot.ballCollector;
    }

    @Override
    public void initialize()
    {
        setTimeout(.6);
    }

    @Override
    public void execute()
    {    
        ballCollector.rotate(1);
    }

    @Override
    public boolean isFinished()
    {
        return isTimedOut();
    }

    @Override
    public void interrupted()
    {
        end();
    }

    @Override
    public void end()
    {
        ballCollector.rotate(0);
    }
}