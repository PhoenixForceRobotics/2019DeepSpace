package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import frc.robot.utility.Log;
import java.util.logging.Logger;

public class OurCompressor extends Subsystem
{
    public Compressor compressor;
    public static final Logger logger = Log.configureLog(Compressor.class.getName());

    public OurCompressor()
    {
        logger.fine("Spinup Compressor");
        Compressor compressor = new Compressor(0);
    }

    public void RunCompressor()
    {
        logger.fine("Starting Compressor...");
        compressor.setClosedLoopControl(true);
    }

    public void StopCompressor()
    {
        logger.fine("Stopping Compressor...");
        compressor.setClosedLoopControl(false);
    }
    public void initDefaultCommand()
    {

    }
}
