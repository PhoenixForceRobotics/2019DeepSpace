package frc.robot.subsystems;


import frc.controllers.BobXboxController;
import frc.robot.commands.collector.*;
import frc.robot.commands.drivebase.*;

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

        driverController.xButton.whenPressed(new PunchInAndOut());
        driverController.aButton.whenPressed(new PuncherHatchOut());
        driverController.bButton.whenPressed(new PuncherHatchIn());

<<<<<<< HEAD
        driverController.yButton.whenPressed(new RunHatchCollector());
        driverController.xButton.whenPressed(new CollectHatch());  

        operatorController.aButton.whenPressed(new RunHatchCollector());
        operatorController.bButton.whenPressed(new CollectHatch());
        
        driverController.Dpad.Down.whenPressed(new RunElevator1());
        driverController.Dpad.Left.whenPressed(new RunElevator2());
        driverController.Dpad.Up.whenPressed(new RunElevator3());
=======
        driverController.yButton.whileHeld(new Rotate());
>>>>>>> 9bc42461d7996d6c79d9b77887d58b2c30728c37
    }
}