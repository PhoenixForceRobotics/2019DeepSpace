package frc.robot.subsystems;


import frc.controllers.BobXboxController;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{

    public BobXboxController driverController;
    public BobXboxController operatorController;

    public OI() {
        driverController = new BobXboxController(0, 0.10, 0.08);
        //operatorController = new BobXboxController(0, 0.10, 0.08);

        driverController.leftTriggerButton.whileHeld(new RunHDrive());
        driverController.rightTriggerButton.whileHeld(new RunHDrive());

        //operatorController.aButton.whenPressed(new RunHatchCollector());
        //operatorController.bButton.whenPressed(new CollectHatch());
        driverController.leftBumper.whileHeld(new BallHoldIntake());
        driverController.rightBumper.whenPressed(new BallOuttake());
        driverController.xButton.whenPressed(new RotateBallCollector());

        driverController.aButton.whenPressed(new PuncherHatchOut());
//        driverController.aButton.whenPressed(new PuncherHatchOut());
//        driverController.bButton.whenPressed(new PuncherHatchIn());
        driverController.aButton.whenPressed(new PunchInAndOut());
        driverController.bButton.whenPressed(new PuncherHatchIn());

        driverController.yButton.whenPressed(new RunHatchCollector());
        driverController.xButton.whenPressed(new CollectHatch());  

        operatorController.aButton.whenPressed(new RunHatchCollector());
        operatorController.bButton.whenPressed(new CollectHatch());
        
        driverController.Dpad.Down.whenPressed(new RunElevator1());
        driverController.Dpad.Left.whenPressed(new RunElevator2());
        driverController.Dpad.Up.whenPressed(new RunElevator3());
    }

}