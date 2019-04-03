package frc.robot.commands.climber;

import frc.robot.Robot;
import frc.robot.subsystems.OI;
import frc.robot.commands.climber.ClimbSequence;
import frc.robot.commands.climber.PistonsDown;
import frc.robot.commands.rotation.Jenktate;
import edu.wpi.first.wpilibj.command.Command;

//These are the imports for logging
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class CheckButtons extends Command
{
    private OI oi;

    private boolean payton;
    private boolean david;

    public CheckButtons()
    {
   
    }

    @Override
    protected void initialize() {
        this.oi = Robot.oi;
    }

    @Override
    protected void execute() {
        
        // System.out.println("execute?");
        payton = oi.driverController.startButton.get();
        david = oi.operatorController.leftTriggerButton.get();

        if(payton && david){
            // System.out.println("trueeee");
            new ClimbSequence();
            end();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
       
        end();
    }

    @Override
    protected void end() {
       
    }
}