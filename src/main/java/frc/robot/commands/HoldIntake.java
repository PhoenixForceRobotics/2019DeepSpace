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
       //why is there a timeout in a hold command? the world will never know....
        setTimeout(.3);
        this.oi = Robot.oi;
        myflyisbettterthanyourfly = Robot.flywheel;
   }

   protected void execute()
   {

   }

   protected void end()
   {

   }

    public boolean isFinished() {
        //that's a werid button to use
        System.out.println(oi.theXboxController.selectButton.get());
        if (oi.theXboxController.selectButton.get())
        { return false;}
        else
        { return true;}
    }


    public void interrupted() {

    }
}