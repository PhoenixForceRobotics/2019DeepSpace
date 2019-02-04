package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Log;
import frc.robot.utility.Motor;
import java.util.logging.Logger;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivebase extends Subsystem {
    public Motor left1, left2, left3;
    public Motor right1, right2, right3;

    private static final Logger logger = Log.configureLog(Drivebase.class.getName());

    public Drivebase() {
        logger.fine("Spinup Drivebase");
        left1 = new Motor(Constants.MotorMap.Drivebase.LEFT_1, MotorType.kBrushless, Constants.MotorMap.Drivebase.LEFT1_REVERSED);
        left2 = new Motor(Constants.MotorMap.Drivebase.LEFT_2, MotorType.kBrushless, Constants.MotorMap.Drivebase.LEFT2_REVERSED);
        left3 = new Motor(Constants.MotorMap.Drivebase.LEFT_3, MotorType.kBrushless, Constants.MotorMap.Drivebase.LEFT3_REVERSED);

        right1 = new Motor(Constants.MotorMap.Drivebase.RIGHT_1, MotorType.kBrushless, Constants.MotorMap.Drivebase.RIGHT1_REVERSED);
        right2 = new Motor(Constants.MotorMap.Drivebase.RIGHT_2, MotorType.kBrushless, Constants.MotorMap.Drivebase.RIGHT2_REVERSED);
        right3 = new Motor(Constants.MotorMap.Drivebase.RIGHT_3, MotorType.kBrushless, Constants.MotorMap.Drivebase.RIGHT3_REVERSED);
    }
    public void setLeft(double value)
    {
        logger.finest("Start Set Left");
        left1.set(value);
        left2.set(value);
        left3.set(value);
    }

    public void setRight(double value)
    {
        logger.finest("Start Set Right");
        right1.set(value);
        right2.set(value);
        right3.set(value);
    }

    public void initDefaultCommand()
    {

    }
}