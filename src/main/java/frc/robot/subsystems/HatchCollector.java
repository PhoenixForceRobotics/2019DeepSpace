// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
// import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
// import frc.robot.Constants;
// import frc.robot.utility.Log;
// import frc.robot.utility.Motor;
// import java.util.logging.Logger;

// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import com.revrobotics.CANEncoder;

// public class HatchCollector extends Subsystem{
//     public Motor armcollector;
//     public DoubleSolenoid puncher;
//     public CANEncoder rotate;
    
//     public static final Logger logger = Log.configureLog(HatchCollector.class.getName());

//     public HatchCollector() {
//         logger.fine("Spinup Hatch Collector");
//         //this is really short ( ͠° ͟ʖ ͡°)
//         armcollector = new Motor (Constants.MotorMap.HatchCollector.ARMCOLLECTOR, MotorType.kBrushed, Constants.MotorMap.HatchCollector.ARMCOLLECTOR_REVERSED);
//         this.puncher = new DoubleSolenoid(Constants.PneumaticsMap.HatchCollector.PUNCHER1, Constants.PneumaticsMap.HatchCollector.PUNCHER2);
//         rotate = armcollector.getEncoder();
//     }
//     public void runHatch()
//     {
//         logger.finest("Start Hatch");
//         armcollector.set(Constants.SubsystemSpeeds.HatchCollectorValues.HCspeed);
//         logger.severe(Double.toString(rotate.getPosition()));
//     }
//     public void liftHatch()
//     {
//         logger.finest("Start Reverse Hatch");
//         armcollector.set(Constants.SubsystemSpeeds.HatchCollectorValues.HCspeed * -1);
//         logger.severe(Double.toString(rotate.getPosition()));
//     }
//     public void stopHatch()
//     {
//         logger.fine("Hatch off");
//         armcollector.set(0);
//     }

//     public void puncherControl(char direction){
//         if(direction == 'o'){
//             logger.fine("Puncher out position");
//             puncher.set(DoubleSolenoid.Value.kForward);
//         } else if (direction == 'i'){
//             logger.fine("Puncher in position");
//             puncher.set(DoubleSolenoid.Value.kReverse);
//         } else {
//             logger.fine("Puncher off position");
//             puncher.set(DoubleSolenoid.Value.kOff);
//         }
//     }
   
//     public void initDefaultCommand()
//     {

//     }
// }