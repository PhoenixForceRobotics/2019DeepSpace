package frc.robot.commands;

import frc.robot.subsystems.BallCollector;

import edu.wpi.first.wpilibj.command.Command;

public class HoldIntake extends Command
{
    private BallCollector ballCollector;

    public HoldIntake()
    {
        requires(ballCollector);
        this.ballCollector = ballCollector;
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {    
        ballCollector.intake(1);
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void interrupted()
    {
        end();
    }

    @Override
    public void end()
    {
        ballCollector.intake(0);
        ballCollector.intake(0);
    }
}