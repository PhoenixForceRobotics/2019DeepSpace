package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Log;
import frc.robot.utility.Motor;
import java.util.logging.Logger;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class HDrive extends Subsystem {
    public Motor hdrive1, hdrive2;

    private static final Logger logger = Log.configureLog(Drivebase.class.getName());

    public HDrive() {
        logger.fine("Spinup hDrive");
        hdrive1 = new Motor(Constants.MotorMap.Drivebase.HDRIVE1, MotorType.kBrushed, Constants.MotorMap.Drivebase.HDRIVE1_REVERSED, 30);
        hdrive2 = new Motor(Constants.MotorMap.Drivebase.HDRIVE2, MotorType.kBrushed, Constants.MotorMap.Drivebase.HDRIVE2_REVERSED, 30);
        hdrive2.follow(hdrive1);
    }
    
    //For the char imput 'r' to drive the hDrive to the right and 'l' to drive it to the left
    //the value is the motor speed that you want the motors to run at 
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