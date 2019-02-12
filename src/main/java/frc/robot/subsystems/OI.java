package frc.robot.subsystems;


import frc.controllers.BobXboxController;
import frc.robot.commands.RunHatchCollector;
import frc.robot.commands.CollectHatch;
import frc.robot.commands.RunElevator1;
import frc.robot.commands.RunElevator2;
//import frc.robot.commands.PrepBall;
//import frc.robot.commands.ShootFlywheel;
import frc.robot.commands.RunElevator3;

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
        operatorController = new BobXboxController(0, 0.10, 0.08);

        driverController.Dpad.Down.whenPressed(new RunElevator1());
        driverController.Dpad.Left.whenPressed(new RunElevator2());
        driverController.Dpad.Up.whenPressed(new RunElevator3());

        operatorController.aButton.whenPressed(new RunHatchCollector());
        operatorController.bButton.whenPressed(new CollectHatch());
    }

}