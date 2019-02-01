package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.OurCompressor;
import edu.wpi.first.wpilibj.command.Command;

import java.util.logging.Logger;
import frc.robot.utility.Log;

public class RunCompressor extends Command 
{
    private OurCompressor compressor;

    private static final Logger logger = Log.configureLog(RunCompressor.class.getName());
    
    public RunCompressor()
    {
        logger.fine("Spinup Compressor");
        requires(Robot.compressor);

        this.compressor = Robot.compressor;
    } 

    @Override
    public void initialize()
    {
        logger.fine("Initilize RunCompressor");
    }
  
    @Override
    public void execute()
    {
    //    System.out.println( "Hewwo? Is anybody there? (´ ･ ω ･ `)" );
        logger.finest("Execute RunCompressor");  
        compressor.RunCompressor();
    }

    @Override 
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void interrupted()
    {
        logger.fine("RunCompressor Interrupted");
        end();
    }

    @Override
    public void end()
    {
//      System.out.println( "No, there is nobody (you're forever alone)(Jk) ( ╹ਊ╹)" );
        logger.fine("End RunCompressor");
        compressor.StopCompressor();
    }
}