package frc.robot.subsystems;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel;

import frc.robot.utility.Log;

public class Rotation extends Subsystem
{
    public Motor collectorrotate, collectorrotate1;
    public CANEncoder collectorEncoder;

    public static final Logger logger = Log.configureLog(Collector.class.getName());

    public Rotation() {
        logger.fine("Spinup Ball Collector and Hatch Collector");
        
        collectorrotate = new Motor(Constants.MotorMap.BallCollector.BALL_ROTATE, MotorType.kBrushed, Constants.MotorMap.BallCollector.BALLROTATE_REVERSED, 30);
        collectorrotate1 = new Motor(Constants.MotorMap.BallCollector.BALL_ROTATE1, MotorType.kBrushed, Constants.MotorMap.BallCollector.BALLROTATE1_REVERSED, 30);

        collectorrotate1.follow(collectorrotate);
        collectorrotate.setParameter(CANSparkMaxLowLevel.ConfigParameter.kSensorType, 2);
        collectorEncoder = collectorrotate1.getEncoder();
    }

    public void janktateUp(double speed)
    {
        collectorrotate.set(speed);
    }

    public void janktateDown(double speed)
    {
        collectorrotate.set(-speed);
    }

    public void killrotatemotors()
    {
        collectorrotate.set(0);
    }

    public void initDefaultCommand()
    {

    }
}