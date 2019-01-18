package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class Elevator extends Subsystem {
    public Motor elevatorL;
    public Motor elevatorR;
    
    public Elevator() {

        elevatorL = new Motor(Constants.MotorMap.Elevator.ELEVATORL, Constants.MotorMap.Elevator.ELEVATORL_REVERSED);

        elevatorR = new Motor(Constants.MotorMap.Elevator.ELEVATORR, Constants.MotorMap.Elevator.ELEVATORR_REVERSED);

    }
    public void initDefaultCommand()
    {

    }
}