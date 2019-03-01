package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
// import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class Elevator extends Subsystem {
    public Motor elevator1;
    public Motor elevator2;
    public Motor elevator3;
    public Motor elevator4;

    public CANEncoder elevatorEncoder;

    private static final Logger logger = Log.configureLog(Elevator.class.getName());

    public Elevator() {
        logger.finest("Spinup Elevator");
        elevator1 = new Motor(Constants.MotorMap.Elevator.ELEVATOR1, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATOR1_REVERSED, 30);
        elevator2 = new Motor(Constants.MotorMap.Elevator.ELEVATOR2, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATOR2_REVERSED, 30);
        elevator3 = new Motor(Constants.MotorMap.Elevator.ELEVATOR3, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATOR3_REVERSED, 30);
        elevator4 = new Motor(Constants.MotorMap.Elevator.ELEVATOR4, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATOR4_REVERSED, 30);
 
        elevator3.follow(elevator1);
        elevator4.follow(elevator2);

        elevator1.setParameter(CANSparkMaxLowLevel.ConfigParameter.kSensorType, 2);
        elevatorEncoder = elevator1.getEncoder();

    }

    public void killmotors(){
        logger.finest("Elevator kill motors");
        elevator1.set(0);
    }

    public void initDefaultCommand()
    {
        
    }
}