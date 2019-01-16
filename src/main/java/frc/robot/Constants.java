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

        public static class BallCollector
        {
            public static int BALL_ROTATE = 3;
            public static int COLLECTOR_LEFT = 4;
            public static int COLLECTOR_RIGHT = 5;

            public static final boolean BALLROTATE_REVERSED = false;
            public static final boolean COLLECTORLEFT_REVERSED = true;
            public static final boolean COLLECTORRIGHT_REVERSED = false;
        }
    }

    //I'm keeping this in becasue we may need it in the end, but as of 1/11 I don't think we will
    public static class OIMap {

    }
}