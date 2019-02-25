package frc.robot.subsystems;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel;

import frc.robot.utility.Log;

public class Collector extends PIDSubsystem
{
    public Motor flywheelleft, flywheelright;
    public Motor collectorrotate;
    public Motor collectorrotate1;
    public DoubleSolenoid puncher;
    public CANEncoder collectorEncoder;

    public static final Logger logger = Log.configureLog(Collector.class.getName());

    public Collector() {
        super("COllector", Constants.SubsystemSpeeds.RotateCollectorPIDConstants.kp, Constants.SubsystemSpeeds.RotateCollectorPIDConstants.ki, Constants.SubsystemSpeeds.RotateCollectorPIDConstants.kd);
        getPIDController().setContinuous(false);

        logger.fine("Spinup Ball Collector and Hatch Collector");
        
        flywheelleft = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_LEFT, MotorType.kBrushed, Constants.MotorMap.BallCollector.COLLECTORLEFT_REVERSED, 30);
        flywheelright = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_RIGHT,  MotorType.kBrushed,Constants.MotorMap.BallCollector.COLLECTORRIGHT_REVERSED, 30);
        collectorrotate = new Motor(Constants.MotorMap.BallCollector.BALL_ROTATE, MotorType.kBrushed, Constants.MotorMap.BallCollector.BALLROTATE_REVERSED, 30);
        collectorrotate1 = new Motor(Constants.MotorMap.BallCollector.BALL_ROTATE1, MotorType.kBrushed, Constants.MotorMap.BallCollector.BALLROTATE1_REVERSED, 30);

        collectorrotate1.follow(collectorrotate);
        flywheelright.follow(flywheelleft);
        
        this.puncher = new DoubleSolenoid(Constants.PneumaticsMap.HatchCollector.PUNCHER1, Constants.PneumaticsMap.HatchCollector.PUNCHER2);
        //try setting a lower level motor setting per Chief Delphi --this is JT's fault
        collectorrotate.setParameter(CANSparkMaxLowLevel.ConfigParameter.kSensorType, 0);
        collectorEncoder = collectorrotate.getEncoder();
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
        flywheelleft.set(-value);
        flywheelright.set(-value);
    }

    // public void rotate(double value)
    // {
    //     //jt system out
    //     System.out.println("Value:" + value);
    //     logger.finest("Start Ball Collector Rotate");
    //     collectorrotate.setSetpoint(value);
    //     System.out.println(collectorEncoder.getPosition());
    // }

    public double returnPIDInput()
    {
        return collectorEncoder.getPosition();
    }
    
    public void usePIDOutput(double output){
        collectorrotate.set(output);
    }

    public void killrotatemotors()
    {
        collectorrotate.set(0);
    }

    public void puncherControl(char direction){
        if(direction == 'o'){
            logger.fine("Puncher out position");
            puncher.set(DoubleSolenoid.Value.kForward);
        } else if (direction == 'i'){
            logger.fine("Puncher in position");
            puncher.set(DoubleSolenoid.Value.kReverse);
        } else {
            logger.fine("Puncher off position");
            puncher.set(DoubleSolenoid.Value.kOff);
        }
    }
   
    public void initDefaultCommand()
    {

    }
}