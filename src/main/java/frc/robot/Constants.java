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

        public static class Collector
        {
            public static int FLEFT = 9;
            public static int FRIGHT = 10;
            public static int INDEXER = 11;

            public static final boolean FLEFT_REVERSED = true;
            public static final boolean FRIGHT_REVERSED = true;
            public static final boolean INDEXER_REVERSED = true;
        }
    }

    public static class FlywheelValues
    {
        //percent speed the collector runs at
        public static final double CSPEED = .9;
    }

    public static class DrivebaseValues
    {
        public static double drivebaseStep = .1;
    }

    public static class OIMap {
        public static class ShooterButtons{
            public static final int INTAKE = 5;
            public static final int OUTTAKE = 6;
        }

    }

}