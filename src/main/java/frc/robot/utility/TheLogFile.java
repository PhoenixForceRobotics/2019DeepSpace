package frc.robot.utility;

import java.io.IOException;
import java.text.DateFormat;
import java.util.logging.FileHandler;
import java.util.Date;
import java.text.SimpleDateFormat;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TheLogFile extends Subsystem{
    private static FileHandler theLogFile;
    private static boolean logFileMade = true;
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd_HH:mm:ss");
    private static Date date = new Date();
    private static String thePath;
    public static FileHandler getLogFile(){
        if(logFileMade){
            try
            {
                thePath = "/home/lvuser/logs/Prac_" + dateFormat.format(date).toString() + ".txt";
                theLogFile = new FileHandler(thePath);
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