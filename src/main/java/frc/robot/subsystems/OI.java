package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import frc.controllers.BobXboxController;
import frc.robot.commands.collector.*;
import frc.robot.commands.drivebase.*;
import frc.robot.commands.elevator.*;
import frc.robot.Robot;
import frc.robot.Constants;
import com.revrobotics.CANEncoder;
// import frc.robot.Constants;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
    public BobXboxController driverController;
    public BobXboxController operatorController;

    private CANEncoder elevatorEncoder;
    private boolean up;
    private boolean left;
    private boolean down;
    private boolean a;
    private boolean b;

    public OI() {
        this.elevatorEncoder = Robot.elevator.elevatorEncoder;
        driverController = new BobXboxController(0, 0.11, 0.11);
        //operatorController = new BobXboxController(0, 0.10, 0.08);

        driverController.leftTriggerButton.whileHeld(new RunHDrive());
        driverController.rightTriggerButton.whileHeld(new RunHDrive());

        driverController.aButton.whileHeld(new BallHoldIntake());
        driverController.bButton.whileHeld(new BallHoldOuttake());

        driverController.rightStickButton.whenPressed(new Shifter());

    }
    // private void elevator(){
    //     up = driverController.Dpad.Up.get();
    //     left = driverController.Dpad.Left.get();
    //     down = driverController.Dpad.Down.get();

    //     if(up && !left && !down){
    //         new RunElevatorUp(Constants.ElevatorSetPoints.TOP);
    //     } else if(!up && left && !down){
    //         if(elevatorEncoder.getPosition() > Constants.ElevatorSetPoints.MIDDLE){
    //             new RunElevatorDown(Constants.ElevatorSetPoints.MIDDLE);
    //         }
    //         else if (elevatorEncoder.getPosition() < Constants.ElevatorSetPoints.MIDDLE){
    //             new RunElevatorUp(Constants.ElevatorSetPoints.MIDDLE);
    //         }
    //     } else if(!up && !left && down){
    //         driverController.Dpad.Up.whenPressed(new RunElevatorDown(Constants.ElevatorSetPoints.BOTTOM));
    //     }
    // }
    // private void collectorRotate(){
    //     a = driverController.leftBumper.get();
    //     b = driverController.rightBumper.get();
    //     if(a && !b){
    //         new RotateUp(Constants.CollectorSetPoints.UP);
    //     } else if(!a && b){
    //         new RotateDown(Constants.CollectorSetPoints.DOWN);
    //     }
    // }
}