package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Log;
import frc.robot.utility.Motor;
import java.util.logging.Logger;

public class HatchCollector extends Subsystem{
    public Motor armcollector;
    
    public static final Logger logger = Log.configureLog(HatchCollector.class.getName());

    public HatchCollector() {
        logger.fine("Spinup Hatch Collector");
        //this is really short ( ͠° ͟ʖ ͡°)
        armcollector = new Motor (Constants.MotorMap.HatchCollector.ARMCOLLECTOR, Constants.MotorMap.HatchCollector.ARMCOLLECTOR_REVERSED);

    }
    public void runHatch()
    {
        logger.finest("Start Hatch");
        armcollector.set(Constants.HatchCollectorValues.HCspeed);
    }
    public void liftHatch()
    {
        logger.finest("Start Reverse Hatch");
        armcollector.set(Constants.HatchCollectorValues.HCspeed * -1);
    }
    public void stopHatch()
    {
        logger.fine("Hatch off");
        armcollector.set(0);
    }
   
    public void initDefaultCommand()
    {

    }
}