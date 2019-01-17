package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class BallCollector extends Subsystem {
    public Motor flywheelleft, flywheelright;
    public Motor collectorrotate;

    public BallCollector() {

        flywheelleft = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_LEFT, Constants.MotorMap.BallCollector.COLLECTORLEFT_REVERSED);
        flywheelright = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_RIGHT, Constants.MotorMap.BallCollector.COLLECTORRIGHT_REVERSED);
        collectorrotate = new Motor(Constants.MotorMap.BallCollector.BALL_ROTATE, Constants.MotorMap.BallCollector.BALLROTATE_REVERSED);

        flywheelright.follow(flywheelleft);

    }
    public void setLeft(ControlMode mode, double value)
    {
        flywheelleft.set(mode, value);
    }

    public void setRight(ControlMode mode, double value)
    {
        flywheelright.set(mode, value);
    }

    public void setRotate(ControlMode mode, double value)
    {
        collectorrotate.set(mode, value);
    }
    
    public void initDefaultCommand()
    {

    }
}