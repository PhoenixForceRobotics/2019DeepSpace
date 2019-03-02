package frc.robot.commands.elevator;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Elevator;

public class ElevatorShifter extends Command
{
    Elevator elevator;
    public ElevatorShifter(){
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
    }

    @Override
    public void initialize()
    {
        elevator.elevatorShift();
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        return true;
    }

    @Override
    public void interrupted()
    {
        end();
    }

    @Override
    public void end()
    {
        Robot.addRunElevator();
    }
}