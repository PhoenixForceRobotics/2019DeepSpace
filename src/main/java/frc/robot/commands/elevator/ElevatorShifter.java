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
        //This makes the elevator go into ball or hatch mode wheter the char inputted is 'b' or 'h' respectively
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
        //This makes it so the intialize runs and then the method ends
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
        //This readds the run elevator command to the Scheduler because calling this command
        //on the elevator removes the previous instance of runElevator
        Robot.addRunElevator();
    }
}