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
        logger.fine("AllignmentPins Spin up");
        this.collector = Robot.collector;
    }

    @Override
    public void initialize()
    {

    }
  
    @Override
    public void execute()
    {
        logger.finest("AllignemntPins executed");
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
        logger.fine("AllignmentPins was ended -- PinUp and PinOff");
        collector.pinUp();
        collector.pinOff();
    }
}