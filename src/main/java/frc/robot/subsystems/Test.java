package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SendableBase;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class Test extends Subsystem {
    public Motor test1, test2;

    public Test() {

        test1 = new Motor(9, false);
        test2 = new Motor(10, false);
        
    }
    public void setTest(double value)
    {
        test1.set(value);
        test2.set(value);
    }

    public void initDefaultCommand()
    {

    }
}