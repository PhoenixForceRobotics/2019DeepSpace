package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.EncoderType;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class Elevator extends Subsystem {
    public Motor elevator1;
    public Motor elevator2;

    public CANEncoder elevatorEncoder;

    public boolean ballMode = true;

    private static final Logger logger = Log.configureLog(Elevator.class.getName());

    public Elevator() {
        logger.fine("Spinup Elevator");
        elevator1 = new Motor(Constants.MotorMap.Elevator.ELEVATOR1, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATOR1_REVERSED, 30);
        elevator2 = new Motor(Constants.MotorMap.Elevator.ELEVATOR2, MotorType.kBrushed, Constants.MotorMap.Elevator.ELEVATOR2_REVERSED, 30);

        //sets the elevator one encoder to have a sensor that is an encoder
        elevatorEncoder = elevator1.getEncoder(EncoderType.kQuadrature, 128);
    }

    //These switch the elevator between ball and hatch mode
    //Each of these modes has a different set of setpoints defined in constants for placement of game objects
    public void makeBallMode(){
        logger.fine("ballMode = true");
        ballMode = true;
    }
    public void makeHatchMode(){
        logger.fine("ballMode = false");
        ballMode = false;
    }

    public void killmotors(){
        logger.fine("Elevator kill motors");
        elevator1.set(0);
    }

    public void initDefaultCommand()
    {
        
    }
}