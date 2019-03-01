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

    public OI() {
        driverController = new BobXboxController(0, 0.11, 0.11);
        //operatorController = new BobXboxController(0, 0.10, 0.08);

        driverController.leftTriggerButton.whileHeld(new RunHDrive());
        driverController.rightTriggerButton.whileHeld(new RunHDrive());

        driverController.aButton.whileHeld(new BallHoldOuttake());
        driverController.bButton.whileHeld(new BallHoldIntake());

        driverController.rightStickButton.whenPressed(new Shifter());
    }
}