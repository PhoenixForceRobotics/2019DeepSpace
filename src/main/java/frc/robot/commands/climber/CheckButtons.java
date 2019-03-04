package frc.robot.commands.climber;

import frc.robot.Robot;
import frc.robot.subsystems.OI;
import frc.robot.commands.climber.RotateandShoot;
import frc.robot.commands.climber.PistonsDown;
import frc.robot.commands.rotation.Jenktate;
import edu.wpi.first.wpilibj.command.Command;

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
        payton = oi.driverController.selectButton.get();
        david = oi.operatorController.leftTriggerButton.get();

        if(david){
            new PistonsDown();
            new Jenktate();
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