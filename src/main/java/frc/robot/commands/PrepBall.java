package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystems.Flywheel;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

public class PrepBall extends Command
{
    private Flywheel myfly;
    private Timer preppy;
   //private Timer commandTimer;

   //public PrepBall(Flywheel flywheel)
    public PrepBall()
   {
       requires(Robot.flywheel);
       myfly = Robot.flywheel;
   }

   protected void initialize()
   {
        setTimeout(.4);
        preppy = new Timer();
        preppy.reset();
        preppy.start();
        

   }

   protected void execute()
   {
      if (preppy.get() > .3) {
        myfly.outtake(ControlMode.PercentOutput, true);
    } else {
        myfly.intake(ControlMode.PercentOutput, true);
    }
   }

   protected void end()
   {
       myfly.outtake(ControlMode.PercentOutput, false);
        myfly.intake(ControlMode.PercentOutput, false);
   }

    public boolean isFinished() {
        return isTimedOut();
    }


    public void interrupted() {

    }

}