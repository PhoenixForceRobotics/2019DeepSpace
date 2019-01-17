package frc.robot.commands;

import frc.robot.subsystems.OI;
import frc.robot.subsystems.Drivebase;

import edu.wpi.first.wpilibj.command.Command;

//Default command for drivebase during Teleop
public class RunDriveBase extends Command
{
    private Drivebase drivebase;
    private OI oi;

    public RunDriveBase(Drivebase drivebase, OI oi)
    {
        requires(drivebase);

        this.drivebase = drivebase;
        this.oi = oi;
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {   
        //tank drive controls
        drivebase.setLeft(oi.driverController.leftStick.getY());
        drivebase.setRight(oi.driverController.rightStick.getY());

        //H-drive controls 
        
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
        drivebase.setLeft(0);
        drivebase.setRight(0);
    }
}
