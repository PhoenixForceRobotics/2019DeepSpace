package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.OI;
import frc.robot.subsystems.Flywheel;
import frc.robot.Constants;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class HoldIntake extends Command{
    private OI oi;
    private Flywheel myflyisbettterthanyourfly;
    public HoldIntake(){

    }
    protected void initialize()
   {
        this.oi = Robot.oi;
        myflyisbettterthanyourfly = Robot.flywheel;
   }

   protected void execute()
   {
        myflyisbettterthanyourfly.intake(ControlMode.PercentOutput, true);
   }

   protected void end()
   {
        myflyisbettterthanyourfly.intake(ControlMode.PercentOutput, false);
   }

    public boolean isFinished() {
        return false;
    }


    public void interrupted() {
        end();
    }
}