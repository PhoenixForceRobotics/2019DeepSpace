package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
// import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Elevator extends PIDSubsystem {
    public Motor elevatorL;
    public Motor elevatorR;

    public CANEncoder elevatorEncoder;

    public Elevator() {
        // The constructor passes a name for the subsystem and the P, I and D constants that are used when computing the motor output
        super("Elevator", Constants.SubsystemSpeeds.ElevatorPIDConstants.kp, Constants.SubsystemSpeeds.ElevatorPIDConstants.ki, Constants.SubsystemSpeeds.ElevatorPIDConstants.kd);
        getPIDController().setContinuous(false);
        
        elevatorL = new Motor(Constants.MotorMap.Elevator.ELEVATORL, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATORL_REVERSED, 30);
        elevatorR = new Motor(Constants.MotorMap.Elevator.ELEVATORR, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATORR_REVERSED, 30);
        elevatorR.follow(elevatorL);
        elevatorL.setParameter(CANSparkMaxLowLevel.ConfigParameter.kSensorType, 1);
        elevatorEncoder = elevatorL.getEncoder();
        setAbsoluteTolerance(Constants.SubsystemSpeeds.ElevatorPIDConstants.tolerance);
    }

    public double returnPIDInput(){
        System.out.println(elevatorEncoder.getPosition());
        return elevatorEncoder.getPosition();
    }

    public void usePIDOutput(double output){
        elevatorL.set(output);
    }

    public void killmotors(){
        elevatorL.set(0);
    }

    public void initDefaultCommand()
    {
        
    }
}