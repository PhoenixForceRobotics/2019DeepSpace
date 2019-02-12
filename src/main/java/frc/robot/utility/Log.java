package frc.robot.utility;

import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import frc.robot.Constants;

import java.util.logging.SimpleFormatter;

public class Log{
    public static Logger configureLog (String classname)
    {
        final Logger theLog = Logger.getLogger(classname);
        final StreamHandler handler = new StreamHandler(System.out, new SimpleFormatter());
        handler.setLevel(Constants.Misc.logLevel);
        theLog.addHandler(handler)                                       ;
        return theLog;
    }
}
              