package frc.robot.utility;

import java.io.IOException;
import java.util.logging.FileHandler;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TheLogFile extends Subsystem{
    private static FileHandler theLogFile;
    private static boolean logFileMade = true;
    public static FileHandler getLogFile(){
        if(logFileMade){
            try
            {
                theLogFile = new FileHandler("/home/lvuser/robot.txt");
                logFileMade = false;
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                System.out.println("Failed to open log file");
            }
        }
        return theLogFile;
    }

    @Override
    protected void initDefaultCommand() {

    }

}