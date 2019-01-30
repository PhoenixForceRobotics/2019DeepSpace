package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;
import frc.robot.utility.Log;
import frc.robot.utility.Motor;
import java.util.logging.Logger;

import edu.wpi.first.wpilibj.Encoder;

public class HatchCollector extends Subsystem{
    public Motor armcollector;
    public DoubleSolenoid puncher;
    public Encoder rotate;
    
    public static final Logger logger = Log.configureLog(HatchCollector.class.getName());

    public HatchCollector() {
        logger.fine("Spinup Hatch Collector");
        //this is really short ( ͠° ͟ʖ ͡°)
        armcollector = new Motor (Constants.MotorMap.HatchCollector.ARMCOLLECTOR, Constants.MotorMap.HatchCollector.ARMCOLLECTOR_REVERSED);
        this.puncher = new DoubleSolenoid(Constants.PneumaticsMap.HatchCollector.PUNCHER1, Constants.PneumaticsMap.HatchCollector.PUNCHER2);
        rotate = new Encoder(Constants.EncoderMap.HatchCollector.ROTATE1, Constants.EncoderMap.HatchCollector.ROTATE2);
    }
    public void runHatch()
    {
        logger.finest("Start Hatch");
        armcollector.set(Constants.HatchCollectorValues.HCspeed);
        logger.severe(Double.toString(rotate.getDistance()));
    }
    public void liftHatch()
    {
        logger.finest("Start Reverse Hatch");
        armcollector.set(Constants.HatchCollectorValues.HCspeed * -1);
        logger.severe(Double.toString(rotate.getDistance()));
    }
    public void stopHatch()
    {
        logger.fine("Hatch off");
        armcollector.set(0);
    }

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
   
    public void initDefaultCommand()
    {

    }
}