package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.HDrive;
import frc.robot.subsystems.OI;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class RunHDrive extends Command
{
    private HDrive hDrive;
    private OI oi;

    private static final Logger logger = Log.configureLog(RunHDrive.class.getName());

    public RunHDrive(){
        logger.fine("Spinup RunHDrive");
        requires(Robot.hDrive);

        this.hDrive = Robot.hDrive;
    }

    @Override
    public void initialize()
    {
        this.oi = Robot.oi;
    }

    @Override
    public void execute()
    {
        logger.finest("RunHDrive Execute");
        if(oi.driverController.rightTriggerButton.get() & !oi.driverController.leftTriggerButton.get()){
            hDrive.hDrive('r', oi.driverController.triggers.getRight());
        } else if(oi.driverController.leftTriggerButton.get() & !oi.driverController.rightTriggerButton.get()){
            hDrive.hDrive('l', oi.driverController.triggers.getLeft());
        } else {
            hDrive.hDrive('l', 0);
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
        logger.fine("RunHDrive Interrupted");
        end();
    }

    @Override
    public void end()
    {
        logger.fine("RunHDrive End");
        hDrive.hDrive('l', 0);
    }
}