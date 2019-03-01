package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import frc.robot.Constants;
import frc.robot.commands.collector.RotateUp;
import frc.robot.commands.collector.RotateDown;
import edu.wpi.first.wpilibj.command.Command;
// import com.revrobotics.CANEncoder;


public class RotateCollector extends Command
{
    private boolean a;
    private boolean b;
    private Collector collector;
    // private CANEncoder encoder;
    
    public RotateCollector() {
        collector = Robot.collector;
        // I'm leaving the encoder because when we add more setpoints we will need it
        // this.encoder = Robot.collector.collectorEncoder
    }
    @Override
    protected void initialize() {     

    }

    @Override
    protected void execute() {
        a = Robot.oi.driverController.leftBumper.get();
        b = Robot.oi.driverController.rightBumper.get();
        
        if(a && !b){
            collector.janktateUp(.5);
        } else if(!a && b){
            collector.janktateUp(-.5);
        } else {
            collector.janktateUp(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        collector.janktateUp(0);
    }
}