package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel;

public class Climber extends Subsystem
{
    public Motor colson;
    public DoubleSolenoid leftPiston;
    public DoubleSolenoid rightPiston;

    public Climber() {
        colson = new Motor(Constants.MotorMap.Climber.COLSON, MotorType.kBrushed, Constants.MotorMap.Climber.COLSON_REVERSED, 30);
        leftPiston = new
    }

    public void initDefaultCommand()
    {

    }
}