package frc.robot.subsystems;

import frc.controllers.BobXboxController;
import frc.robot.commands.collector.*;
import frc.robot.commands.drivebase.*;
import frc.robot.commands.elevator.*;
import frc.robot.Constants;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{

    public BobXboxController driverController;
    public BobXboxController operatorController;

    public OI() {
        driverController = new BobXboxController(0, 0.11, 0.11);
        //operatorController = new BobXboxController(0, 0.10, 0.08);

        driverController.leftTriggerButton.whileHeld(new RunHDrive());
        driverController.rightTriggerButton.whileHeld(new RunHDrive());
        
        driverController.Dpad.Up.whenPressed(new RunElevator());
        driverController.Dpad.Left.whenPressed(new RunElevator());
        driverController.Dpad.Down.whenPressed(new RunElevator());

<<<<<<< HEAD
        driverController.aButton.whileHeld(new BallHoldIntake());
        driverController.bButton.whileHeld(new BallOuttake());
=======
        driverController.leftBumper.whenPressed(new RotateCollector());
        driverController.rightBumper.whenPressed(new RotateCollector());

        driverController.aButton.whileHeld(new BallHoldIntake());
        driverController.bButton.whileHeld(new BallHoldOuttake());

        driverController.rightStickButton.whenPressed(new Shifter());
>>>>>>> e22f6a396d96277ec0a8915ebd8499d536e27bfd
    }
}