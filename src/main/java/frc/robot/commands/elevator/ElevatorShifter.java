package frc.robot.commands.elevator;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Elevator;

public class ElevatorShifter extends Command
{
    Elevator elevator;
    char mode;
    public ElevatorShifter(char mode){
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
        this.mode = mode;
    }

    @Override
    public void initialize()
    {
        if(mode == 'b'){
            elevator.makeBallMode();
        } else if (mode == 'h'){
            elevator.makeHatchMode();
        }
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