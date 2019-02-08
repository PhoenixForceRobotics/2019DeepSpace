package frc.robot.commands.drivebase;

import frc.robot.subsystems.OI;
import frc.robot.subsystems.Drivebase;

import java.util.logging.Logger;
import frc.robot.utility.Log;

import edu.wpi.first.wpilibj.command.Command;

//Default command for drivebase during Teleop
public class RunDriveBase extends Command
{
    private Drivebase drivebase;
    private OI oi;

    private static final Logger logger = Log.configureLog(RunDriveBase.class.getName());

    public RunDriveBase(Drivebase drivebase, OI oi)
    {
        logger.fine("Spinup Run Drive Base");
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
        logger.finest("Run Drive Base Execute");
        //tank drive controls
        drivebase.setLeft(oi.driverController.leftStick.getY());
        drivebase.setRight(oi.driverController.rightStick.getY());
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void interrupted()
    {
        logger.fine("Run Drive Base Interrupted");
        end();
    }

    @Override
    public void end()
    {
        logger.fine("Run Drive Base End");
        drivebase.setLeft(0);
        drivebase.setRight(0);
    }
}
