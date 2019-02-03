// package frc.robot.commands;

// import frc.robot.Constants;
// import frc.robot.Robot;
// import frc.robot.subsystems.HatchCollector;
// import edu.wpi.first.wpilibj.command.Command;

// import java.util.logging.Logger;
// import frc.robot.utility.Log;

// public class PuncherHatchOut extends Command 
// {
//     private HatchCollector hatchCollector;

//     private static final Logger logger = Log.configureLog(PuncherHatchOut.class.getName());
    
//     public PuncherHatchOut()
//     {
//         logger.fine("Spinup Puncher Hatch Out");
//         requires(Robot.hatchCollector);

//         this.hatchCollector = Robot.hatchCollector;
//     } 

//     @Override
//     public void initialize()
//     {
//         logger.fine("Hatch Collector puncher out initialize");
//         setTimeout(.05);
//     }
  
//     @Override
//     public void execute()
//     {
//         logger.finest("Hatch Collector puncher out execute");
//         hatchCollector.puncherControl('o');
//     }

//     @Override 
//     public boolean isFinished()
//     {
//         return isTimedOut();
//     }

//     @Override
//     public void interrupted()
//     {
//         end();
//     }

//     @Override
//     public void end()
//     {
//         logger.fine("Hatch Collector puncher out end");
//         hatchCollector.puncherControl('n');
//     }
// }