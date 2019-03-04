package frc.robot.subsystems;

import frc.controllers.BobXboxController;
import frc.robot.commands.climber.CheckButtons;
import frc.robot.commands.climber.PistonsDown;
import frc.robot.commands.climber.PistonsUp;
import frc.robot.commands.climber.RotateandShoot;
import frc.robot.commands.collector.*;
import frc.robot.commands.drivebase.*;
import frc.robot.commands.elevator.*;
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
        operatorController = new BobXboxController(1, 0.11, 0.11);

        //driverController Commands
        driverController.leftTriggerButton.whileHeld(new RunHDrive());
        driverController.rightTriggerButton.whileHeld(new RunHDrive());

        //JT trying to break the pistons
        //driverController.startButton.whenPressed(new PistonsDown());
        //JT retracting permissions
        //driverController.selectButton.whenPressed(new PistonsUp());
        driverController.leftBumper.whileHeld(new PinControl('u'));
        driverController.rightBumper.whileHeld(new PinControl('d'));

        driverController.rightStickButton.whenPressed(new Shifter());
        
        //operatorController Commands
        operatorController.selectButton.whenPressed(new ElevatorShifter('h'));
        operatorController.startButton.whenPressed(new ElevatorShifter('b'));

        operatorController.rightBumper.whileHeld(new BallHoldIntake());
        operatorController.leftBumper.whileHeld(new BallHoldOuttake());

        operatorController.rightTriggerButton.whenPressed(new PunchInAndOut());

        driverController.startButton.whileHeld(new RotateandShoot());
        driverController.selectButton.whenPressed(new PistonsDown());
    }
}