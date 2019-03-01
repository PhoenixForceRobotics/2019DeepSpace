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

    private boolean up;
    private boolean left;
    private boolean down;

    private ElevatorPID elevatorPID;
    
    public RunElevator() {
        requires(Robot.elevator);
        this.encoder = Robot.elevator.elevatorEncoder;
        this.elevator = Robot.elevator;
        this.oi = Robot.oi;
        System.out.println(this.oi);
        System.out.println(this.elevator);
        elevatorPID = new ElevatorPID();

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        up = oi.driverController.Dpad.Up.get();
        left = oi.driverController.Dpad.Left.get();
        down = oi.driverController.Dpad.Down.get();
        
        if(up && !left && !down){
            System.out.println("upupupupupupupup");
            elevatorPID.PIDUp(Constants.ElevatorSetPoints.TOP);
        } else if(!up && left && !down){
            System.out.println("leftleftleftleftleft");
            if(encoder.getPosition() > Constants.ElevatorSetPoints.MIDDLE){
                elevatorPID.PIDDown(Constants.ElevatorSetPoints.MIDDLE);
            }
            else if (encoder.getPosition() < Constants.ElevatorSetPoints.MIDDLE){
                elevatorPID.PIDUp(Constants.ElevatorSetPoints.MIDDLE);
            }
        } else if(!up && !left && down){
            System.out.println("downdowndowndowndowndown");
            elevatorPID.PIDDown(Constants.ElevatorSetPoints.BOTTOM);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        
    }

    @Override
    protected void end() {
        
    }
}