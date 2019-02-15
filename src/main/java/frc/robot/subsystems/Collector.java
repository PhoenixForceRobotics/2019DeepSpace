package frc.robot.subsystems;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel;

import frc.robot.utility.Log;

public class Collector extends Subsystem
{
    public Motor flywheelleft, flywheelright;
    public Motor collectorrotate;
    public DoubleSolenoid puncher;
    public CANEncoder theEncoder;

    public static final Logger logger = Log.configureLog(Collector.class.getName());

    public Collector() {
        logger.fine("Spinup Ball Collector and Hatch Collector");
        flywheelleft = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_LEFT, MotorType.kBrushed, Constants.MotorMap.BallCollector.COLLECTORLEFT_REVERSED);
        flywheelright = new Motor(Constants.MotorMap.BallCollector.COLLECTOR_RIGHT,  MotorType.kBrushed,Constants.MotorMap.BallCollector.COLLECTORRIGHT_REVERSED);
        collectorrotate = new Motor(Constants.MotorMap.BallCollector.BALL_ROTATE, MotorType.kBrushed, Constants.MotorMap.BallCollector.BALLROTATE_REVERSED);
        // flywheelright.follow(flywheelleft);
        
        //this is really short ( ͠° ͟ʖ ͡°)
        this.puncher = new DoubleSolenoid(Constants.PneumaticsMap.HatchCollector.PUNCHER1, Constants.PneumaticsMap.HatchCollector.PUNCHER2);
        //try setting a lowe leve motor setting per Chief Delphi --this is JT's fault
        collectorrotate.setParameter(CANSparkMaxLowLevel.ConfigParameter.kSensorType, 1);
        theEncoder = collectorrotate.getEncoder();
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

    public void rotate(double value)
    {
        logger.finest("Start Ball Collector Rotate");
        collectorrotate.set(value);
        //logger.severe(Double.toString(theEncoder.getPosition()));
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