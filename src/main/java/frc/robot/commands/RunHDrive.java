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
        
    }

    @Override
    public void execute()
    {
        drivebase.hDrive();
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
        drivebase.hDrive(0);
    }
}