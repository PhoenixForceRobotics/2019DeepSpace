package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class BallCollector extends Subsystem {
    public Motor flywheelleft, flywheelright;
    public Motor collectorrotate;

    public BallCollector() {

        flywheelleft = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_LEFT, Constants.MotorMap.BallCollector.COLLECTORLEFT_REVERSED);
        flywheelright = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_RIGHT, Constants.MotorMap.BallCollector.COLLECTORRIGHT_REVERSED);
        collectorrotate = new Motor(Constants.MotorMap.BallCollector.BALL_ROTATE, Constants.MotorMap.BallCollector.BALLROTATE_REVERSED);

        // flywheelright.follow(flywheelleft);

    }
    public void intake(double value)
    {
        flywheelleft.set(value);
        flywheelright.set(value);
    }

    public void outtake(double value)
    {
        flywheelleft.set(value);
        flywheelright.set(value);
    }

    public void rotate(double value)
    {
        collectorrotate.set(value);
    }
    
    public void initDefaultCommand()
    {

    }
}