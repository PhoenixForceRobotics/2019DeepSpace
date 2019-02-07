// package frc.robot.commands;

// import frc.robot.Constants;
// import frc.robot.Robot;
// import frc.robot.subsystems.Collector;
// import edu.wpi.first.wpilibj.command.Command;

// import java.util.logging.Logger;
// import frc.robot.utility.Log;

// public class RunHatchCollector extends Command 
// {
//     private Collector hatchCollector;

//     private static final Logger logger = Log.configureLog(RunHatchCollector.class.getName());
    
//     public RunHatchCollector()
//     {
//         logger.fine("Spinup RunHatchCollector");
//         requires(Robot.hatchCollector);

//         this.hatchCollector = Robot.hatchCollector;
//     } 

//     @Override
//     public void initialize()
//     {
//         logger.fine("Initilize RunHatchCollector");
//         setTimeout(.1);
//     }
  
//     @Override
//     public void execute()
//     {
//     //    System.out.println( "Hewwo? Is anybody there? (´ ･ ω ･ `)" );
//         logger.finest("RunHatchCollector Execute (´ ･ ω ･ `)");  
//         hatchCollector.runHatch();
//     }

//     @Override 
//     public boolean isFinished()
//     {
//         return isTimedOut();
//     }

//     @Override
//     public void interrupted()
//     {
//         logger.fine("RunHatchCollector Interrupted");
//         end();
//     }

//     @Override
//     public void end()
//     {
// //      System.out.println( "No, there is nobody (you're forever alone)(Jk) ( ╹ਊ╹)" );
//         logger.fine("RunHatchCollector End ( ╹ਊ╹)");
//         hatchCollector.stopHatch();
//     }
// }