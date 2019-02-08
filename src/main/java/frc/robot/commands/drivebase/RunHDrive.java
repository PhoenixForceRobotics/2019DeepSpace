package frc.robot.commands.drivebase;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.HDrive;
import frc.robot.subsystems.OI;

import java.util.logging.Logger;
import frc.robot.utility.Log;
import frc.robot.utility.CustomMath;
import edu.wpi.first.wpilibj.Timer;
import java.lang.Math;

public class RunHDrive extends Command
{
    private HDrive hDrive;
    private OI oi;
    private Timer startUp;
    private CustomMath customMath;

    private static final Logger logger = Log.configureLog(RunHDrive.class.getName());

    public RunHDrive(){
        logger.fine("Spinup RunHDrive");
        requires(Robot.hDrive);

        this.hDrive = Robot.hDrive;
        customMath = new CustomMath();
        startUp = new Timer();
    }

    @Override
    public void initialize()
    {
        this.oi = Robot.oi;
        startUp.reset();
        startUp.start();
    }

    @Override
    public void execute()
    {
        logger.finest("RunHDrive Execute");
        
        //once a direction is chosen the code checks to see whether the value of the tuned trigger or the tuned timer
        //is smaller and returns the lesser for smooth accel
        if(oi.driverController.rightTriggerButton.get() & !oi.driverController.leftTriggerButton.get()){
            hDrive.hDrive('r', customMath.returnLesserMag(Math.pow(oi.driverController.triggers.getRight(), Constants.SubsystemSpeeds.HDriveValues.TiggerPower)*Constants.SubsystemSpeeds.HDriveValues.MaxSpeed, Math.pow(startUp.get(), Constants.SubsystemSpeeds.HDriveValues.TimerPower)*Constants.SubsystemSpeeds.HDriveValues.TimerMultiplyer));
        } else if(oi.driverController.leftTriggerButton.get() & !oi.driverController.rightTriggerButton.get()){
            hDrive.hDrive('l', customMath.returnLesserMag(Math.pow(oi.driverController.triggers.getLeft(), Constants.SubsystemSpeeds.HDriveValues.TiggerPower)*Constants.SubsystemSpeeds.HDriveValues.MaxSpeed, Math.pow(startUp.get(), Constants.SubsystemSpeeds.HDriveValues.TimerPower)*Constants.SubsystemSpeeds.HDriveValues.TimerMultiplyer));
        } else {
            hDrive.hDrive('l', 0);
        }
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void interrupted()
    {
        logger.fine("RunHDrive Interrupted");
        end();
    }

    @Override
    public void end()
    {
        logger.fine("RunHDrive End");
        hDrive.hDrive('l', 0);
    }
}