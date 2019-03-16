package frc.robot.commands.drivebase;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivebase;

public class Shifter extends Command
{
    Drivebase mydrive;
    public Shifter(){
        requires(Robot.drivebase);
        this.mydrive = Robot.drivebase;
    }

    //This shifts the drivebase from full power to .25 power or the other way around
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