package frc.robot.commands.collector;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.logging.Logger;
import frc.robot.utility.Log;


public class RotateDown extends Command
{   
    private Collector collector;

    private static final Logger logger = Log.configureLog(RotateDown.class.getName());

    public RotateDown() {
        requires(Robot.collector);

        this.collector = Robot.collector;
    }
    @Override
    public void initialize()
    {

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

    }   
}