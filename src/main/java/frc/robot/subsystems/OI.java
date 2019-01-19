package frc.robot.subsystems;


import frc.controllers.BobXboxController;
import frc.robot.commands.RunHatchCollector;
import frc.robot.commands.CollectHatch;
import frc.robot.commands.RunHDrive;

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
    }

}