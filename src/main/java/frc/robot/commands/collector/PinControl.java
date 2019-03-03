package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.Command;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class PinControl extends Command 
{
    private Collector collector;
    private char direct;

    private static final Logger logger = Log.configureLog(PinControl.class.getName());
    
    public PinControl(char direction){
        this.collector = Robot.collector;
        direct = direction;
    }

    @Override
    public void initialize()
    {
        setTimeout(.7);
    }
  
    @Override
    public void execute()
    {
        if(direct == 'd'){
            collector.pinDown();
        } else if (direct == 'u'){
            collector.pinUp();
        }
    }

    @Override 
    public boolean isFinished()
    {
        return isTimedOut();
    }

    @Override
    public void interrupted()
    {
        end();
    }

    @Override
    public void end()
    {
        collector.pinOff();
    }
}