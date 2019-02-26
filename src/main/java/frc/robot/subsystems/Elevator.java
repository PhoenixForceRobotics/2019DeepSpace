package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.revrobotics.CANEncoder;
// import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Elevator extends Subsystem {
    public Motor elevatorL;
    public Motor elevatorR;

    public CANEncoder elevatorEncoder;

    public Elevator() {

        elevatorL = new Motor(Constants.MotorMap.Elevator.ELEVATORL, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATORL_REVERSED, 30);
        elevatorR = new Motor(Constants.MotorMap.Elevator.ELEVATORR, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATORR_REVERSED, 30);
        elevatorR.follow(elevatorL);
        
        elevatorL.setParameter(CANSparkMaxLowLevel.ConfigParameter.kSensorType, 2);
        elevatorEncoder = elevatorL.getEncoder();

    }

    public void killmotors(){
        elevatorL.set(0);
    }

    public void initDefaultCommand()
    {
        
    }
}