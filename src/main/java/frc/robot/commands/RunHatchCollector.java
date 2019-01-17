package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.HatchCollector;
import edu.wpi.first.wpilibj.command.Command;

public class RunHatchCollector extends Command 
{
    private HatchCollector hatchCollector;
    
    public RunHatchCollector()
    {
        requires(Robot.hatchCollector);

        this.hatchCollector = Robot.hatchCollector;
    } 

    @Override
    public void initialize()
    {
        setTimeout(.1);
    }
  
    @Override
    public void execute()
    {
        System.out.println( "Hewwo? Is anybody there? (´ ･ ω ･ `)" );
        hatchCollector.armcollector.set(Constants.HatchCollectorSpeed.HCspeed);
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
        System.out.println( "No, there is nobody (you're forever alone)(Jk) ( ╹ਊ╹)" );
        hatchCollector.armcollector.set(0);
    }
}