package frc.robot.commands.elevator;

import frc.robot.Robot;
import frc.robot.Constants;
import frc.robot.commands.elevator.RunElevatorUp;
import frc.robot.commands.elevator.RunElevatorDown;
import edu.wpi.first.wpilibj.command.CommandGroup;
import com.revrobotics.CANEncoder;


public class RunElevator extends CommandGroup 
{
    private boolean a;
    private boolean b;
    private boolean c;
    private CANEncoder encoder;
    
    public RunElevator() {

        a = Robot.oi.driverController.Dpad.Up.get();
        b = Robot.oi.driverController.Dpad.Left.get();
        c = Robot.oi.driverController.Dpad.Down.get();
        this.encoder = Robot.elevator.elevatorEncoder;

        if(a && !b && !c){
            new RunElevatorUp(Constants.ElevatorSetPoints.TOP);
        } else if(!a && b && !c){
            if(encoder.getPosition() > Constants.ElevatorSetPoints.MIDDLE){
                new RunElevatorDown(Constants.ElevatorSetPoints.MIDDLE);
            }
            else if (encoder.getPosition() < Constants.ElevatorSetPoints.MIDDLE){
                new RunElevatorUp(Constants.ElevatorSetPoints.MIDDLE);
            }
        } else if(!a && !b && c){
            new RunElevatorDown(Constants.ElevatorSetPoints.BOTTOM);
        }
    }
}