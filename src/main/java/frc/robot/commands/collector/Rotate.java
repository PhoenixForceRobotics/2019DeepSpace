package frc.robot.commands.collector;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class Rotate extends CommandGroup 
{   
    private Collector collector;

    private static final Logger logger = Log.configureLog(Rotate.class.getName());

    public Rotate() {
        requires(Robot.collector);

        collector = Robot.collector;
    }
    @Override
    public void initialize()
    {

    }
  
    @Override
    public void execute()
    {
        logger.finest("Hatch Collector puncher out execute");
        collector.rotate(1);
        logger.severe("Sending encoder position from command group next line");
        logger.severe(Double.toString(collector.theEncoder.getVelocity()));
        System.out.println("Encoder velocity" + collector.theEncoder.getVelocity());
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
        collector.rotate(0);
    }   
}