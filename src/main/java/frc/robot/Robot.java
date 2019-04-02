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

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import frc.robot.subsystems.OI;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.HDrive;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Rotation;
import frc.robot.Constants;
import java.util.logging.Logger;
import frc.robot.utility.Log;
import frc.robot.commands.drivebase.RunDriveBase;
import frc.robot.commands.elevator.RunElevator;
import frc.robot.commands.elevator.ElevatorPID;
import frc.robot.commands.rotation.RotateCollector;
import frc.robot.commands.climber.PistonsUp;
import frc.robot.commands.drivebase.Vision;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  public static OI oi;
  public static Drivebase drivebase;
  public static HDrive hDrive;
  public static Collector collector;
  public static Elevator elevator;
  public static NetworkTable table;
  public static Climber climber;
  public static Rotation rotation;


  private static final Logger logger = Log.configureLog(Robot.class.getName());




  public Robot()
  {
    NetworkTableInstance ntinst = NetworkTableInstance.getDefault();
    NetworkTable table = ntinst.getTable("visionOutputTable");
  
  }
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
      m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
      m_chooser.addOption("My Auto", kCustomAuto);
      SmartDashboard.putData("Auto choices", m_chooser);
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

      double[] defaultValue = new double[0];
      while (true) {

          double[] areas = table.getNumberArray("centerX", defaultValue);
          for (double centerX : areas ){
              System.out.print(centerX + "");
          }
          System.out.println();
          Timer.delay(1);
      }
  }
  public static void addDriveBase(){
    Scheduler.getInstance().add(new RunDriveBase(drivebase, oi));
   }

   public static void addRunElevator(){
    Scheduler.getInstance().add(new RunElevator());
   }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    addDriveBase();
    addRunElevator();
    Scheduler.getInstance().add(new RotateCollector());
    Scheduler.getInstance().add(new PistonsUp());
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during operator control.
   */

  @Override
  public void teleopInit() {
    Scheduler.getInstance().removeAll();
    addDriveBase();
    addRunElevator();
    Scheduler.getInstance().add(new RotateCollector());
    Scheduler.getInstance().add(new PistonsUp());
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    System.out.println(elevator.elevatorEncoder.getPosition());
  }

  /**
   * This function is called periodically during test mode.
   */ 
  @Override
  public void testPeriodic() {
  }
}