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

<<<<<<< HEAD
        this.collector = Robot.collector;
=======
        collector = Robot.collector;

>>>>>>> 823ccf7128d2f8042926cba129fcfd341effdd02
    }
    @Override
    public void initialize()
    {

    }
  
    @Override
    public void execute()
    {
        logger.finest("Hatch Collector puncher out execute");
        collector.rotate(Constants.SubsystemSpeeds.BallCollectorValues.BCRotateSpeed);
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