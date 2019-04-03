package frc.robot.commands.elevator;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Elevator;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//These are the imports for logging
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class ElevatorShifter extends Command
{
    
    Elevator elevator;
    char mode;
    private String modeString;

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
            logger.info("Elevator in Ball Mode");
            elevator.makeBallMode();
            modeString = "ball";
        } else if (mode == 'h'){
            logger.info("Elevator in Hatch Mode");
            elevator.makeHatchMode();
            modeString = "hatch";
        }
    }

    @Override
    public void execute()
    {
        // SmartDashboard.putString("Elevator Mode", modeString);
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
        logger.fine("Elevator Shifter Ended");
        //This re-adds the run elevator command to the Scheduler because calling this command
        //on the elevator removes the previous instance of runElevator
        Robot.addRunElevator();
    }
}