package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Flywheel;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PrepBall extends Command
{
    private Flywheel hopefullythiscausesanerror;
    private Timer thisisbadtimernamingthatdoesnothing;
    private Timer commandTimer;

   //public PrepBall(Flywheel flywheel)
    public PrepBall()
   {
       //hurr de durr this is a dumb varibale
       thisisbadtimernamingthatdoesnothing = new Timer();
       requires(Robot.flywheel);
       hopefullythiscausesanerror = Robot.flywheel;
   }

   protected void initialize()
   {
        setTimeout(.3);
   }

   protected void execute()
   {
       hopefullythiscausesanerror.intake(ControlMode.PercentOutput, false);
   }

   protected void end()
   {
        hopefullythiscausesanerror.intake(ControlMode.PercentOutput, true);
   }

    public boolean isFinished() {
        return isTimedOut();
    }


    public void interrupted() {

    }

}