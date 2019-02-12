package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
// import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;

public class Elevator extends PIDSubsystem {
    public Motor elevatorL;
    public Motor elevatorR;

    public Encoder elevatorEncoder;
    //setting constants
    public double kp = .00;
    public double ki = .00;
    public double kd = .00;

    public Elevator() {
        super("Elevator", 2.0, 0.0, 0.0);// The constructor passes a name for the subsystem and the P, I and D constants that are used when computing the motor output
        setAbsoluteTolerance(0.05);
        getPIDController().setContinuous(false);
        
        elevatorL = new Motor(Constants.MotorMap.Elevator.ELEVATORL, MotorType.kBrushless, Constants.MotorMap.Elevator.ELEVATORL_REVERSED);
        elevatorR = new Motor(Constants.MotorMap.Elevator.ELEVATORR, MotorType.kBrushless, Constants.MotorMap.Elevator.ELEVATORR_REVERSED);
    
        elevatorEncoder = new Encoder(Constants.EncoderMap.Elevator.ELEVATORDIGITAL1, Constants.EncoderMap.Elevator.ELEVATORDIGITAL2, Constants.EncoderMap.Elevator.ELEVATORDIGITAL_REVERSED);
        
    }

    public double returnPIDInput(){
        return elevatorEncoder.getDistance();
    }

    public void usePIDOutput(double output){
        elevatorL.pidWrite(output);
        elevatorR.pidWrite(output);
    }

    public void initDefaultCommand()
    {
        
    }
}