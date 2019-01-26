package frc.robot;

import java.util.logging.Level;

public class Constants
{
    public static class MotorMap
    {
        public enum Mode
        {
            DISABLED, AUTO, TELEOP, TEST
        }

        public static class Drivebase
        {
            //tank drive motors 
            public static int LEFT_1 = 0;
            public static int LEFT_2 = 3;
            public static int LEFT_3 = 2;

            public static int RIGHT_1 = 13;
            public static int RIGHT_2 = 14;
            public static int RIGHT_3 = 15;

            public static final boolean LEFT1_REVERSED = true;
            public static final boolean LEFT2_REVERSED = true;
            public static final boolean LEFT3_REVERSED = true;

            public static final boolean RIGHT1_REVERSED = false;
            public static final boolean RIGHT2_REVERSED = false;
            public static final boolean RIGHT3_REVERSED = false;

            //H-drive motors
            public static int HDRIVE1 = 9;
            public static int HDRIVE2 = 10;
            
            public static final boolean HDRIVE1_REVERSED = false;
            public static final boolean HDRIVE2_REVERSED = false;
        }

        public static class HatchCollector
        {
        //¯\_(ツ)_/¯ dunno what the motor is
            public static int ARMCOLLECTOR = 11;
        //Should this be true or false? 
            public static final boolean ARMCOLLECTOR_REVERSED = false;
        } 
        public static class BallCollector
        {
            public static int BALL_ROTATE = 4;
            public static int COLLECTOR_LEFT = 1;
            public static int COLLECTOR_RIGHT = 5;

            public static final boolean BALLROTATE_REVERSED = false;
            public static final boolean COLLECTORLEFT_REVERSED = true;
            public static final boolean COLLECTORRIGHT_REVERSED = false;
        }
    }
    public static class HatchCollectorSpeed 
    {
        public static final double HCspeed = .3;
    }
    public static class OIMap {
      
    }

    public static class Misc{
        public static Level logLevel = Level.FINE;
    }
}