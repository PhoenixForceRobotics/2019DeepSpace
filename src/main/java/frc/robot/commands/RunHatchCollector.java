package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystems.OI;
import frc.robot.subsystems.HatchCollector;

import edu.wpi.first.wpilibj.command.Command;

public class RunHatchCollector extends Command 
{
    private HatchCollector hatchCollector;
    private OI oi; 

    public RunHatchCollector(HatchCollector hatchCollector, OI oi)
    {
        requires(hatchCollector);

        this.hatchCollector = hatchCollector;
        this.oi = oi;
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
        return true;
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