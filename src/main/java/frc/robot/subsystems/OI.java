package frc.robot.subsystems;

import frc.controllers.BobXboxController;
import frc.robot.Constants;
import frc.robot.commands.collector.*;
import frc.robot.commands.drivebase.*;
import frc.robot.commands.elevator.*;
import frc.robot.commands.rotation.*;
import frc.robot.commands.climber.*;
// import frc.robot.Constants;
import frc.robot.commands.rotation.ClimbingPID;

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
        /** 
         * Driver Controller Commands
         */
        driverController.leftTriggerButton.whileHeld(new RunHDrive());
        driverController.rightTriggerButton.whileHeld(new RunHDrive());

        //'u' indicates up so it pushed the pins in
        //'d' indicates down so it puts the pistons against the ground
        driverController.leftBumper.whileHeld(new PinControl('u'));
        driverController.rightBumper.whileHeld(new PinControl('d'));

        //This shifts the robot between full, and lowered speed
        driverController.rightStickButton.whenPressed(new Shifter());
        
        /** 
         * Operator Controller Commands
         */
        //'h' indicates hatch mode and 'b' indicates ball mode so it changes what elevator 
        //setpoints are targeted when the button is pressed
        operatorController.selectButton.whenPressed(new ElevatorShifter('h'));
        operatorController.startButton.whenPressed(new ElevatorShifter('b'));

        operatorController.rightBumper.whileHeld(new BallHoldIntake());
        operatorController.leftBumper.whileHeld(new BallHoldOuttake());

        operatorController.rightTriggerButton.whenPressed(new PunchInAndOut());

        //operatorController.leftTriggerButton.whenPressed(new ClimbSequence());
        //driverController.selectButton.whenPressed(new PistonsDown());
        // driverController.aButton.whileHeld(new ClimbingPID(Constants.CollectorSetPoints.CLIMB));
        // driverController.bButton.whileHeld(new ClimbSequence());
    }
}