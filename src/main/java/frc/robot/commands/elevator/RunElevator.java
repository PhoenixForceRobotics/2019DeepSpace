package frc.robot.commands.elevator;

import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.OI;
import frc.robot.Constants;
import frc.robot.commands.elevator.ElevatorPID;
import edu.wpi.first.wpilibj.command.Command;
import com.revrobotics.CANEncoder;


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
    
    public RunElevator() {
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
        up = oi.operatorController.Dpad.Up.get();
        left = oi.operatorController.Dpad.Left.get();
        right = oi.operatorController.Dpad.Right.get();
        down = oi.operatorController.Dpad.Down.get();
        trueDown = oi.operatorController.rightStickButton.get();
        
        //This is the selector for the hight of the elevator. I know it can be abstracted 
        //somehow with strings but I don't want to mess with that
        if(elevator.ballMode){
            if(up && !left && !right && !down && !trueDown){
                setpoint = Constants.ElevatorSetPoints.Balls.TOP;
            } else if(!up && left && !right && !down && !trueDown){
                setpoint = Constants.ElevatorSetPoints.Balls.MIDDLE;
            } else if(!up && !left && right && !down && !trueDown){
                setpoint = Constants.ElevatorSetPoints.Balls.CENTER;
            } else if(!up && !left && !right && down && !trueDown){
                setpoint = Constants.ElevatorSetPoints.Balls.BOTTOM;
            } else if(!up && !left && !right && down && trueDown){
                setpoint = Constants.ElevatorSetPoints.Balls.TRUEBOTTOM;
            }
        } else {
            if(up && !left && !right && !down){
                setpoint = Constants.ElevatorSetPoints.Hatches.TOP;
            } else if(!up && left && !right && !down){
                setpoint = Constants.ElevatorSetPoints.Hatches.MIDDLE;
            } else if(!up && !left && !right && down){
                setpoint = Constants.ElevatorSetPoints.Hatches.BOTTOM;
            }
        }
        if(lastSet != setpoint){
            newCom();
        }
    //    if(java.lang.Math.abs(elevator.elevatorEncoder.getPosition() - setpoint) < .01)
    //    {
    //         steady();
    //    }
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

    @Override
    protected void end() {
        elevatorPID.end();
    }

    //JT trying a steady routine
    // private void steady()
    // {
    //     elevatorPID.PIDSteady(setpoint);
    // }

    private void newCom(){
        if(encoder.getPosition() > setpoint){
            System.out.println("UP");
            elevatorPID.PIDUp(setpoint);
        } else {
            System.out.println("DOWN");
            elevatorPID.PIDDown(setpoint);
        }
    }
}