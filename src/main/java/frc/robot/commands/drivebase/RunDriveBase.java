package frc.robot.commands.drivebase;

import frc.robot.subsystems.OI;
import frc.robot.subsystems.Drivebase;

import java.util.logging.Logger;
import frc.robot.utility.Log;
import frc.robot.Constants;
import frc.robot.utility.CustomMath;

import edu.wpi.first.wpilibj.command.Command;

//Default command for drivebase during Teleop
public class RunDriveBase extends Command
{
    private Drivebase drivebase;
    private OI oi;
    private CustomMath customMath;

    private static final Logger logger = Log.configureLog(RunDriveBase.class.getName());

    public RunDriveBase(Drivebase drivebase, OI oi)
    {
        logger.fine("Spinup Run Drive Base");
        requires(drivebase);
        customMath = new CustomMath();

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
        drivebase.setLeft(customMath.makeSign(oi.driverController.rightStick.getY(), Math.pow(oi.driverController.rightStick.getY(), Constants.SubsystemSpeeds.DrivebaseValues.StickPower)));
        drivebase.setRight(customMath.makeSign(oi.driverController.leftStick.getY(), Math.pow(oi.driverController.leftStick.getY(), Constants.SubsystemSpeeds.DrivebaseValues.StickPower)));
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
