package frc.robot.commands.elevator;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Elevator;

//These are the imports for logging
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class ElevatorShifter extends Command
{
    Elevator elevator;
    char mode;

    public static final Logger logger = Log.configureLog(ElevatorShifter.class.getName());
    
    public ElevatorShifter(char mode){
        logger.fine("ElevatorShifter spin up");
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
        this.mode = mode;
    }

    @Override
    public void initialize()
    {
        //This makes the elevator go into ball or hatch mode wheter the char inputted is 'b' or 'h' respectively
        if(mode == 'b'){
            logger.info(" mode == 'b' -- Ball Mode");
            elevator.makeBallMode();
        } else if (mode == 'h'){
            logger.info(" mode == 'h' -- Hatch Mode");
            elevator.makeHatchMode();
        }
    }

    @Override
    public void execute()
    {
        logger.finest("Elevator Shifter executed");
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
        logger.fine("Was interrupted");
        end();
    }

    @Override
    public void end()
    {
        logger.fine("Ended");
        //This readds the run elevator command to the Scheduler because calling this command
        //on the elevator removes the previous instance of runElevator
        Robot.addRunElevator();
    }
}