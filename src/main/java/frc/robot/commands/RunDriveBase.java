package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystems.OI;
import frc.robot.subsystems.Drivebase;

import edu.wpi.first.wpilibj.command.Command;

//Default command for drivebase during Teleop
public class RunDriveBase extends Command
{
    private Drivebase drivebase;
    private OI oi;
    public double editedLAxis = 0;
    public double editedRAxis = 0;

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
        drivebase.setLeft(ControlMode.PercentOutput, oi.theXboxController.leftStick.getY());
        drivebase.setRight(ControlMode.PercentOutput, oi.theXboxController.rightStick.getY());
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

    }
}