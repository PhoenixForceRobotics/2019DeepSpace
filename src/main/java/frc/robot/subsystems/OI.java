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

<<<<<<< HEAD
<<<<<<< HEAD
=======
        //operatorController.aButton.whenPressed(new RunHatchCollector());
        //operatorController.bButton.whenPressed(new CollectHatch());
>>>>>>> HatchCollector
=======
        //operatorController.aButton.whenPressed(new RunHatchCollector());
        //operatorController.bButton.whenPressed(new CollectHatch());
>>>>>>> 7e3bd6233ce39c0610d010e9bc76f12bf43c61f1
        driverController.leftBumper.whileHeld(new BallHoldIntake());
        driverController.rightBumper.whenPressed(new BallOuttake());
        driverController.xButton.whenPressed(new RotateBallCollector());

<<<<<<< HEAD
<<<<<<< HEAD
        driverController.aButton.whenPressed(new PuncherHatchOut());
=======
//        driverController.aButton.whenPressed(new PuncherHatchOut());
//        driverController.bButton.whenPressed(new PuncherHatchIn());
        driverController.aButton.whenPressed(new PunchInAndOut());
>>>>>>> HatchCollector
=======
        driverController.aButton.whenPressed(new PuncherHatchOut());
//        driverController.aButton.whenPressed(new PuncherHatchOut());
//        driverController.bButton.whenPressed(new PuncherHatchIn());
        driverController.aButton.whenPressed(new PunchInAndOut());
>>>>>>> 7e3bd6233ce39c0610d010e9bc76f12bf43c61f1
        driverController.bButton.whenPressed(new PuncherHatchIn());

        driverController.yButton.whenPressed(new RunHatchCollector());
        driverController.xButton.whenPressed(new CollectHatch());
        driverController.leftStickButton.whileHeld(new RunCompressor());  
    }

}