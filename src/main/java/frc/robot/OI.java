package frc.robot;


import frc.controllers.BobXboxController;
import frc.robot.commands.HoldIntake;
import frc.robot.commands.PrepBall;
import frc.robot.commands.ShootFlywheel;
import frc.robot.commands.HoldIntake;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{

    public BobXboxController theXboxController;

    public OI() {
        //Not sure the exact impact of these constants passed into constructor.  They probably need to be adjusted
        //for our controllers.
        theXboxController = new BobXboxController(0, 0.10, 0.08);

        theXboxController.xButton.whenPressed(new PrepBall());
        theXboxController.rightTriggerButton.whenPressed(new ShootFlywheel());
        theXboxController.leftBumper.whileHeld(new HoldIntake());

    }

}