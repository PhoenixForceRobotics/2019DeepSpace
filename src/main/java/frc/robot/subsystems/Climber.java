package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel;

//Import the Logging items
import frc.robot.utility.Log;
import java.util.logging.Logger;

public class Climber extends Subsystem
{
    public Motor colson;
    public DoubleSolenoid leftPiston;
    public DoubleSolenoid rightPiston;
    public static final Logger logger = Log.configureLog(Climber.class.getName());


    public Climber() {

        logger.fine("Spinup Climber");
        colson = new Motor(Constants.MotorMap.Climber.COLSON, MotorType.kBrushed, Constants.MotorMap.Climber.COLSON_REVERSED, 30);
        leftPiston = new DoubleSolenoid(Constants.PneumaticsMap.ClimberPistons.SOLENOID1, Constants.PneumaticsMap.ClimberPistons.SOLENOID2);
        rightPiston = new DoubleSolenoid(Constants.PneumaticsMap.ClimberPistons.SOLENOID3, Constants.PneumaticsMap.ClimberPistons.SOLENOID4);

        colson.setParameter(CANSparkMaxLowLevel.ConfigParameter.kSensorType, 0);
    }

    //Pushes the pistons down, raising the robot
    public void levitate(){

        logger.finest("Levitating");
        leftPiston.set(DoubleSolenoid.Value.kForward);
        rightPiston.set(DoubleSolenoid.Value.kForward);
    }
    
    //Pulls the pistons up, lowering the robot
    public void unlevitate(){
        logger.finest("UnLevitating");
        leftPiston.set(DoubleSolenoid.Value.kReverse);
        rightPiston.set(DoubleSolenoid.Value.kReverse);
    }

    public void killPistons(){
        logger.finest("Pistons turn off");
        leftPiston.set(DoubleSolenoid.Value.kOff);
        rightPiston.set(DoubleSolenoid.Value.kOff);
    }

    //This function is to power the colsons which are on the climbing platform
    public void move(double value)
    {
        colson.set(value);
    }

    public void initDefaultCommand()
    {

    }
}