package frc.robot.commands.drivebase;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveBaseAB;

public class Shifter extends Command
{
    DriveBaseAB mydrive;
    public Shifter(){
        requires(Robot.drivebaseAB);
        this.mydrive = Robot.drivebaseAB;
    }

    @Override
    public void initialize()
    {
        mydrive.shift();
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        return true;
    }

    @Override
    public void interrupted()
    {
        end();
    }

    @Override
    public void end()
    {
        Robot.addDriveBase();
    }
}