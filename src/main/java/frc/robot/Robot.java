/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Scheduler;

<<<<<<< HEAD
import frc.robot.utility.TheLogFile;
=======
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

>>>>>>> 21684a0464f4496b1f938fe17b8c7a0a700668fb
import frc.robot.subsystems.OI;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.HDrive;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Rotation;
import java.util.logging.Logger;
import frc.robot.utility.Log;
import frc.robot.commands.drivebase.RunDriveBase;
import frc.robot.commands.elevator.RunElevator;
import frc.robot.commands.rotation.RotateCollector;
import frc.robot.commands.climber.PistonsUp;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static TheLogFile theLogFile;
  public static OI oi;
  public static Drivebase drivebase;
  public static HDrive hDrive;
  public static Collector collector;
  public static Elevator elevator;
  public static NetworkTable table;
  public static Climber climber;
  public static Rotation rotation;


  private static final Logger logger = Log.configureLog(Robot.class.getName());

<<<<<<< HEAD
  //This function is run when the robot is first started up and should be
  //used for any initialization code.
=======



  public Robot()
  {
    NetworkTableInstance ntinst = NetworkTableInstance.getDefault();
    NetworkTable table = ntinst.getTable("grip/MyVisionPipeline");
  
  }
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
>>>>>>> 21684a0464f4496b1f938fe17b8c7a0a700668fb
  @Override
  public void robotInit() {
      theLogFile = new TheLogFile();
      logger.fine("About to start drivebase");
      drivebase = new Drivebase();
      logger.fine("About to start Collector");
      collector = new Collector();
      logger.fine("About  to start HDrive");
      hDrive = new HDrive();
      logger.fine("starting elevator");
      elevator = new Elevator();
      logger.fine("starting climber");
      climber = new Climber();
      logger.fine("starting rotation");
      rotation = new Rotation();
      logger.fine("starting OI");
      oi = new OI();
      logger.fine("Everything done here");
  }

  //These are functions because in both cases there is code that gets added that kills
  //the functions in the scheduler and then they need to be added again easily
  public static void addDriveBase(){
    Scheduler.getInstance().add(new RunDriveBase());
   }

   public static void addRunElevator(){
    Scheduler.getInstance().add(new RunElevator());
   }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    logger.finest("robotPeriodic");
  }

  //This is called at the beginning of the Auto Period
  @Override
  public void autonomousInit() {
    logger.finest("autoInit");
    addDriveBase();
    addRunElevator();
    Scheduler.getInstance().add(new RotateCollector());
    Scheduler.getInstance().add(new PistonsUp());
  }

  
  //This function is called periodically during autonomous.
  @Override
  public void autonomousPeriodic() {
    logger.finest("autoPeriodic");
    Scheduler.getInstance().run();
  }

  
  //This function at the beginning of Teleop
  @Override
  public void teleopInit() {
    logger.finest("teleopInit");
    Scheduler.getInstance().removeAll();
    addDriveBase();
    addRunElevator();
    Scheduler.getInstance().add(new RotateCollector());
    Scheduler.getInstance().add(new PistonsUp());
  }

  //This function is called periodically during operator control
  @Override
  public void teleopPeriodic() {
    logger.finest("teleopPeriodic");
    Scheduler.getInstance().run();
    System.out.println(elevator.elevatorEncoder.getPosition());
  }

  
  //This function is called periodically during test mode.
  @Override
  public void testPeriodic() {
    logger.finest("testPeriodic");
  }
}