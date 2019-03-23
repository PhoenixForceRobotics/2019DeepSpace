package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.Constants;
import frc.robot.utility.Log;
import frc.robot.utility.Motor;

import java.util.logging.Logger;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class HDrive extends Subsystem {
    public Motor hdrive1, hdrive2;

    private static final Logger logger = Log.configureLog(DriveBaseAB.class.getName());

    public HDrive() {
        logger.fine("Spinup hDrive");
        hdrive1 = new Motor(Constants.MotorMap.Drivebase.HDRIVE1, MotorType.kBrushless, Constants.MotorMap.Drivebase.HDRIVE1_REVERSED, 40);
        hdrive2 = new Motor(Constants.MotorMap.Drivebase.HDRIVE2, MotorType.kBrushless, Constants.MotorMap.Drivebase.HDRIVE2_REVERSED, 40);
        hdrive2.follow(hdrive1);
    }
    public void hDrive(char direction, double value){
        logger.finest("Start hDrive");
        if(direction == 'r'){
            logger.finer("hDrive to the right");
            hdrive1.set(-value);
        } else if(direction == 'l'){
            logger.finer("hDrive to the left");
            hdrive1.set(value);
        } else {
            logger.finer("hDrive off");
            hdrive1.set(0);
        }
    }

    public void initDefaultCommand()
    {

    }
}