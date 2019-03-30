package frc.robot.commands.climber;

// import frc.robot.Constants;
import frc.robot.Robot;
// import frc.robot.commands.climber.CheckButtons;
// import frc.robot.commands.climber.PistonsUp;
import frc.robot.commands.climber.PistonsDown;
import frc.robot.commands.rotation.CollectorClimb;
import frc.robot.commands.elevator.ElevatorClimb;
// import frc.robot.commands.climber.MoveColsons;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

/*These are the imports for logging
import java.util.logging.Logger;
import frc.robot.utility.Log;*/

public class ClimbSequence extends CommandGroup
{

    //public static final Logger logger = Log.configureLog(ClimbSequence.class.getName());

    public ClimbSequence()
    {
        Scheduler.getInstance().removeAll();
        Robot.addDriveBase();
        Scheduler.getInstance().add(new PistonsDown());
        addParallel(new CollectorClimb());
        addParallel(new ElevatorClimb());
        // Scheduler.getInstance().add(new MoveColsons());
    }
}