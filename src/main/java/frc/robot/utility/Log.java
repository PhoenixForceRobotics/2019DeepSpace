package frc.robot.utility;

import java.util.logging.Logger;
import java.util.logging.StreamHandler;
import java.io.IOException;
import java.util.logging.FileHandler;

import frc.robot.Constants;

import java.util.logging.SimpleFormatter;

public class Log{
    //private static FileHandler fhandler;
    public static Logger configureLog (String classname)
    {
        final Logger theLog = Logger.getLogger(classname);
        final StreamHandler shandler = new StreamHandler(System.out, new SimpleFormatter());
        final FileHandler fhandler;
        try
        {
          fhandler = new FileHandler("/home/lvuser/Output.txt", false);
          fhandler.setFormatter(new SimpleFormatter());
          fhandler.setLevel(Constants.Misc.logLevel);
          theLog.addHandler(fhandler);
        }
        catch (IOException ioe)
        {
            System.out.println("Failed to open log file");
        }

        shandler.setLevel(Constants.Misc.logLevel);
        theLog.addHandler(shandler);
        
        return theLog;
    }
}
              