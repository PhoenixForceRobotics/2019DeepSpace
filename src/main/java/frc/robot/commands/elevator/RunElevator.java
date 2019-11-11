package frc.robot.commands.elevator;

import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.OI;
import frc.robot.Constants;
import frc.robot.commands.elevator.ElevatorPID;
import edu.wpi.first.wpilibj.command.Command;
import com.revrobotics.CANEncoder;

//These are the loggin imports
import java.util.logging.Logger;
import frc.robot.utility.Log;


public class RunElevator extends Command
{
    private Elevator elevator;
    private CANEncoder encoder;
    private OI oi;
    private double setpoint;
    private double lastSet;

    private boolean up;
    private boolean left;
    private boolean right;
    private boolean down;
    private boolean trueDown;

    private ElevatorPID elevatorPID;

    public static final Logger logger = Log.configureLog(RunElevator.class.getName());
    
    public RunElevator() {
        logger.fine("Spinup Run Elevator");
        requires(Robot.elevator);
        this.encoder = Robot.elevator.elevatorEncoder;
        this.elevator = Robot.elevator;
        this.oi = Robot.oi;
        elevatorPID = new ElevatorPID();
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        logger.finest("Run elevator execute");
        up = oi.operatorController.Dpad.Up.get();
        left = oi.operatorController.Dpad.Left.get();
        right = oi.operatorController.Dpad.Right.get();
        down = oi.operatorController.Dpad.Down.get();
        trueDown = oi.operatorController.rightStickButton.get();
        
        //This is the selector for the hight of the elevator. I know it can be abstracted 
        //somehow with strings but I don't want to mess with that
        //To see more information about the heights look at Constants.Java
        if(elevator.ballMode){
            if(up && !left && !right && !down && !trueDown){
                logger.fine("Top -- Balls");
                setpoint = Constants.ElevatorSetPoints.Balls.TOP;
            } else if(!up && left && !right && !down && !trueDown){
                logger.fine("Middle -- Balls");
                setpoint = Constants.ElevatorSetPoints.Balls.MIDDLE;
            } else if(!up && !left && right && !down && !trueDown){
                logger.fine("Center -- Balls");
                setpoint = Constants.ElevatorSetPoints.Balls.CENTER;
            } else if(!up && !left && !right && down && !trueDown){
                logger.fine("Bottom -- Balls");
                setpoint = Constants.ElevatorSetPoints.Balls.BOTTOM;
            } else if(!up && !left && !right && down && trueDown){
                logger.fine("TrueBottom -- Balls");
                setpoint = Constants.ElevatorSetPoints.Balls.TRUEBOTTOM;
            }
        } else {
            if(up && !left && !right && !down){
                logger.fine("TOP -- Hatches");
                setpoint = Constants.ElevatorSetPoints.Hatches.TOP;
            } else if(!up && left && !right && !down){
                logger.fine("Middle -- Hatches");
                setpoint = Constants.ElevatorSetPoints.Hatches.MIDDLE;
            } else if(!up && !left && !right && down){
                logger.fine("Bottom -- Hatches");
                setpoint = Constants.ElevatorSetPoints.Hatches.BOTTOM;
            }
        }
        //if the setpoint has changed it starts a new PID Command
        //This is essentially so that d and I don't continually reset
        if(lastSet != setpoint){
            newCom();
        }

        //Steady code wasn't working on comp bot which is why this is currently commented out

        //if(java.lang.Math.abs(elevator.elevatorEncoder.getPosition() - setpoint) < .01)
        //{
        //  steady();
        //}
        
        //This mechinsim makes it so the newCom function is only called once per setpoint change
        lastSet = setpoint;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        end();
    }

    //This kils the elevator PID function which is used every time the shifter is called
    //or when the climber drives the elevator down
    @Override
    protected void end() {
        logger.fine("Run Elevator End");
        elevatorPID.end();
    }

    //This will hold the elevator in its current position (in theory)
    //It was causing problems when we were using neos which is why it currently isn't used
    private void steady()
    {
        elevatorPID.PIDSteady(setpoint);
    }
    private void newCom(){
        logger.fine("New PID Command Being Called");
        if(encoder.getPosition() < setpoint){
            System.out.println("UP");
            logger.finest("Went up to setpoint");
            elevatorPID.PIDUp(setpoint);
        } else {
            System.out.println("DOWN");
            logger.finest("Went down to setpoint");
            elevatorPID.PIDDown(setpoint);
        }
    }
}