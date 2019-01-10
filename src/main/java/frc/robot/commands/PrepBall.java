package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystems.Flywheel;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PrepBall extends Command
{
    private Flywheel myfly;
   //private Timer commandTimer;

   //public PrepBall(Flywheel flywheel)
    public PrepBall()
   {
       //requires(Robot.flywheel);

       myfly = Robot.flywheel;

   }

   protected void initialize()
   {
        setTimeout(.7);
   }

   protected void execute()
   {
       myfly.intake(ControlMode.PercentOutput, true);
   }

   protected void end()
   {
       myfly.intake(ControlMode.PercentOutput, false);
   }

    public boolean isFinished() {
        return false;
    }


    public void interrupted() {

    }

}