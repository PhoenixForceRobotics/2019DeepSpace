package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.Constants;
import frc.robot.commands.collector.RotateUp;
import frc.robot.commands.collector.RotateDown;
import edu.wpi.first.wpilibj.command.CommandGroup;
import com.revrobotics.CANEncoder;


public class RotateCollector extends CommandGroup 
{
    private boolean a;
    private boolean b;
    private boolean c;
    // private CANEncoder encoder;
    
    public RotateCollector() {

        a = Robot.oi.driverController.leftBumper.get();
        b = Robot.oi.driverController.rightBumper.get();
        // this.encoder = Robot.collector.collectorEncoder;

        if(a && !b){
            new RotateUp(Constants.CollectorSetPoints.UP);
        } else if(!a && b){
            new RotateDown(Constants.CollectorSetPoints.DOWN);
        }
    }
}