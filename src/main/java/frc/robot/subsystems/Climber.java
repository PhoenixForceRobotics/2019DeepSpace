package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel;

public class Climber extends Subsystem
{
    public Motor colson;
    public DoubleSolenoid leftPiston;
    public DoubleSolenoid rightPiston;

    public Climber() {
        colson = new Motor(Constants.MotorMap.Climber.COLSON, MotorType.kBrushed, Constants.MotorMap.Climber.COLSON_REVERSED, 30);
        leftPiston = new DoubleSolenoid(Constants.PneumaticsMap.ClimberPistons.SOLENOID1, Constants.PneumaticsMap.ClimberPistons.SOLENOID2);
        rightPiston = new DoubleSolenoid(Constants.PneumaticsMap.ClimberPistons.SOLENOID3, Constants.PneumaticsMap.ClimberPistons.SOLENOID4);

        colson.setParameter(CANSparkMaxLowLevel.ConfigParameter.kSensorType, 0);
    }

    public void levitate(){
        leftPiston.set(DoubleSolenoid.Value.kForward);
        rightPiston.set(DoubleSolenoid.Value.kForward);
    }

    public void unlevitate(){
        leftPiston.set(DoubleSolenoid.Value.kReverse);
        rightPiston.set(DoubleSolenoid.Value.kReverse);
    }

    public void killPistons(){
        leftPiston.set(DoubleSolenoid.Value.kOff);
        rightPiston.set(DoubleSolenoid.Value.kOff);
    }

    public void move(double value)
    {
        colson.set(value);
    }

    public void initDefaultCommand()
    {

    }
}