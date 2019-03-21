package frc.robot.utility;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;
import java.util.logging.StreamHandler;
import java.io.IOException;
import java.util.logging.FileHandler;

import frc.robot.Constants;

import java.util.logging.SimpleFormatter;

public class Log{
    public static FileHandler fhandler;
    private static Level logLevel;
    public static Logger configureLog (String classname)
    {

        logLevel = Level.FINEST;

        final Logger theLog = Logger.getLogger(classname);
        final ConsoleHandler chandler = new ConsoleHandler();
        final StreamHandler shandler = new StreamHandler(System.out, new SimpleFormatter());
        final FileHandler fhandler;

        theLog.setLevel(logLevel);
        chandler.setLevel(logLevel);
        shandler.setLevel(logLevel);

        theLog.addHandler(shandler);
        theLog.addHandler(chandler);
        
        try
        {
            fhandler = new FileHandler("/home/lvuser/robot.txt");
            fhandler.setFormatter(new SimpleFormatter());
            fhandler.setLevel(logLevel);
            theLog.addHandler(fhandler);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            theLog.warning("Could not open log file");
            System.out.println("Failed to open log file");
        }

        return theLog;
    }
}
              