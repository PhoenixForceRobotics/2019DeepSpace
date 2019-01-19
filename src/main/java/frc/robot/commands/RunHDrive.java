package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.OI;

public class RunHDrive extends Command
{
    private Drivebase drivebase;
    private OI oi;

    public RunHDrive(){
        requires(Robot.drivebase);

        this.drivebase = Robot.drivebase;
    }

    @Override
    public void initialize()
    {
        this.oi = Robot.oi;
    }

    @Override
    public void execute()
    {
        if(oi.driverController.rightTriggerButton.get() & !oi.driverController.leftTriggerButton.get()){
            drivebase.hDrive('r', oi.driverController.triggers.getRight());
        } else if(oi.driverController.leftTriggerButton.get() & !oi.driverController.rightTriggerButton.get()){
            drivebase.hDrive('l', oi.driverController.triggers.getLeft());
        } else {
            drivebase.hDrive('l', 0);
        }
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void interrupted()
    {
        end();
    }

    @Override
    public void end()
    {
        drivebase.hDrive('l', 0);
    }
}