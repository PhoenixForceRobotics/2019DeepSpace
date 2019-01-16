package frc.robot;

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
            public static int LEFT_1 = 0;
            public static int LEFT_2 = 1;
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
        }

        public static class HatchCollector
        {
        //¯\_(ツ)_/¯ dunno what the motor is
            public static int ARMCOLLECTOR = 16;
        //Should this be true or false? 
            public static final boolean ARMCOLLECTOR_REVERSED = false;
        }

    public static class HatchCollectorSpeed 
    {
        public static final double HCspeed = .3; 
    }

    public static class OIMap {
      
        }

    }

}