package frc.robot.commands;
//How to not be annoying 101, Do your work on time.
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.Command;

public class RunElevator1 extends Command 
{
    private Elevator elevator;

    public RunElevator1()
    {
        requires(Robot.elevator);

        this.elevator = Robot.elevator;
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {

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

    }
}