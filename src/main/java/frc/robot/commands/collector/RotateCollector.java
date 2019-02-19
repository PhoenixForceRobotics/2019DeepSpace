package frc.robot.commands.collector;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.OI;
import edu.wpi.first.wpilibj.command.Command;
import java.util.logging.Logger;
import frc.robot.utility.Log;


public class RotateCollector extends Command
{   
    private Collector collector;
    private OI oi;
    private boolean a;
    private boolean b;

    private static final Logger logger = Log.configureLog(RotateCollector.class.getName());

    public RotateCollector() {
        requires(Robot.collector);
        this.collector = Robot.collector;
        this.oi = Robot.oi;
    }
    @Override
    public void initialize()
    {
        a = oi.driverController.leftBumper.get();
        b = oi.driverController.rightBumper.get();

        if(a && !b){
            collector.setSetpoint(Constants.CollectorSetPoints.UP);
            collector.enable();
        } else if(b && !a){
            collector.setSetpoint(Constants.CollectorSetPoints.DOWN);
            collector.enable();
        } else {
            collector.disable();
        }
    }
  
    @Override
    public void execute()
    {
        
    }

    @Override 
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void interrupted()
    {
        end();
    }

    @Override
    public void end()
    {
        collector.disable();
        collector.killrotatemotors();
    }   
}