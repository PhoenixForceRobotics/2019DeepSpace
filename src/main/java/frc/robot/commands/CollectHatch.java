package frc.robot.commands;
//Evan is the coolest Senior Ever™
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.HatchCollector;
import edu.wpi.first.wpilibj.command.Command;

public class CollectHatch extends Command
{
    private HatchCollector hatchCollector;
    
    public CollectHatch()
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
        System.out.println("Hello! Collecting Hatches... (＾ω＾)");
        hatchCollector.armcollector.set(Constants.HatchCollectorSpeed.HCspeed * -1);
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
        System.out.println("Evan is an orange.(◕‿◕✿)");
        hatchCollector.armcollector.set(0);
    }
}