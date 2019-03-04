package frc.robot.commands.climber;

import frc.robot.commands.climber.PistonsDown;
import frc.robot.commands.rotation.Jenktate;
import frc.robot.commands.rotation.RotateCollector;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RotateandShoot extends CommandGroup
{
    public RotateandShoot()
    {
        addParallel(new PistonsDown());
        addParallel(new Jenktate());
    }
}