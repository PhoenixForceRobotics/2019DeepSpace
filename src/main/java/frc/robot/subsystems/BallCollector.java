package frc.robot.subsystems;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;

import frc.robot.utility.Log;

public class BallCollector extends Subsystem {
    public Motor flywheelleft, flywheelright;
    public Motor collectorrotate;

    private static final Logger logger = Log.configureLog(Drivebase.class.getName());

    public BallCollector() {
        logger.fine("Spinup Ball Collector");
        flywheelleft = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_LEFT, Constants.MotorMap.BallCollector.COLLECTORLEFT_REVERSED);
        flywheelright = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_RIGHT, Constants.MotorMap.BallCollector.COLLECTORRIGHT_REVERSED);
        collectorrotate = new Motor(Constants.MotorMap.BallCollector.BALL_ROTATE, Constants.MotorMap.BallCollector.BALLROTATE_REVERSED);

        // flywheelright.follow(flywheelleft);

    }
    public void intake(double value)
    {
        logger.finest("Start Ball Collector Intake");
        flywheelleft.set(value);
        flywheelright.set(value);
    }

    public void outtake(double value)
    {
        logger.finest("Start Ball Collector Outake");
        flywheelleft.set(value);
        flywheelright.set(value);
    }

    public void rotate(double value)
    {
        logger.finest("Start Ball Collector Rotate");
        collectorrotate.set(value);
    }
    
    public void initDefaultCommand()
    {

    }
}