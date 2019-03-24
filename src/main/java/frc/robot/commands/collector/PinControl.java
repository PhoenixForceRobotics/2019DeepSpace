package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.Command;

import java.util.logging.Logger;
import frc.robot.utility.Log;

//This pushed the alignment pins in whatever direction is inputted for a portion of a second that pulls them back in
public class PinControl extends Command 
{
    private Collector collector;
    private char direct;

    private static final Logger logger = Log.configureLog(PinControl.class.getName());
    
    public PinControl(char direction){
        logger.fine("PinControl Spinup");
        this.collector = Robot.collector;
        direct = direction;
    }

    @Override
    public void initialize()
    {
        logger.fine("PinControl init");
        setTimeout(.7);
    }
  
    @Override
    public void execute()
    {
        logger.finest("PinControl executed");
        if(direct == 'd'){
            logger.finest("Pin Down");
            collector.pinDown();
        } else if (direct == 'u'){
            logger.finest("Pin Up");
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
        logger.fine("PinControl was ended");
        collector.pinUp();
        collector.pinOff();
    }
}