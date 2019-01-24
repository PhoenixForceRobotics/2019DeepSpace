package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class Elevator extends PIDSubsystem {
    public Motor elevatorL;
    public Motor elevatorR;

    //setting constants
    public double kp = .00;
    public double ki = .00;
    public double kd = .00;

    public Elevator() {
        super("Elevator", 2.0, 0.0, 0.0);// The constructor passes a name for the subsystem and the P, I and D constants that are used when computing the motor output
        setAbsoluteTolerance(0.05);
        getPIDController().setContinuous(false);
        
        elevatorL = new Motor(Constants.MotorMap.Elevator.ELEVATORL, Constants.MotorMap.Elevator.ELEVATORL_REVERSED);
        elevatorR = new Motor(Constants.MotorMap.Elevator.ELEVATORR, Constants.MotorMap.Elevator.ELEVATORR_REVERSED);
<<<<<<< HEAD
=======

        
    }

    public void initDefaultCommand()
    {

>>>>>>> 0918e8fb1e37f3cb1b21aaf5ecb9fbe4ea6f05b3
    }
    
    // PIDSubsystem.returnPIDInput()Java(67109264)
    // PIDSubsystem.usePIDOutput(double)
    // public void initDefaultCommand()
}