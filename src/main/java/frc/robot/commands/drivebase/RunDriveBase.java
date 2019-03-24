package frc.robot.commands.drivebase;

import frc.robot.subsystems.OI;
import frc.robot.subsystems.Drivebase;

import java.util.logging.Logger;
import frc.robot.Robot;
import frc.robot.utility.Log;
import frc.robot.Constants;
import frc.robot.utility.CustomMath;

import edu.wpi.first.wpilibj.command.Command;

//Default command for drivebase during Teleop
public class RunDriveBase extends Command
{
    private Drivebase drivebase;
    private OI oi;
    private CustomMath customMath;
    private double multiplier;

    private static final Logger logger = Log.configureLog(RunDriveBase.class.getName());

    public RunDriveBase()
    {
<<<<<<< HEAD
        logger.fine("Spinup RunDriveBase");
        requires(drivebase);
=======
        logger.fine("Spinup Run Drive Base");
        requires(Robot.drivebase);
>>>>>>> 9e6001c5f4ca01b747fad68bbc65bcfd291d6e60
        customMath = new CustomMath();

        drivebase = Robot.drivebase;
        oi = Robot.oi;
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {   
        logger.finest("RunDriveBase Execute");
        //tank drive controls; multiplier is for lowering the speed for greater control
        //The make sign function is to make sure no matter the power the output is in the same direction as the joystick is pushed
        multiplier = drivebase.getMultiplier();
        drivebase.setLeft(customMath.makeSign(oi.driverController.rightStick.getY(), 
                            multiplier * Math.pow(oi.driverController.rightStick.getY(), Constants.SubsystemSpeeds.DrivebaseValues.StickPower)));
        drivebase.setRight(customMath.makeSign(oi.driverController.leftStick.getY(), 
                            multiplier * Math.pow(oi.driverController.leftStick.getY(), Constants.SubsystemSpeeds.DrivebaseValues.StickPower)));
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void interrupted()
    {
       
        end();
    }

    @Override
    public void end()
    {
        logger.fine("RunDriveBase End");
        drivebase.setLeft(0);
        drivebase.setRight(0);
    }
}
