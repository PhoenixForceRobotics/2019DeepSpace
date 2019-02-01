package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystems.Flywheel;
// import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class HoldIntake extends Command
{
    private Flywheel flywheel;
   
    public HoldIntake()
   {
       requires(Robot.flywheel);
       this.flywheel = Robot.flywheel;
   }

   protected void initialize()
   {
       
   }

   protected void execute()
   {
       this.flywheel.intake(ControlMode.PercentOutput, true);
   }

    public boolean isFinished() {
        return false;
    }

    protected void end()
    {
        this.flywheel.intake(ControlMode.PercentOutput, false);
    }


    public void interrupted() {
        end();
    }

}