package frc.robot.subsystems;

import java.util.logging.Logger;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.utility.Motor;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.utility.Log;

public class Collector extends Subsystem
{
    public Motor ballintake;
    public DoubleSolenoid puncher;
    public DoubleSolenoid pins;

    public static final Logger logger = Log.configureLog(Collector.class.getName());

    public Collector() {
        logger.fine("Spinup Ball Collector and Hatch Collector");
        
        ballintake = new Motor(Constants.MotorMap.BallCollector.COLLECTORIO, MotorType.kBrushed, Constants.MotorMap.BallCollector.COLLECTORIO_REVERSED, 30);
        ballintake.setParameter(CANSparkMaxLowLevel.ConfigParameter.kSensorType, 0);
        puncher = new DoubleSolenoid(Constants.PneumaticsMap.HatchCollector.PUNCHER1, Constants.PneumaticsMap.HatchCollector.PUNCHER2);
        pins = new DoubleSolenoid(Constants.PneumaticsMap.HatchCollector.PIN1,Constants.PneumaticsMap.HatchCollector.PIN2);
    }

    public void intake(double value)
    {
        logger.finest("Ball Collector Intake");
        ballintake.set(-value);
    }

    public void outtake(double value)
    {
        logger.finest("Ball Collector Outake");
        ballintake.set(value);
    }

    //This controlls the pistons that punch the hatch off of the velcro 
    //'o' pushes the pistons out 'i' pulls the pistons in, and anything else cuts off air
    public void puncherControl(char direction){
        if(direction == 'o'){
            logger.fine("Puncher out position");
            puncher.set(DoubleSolenoid.Value.kForward);
        } else if (direction == 'i'){
            logger.fine("Puncher in position");
            puncher.set(DoubleSolenoid.Value.kReverse);
        } else {
            logger.fine("Puncher off position");
            puncher.set(DoubleSolenoid.Value.kOff);
        }
    }

    //These put the alignment pins for the floor hatch pickup up and down
    public void pinDown(){
        logger.fine("Pins Down");
        pins.set(DoubleSolenoid.Value.kForward);
    }
    public void pinUp(){
        logger.fine("Pins Up");
        pins.set(DoubleSolenoid.Value.kReverse);
    }
    public void pinOff(){
        logger.fine("Pins Off");
        pins.set(DoubleSolenoid.Value.kOff);
    }
   
    public void initDefaultCommand()
    {

    }
}