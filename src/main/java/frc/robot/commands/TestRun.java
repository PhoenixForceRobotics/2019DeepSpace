package frc.robot.commands;

import frc.robot.subsystems.OI;
import frc.robot.subsystems.Test;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

//Default command for drivebase during Teleop
public class TestRun extends Command
{
    private Test test;
    private OI oi;

    public TestRun()
    {
        requires(Robot.test);

        this.test = Robot.test;
        this.oi = Robot.oi;
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {   
        test.setTest(1);
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
        test.setTest(0);
    }
}
