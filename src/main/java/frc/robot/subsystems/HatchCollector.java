package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class HatchCollector extends Subsystem{
    public Motor armcollector;
    
    public HatchCollector() {
        //this is really short ( ͠° ͟ʖ ͡°)
        armcollector = new Motor (Constants.MotorMap.HatchCollector.ARMCOLLECTOR, Constants.MotorMap.HatchCollector.ARMCOLLECTOR_REVERSED);

    }
    public void runHatch()
    {
        armcollector.set(Constants.HatchCollectorValues.HCspeed);
    }
    public void liftHatch()
    {
        armcollector.set(Constants.HatchCollectorValues.HCspeed * -1);
    }
    public void stopHatch()
    {
        armcollector.set(0);
    }
   
    public void initDefaultCommand()
    {

    }
}