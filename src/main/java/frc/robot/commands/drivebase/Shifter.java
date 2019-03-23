package frc.robot.commands.drivebase;

import java.util.logging.Logger;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivebase;
import frc.robot.utility.Log;

public class Shifter extends Command
{
    Drivebase mydrive;

    private static final Logger logger = Log.configureLog(RunDriveBase.class.getName());
    public Shifter(){
        logger.fine("spinup Shifter");
        requires(Robot.drivebase);
        this.mydrive = Robot.drivebase;
    }

    @Override
    public void initialize()
    {
        logger.fine("Speed Shift");
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