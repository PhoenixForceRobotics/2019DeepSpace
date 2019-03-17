package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.Command;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class AlignmentPins extends Command 
{
    private Collector collector;

    private static final Logger logger = Log.configureLog(AlignmentPins.class.getName());
    
    public AlignmentPins(){
        this.collector = Robot.collector;
    }

    @Override
    public void initialize()
    {
        
    }
  
    @Override
    public void execute()
    {
        collector.pinDown();
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
        collector.pinUp();
        collector.pinOff();
    }
}