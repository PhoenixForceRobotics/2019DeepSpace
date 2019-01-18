package frc.robot.subsystems;


import frc.controllers.BobXboxController;
import frc.robot.commands.RunHatchCollector;
import frc.robot.commands.CollectHatch;
import frc.robot.commands.HoldIntake;
import frc.robot.commands.BallOuttake;
//import frc.robot.commands.PrepBall;
//import frc.robot.commands.ShootFlywheel;

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

        operatorController.aButton.whenPressed(new RunHatchCollector());
        operatorController.bButton.whenPressed(new CollectHatch());
        driverController.leftBumper.whileHeld(new HoldIntake());
        operatorController.leftBumper.whenPressed(new BallOuttake());

    }

}