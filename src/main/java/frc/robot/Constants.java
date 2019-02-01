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
            public static int LEFT_2 = 1;
            public static int LEFT_3 = 2;

            public static int RIGHT_1 = 7;
            public static int RIGHT_2 = 8;
            public static int RIGHT_3 = 9;

            public static final boolean LEFT1_REVERSED = true;
            public static final boolean LEFT2_REVERSED = true;
            public static final boolean LEFT3_REVERSED = true;

            public static final boolean RIGHT1_REVERSED = false;
            public static final boolean RIGHT2_REVERSED = false;
            public static final boolean RIGHT3_REVERSED = false;

            //H-drive motors
            public static int HDRIVE1 = 10;
            public static int HDRIVE2 = 11;
            
            public static final boolean HDRIVE1_REVERSED = false;
            public static final boolean HDRIVE2_REVERSED = false;
        }

        public static class HatchCollector
        {
        //¯\_(ツ)_/¯ dunno what the motor is
<<<<<<< HEAD
            public static int ARMCOLLECTOR = 12;
=======
            public static int ARMCOLLECTOR = 9;
>>>>>>> HatchCollector
        //Should this be true or false? 
            public static final boolean ARMCOLLECTOR_REVERSED = false;
        } 
        public static class BallCollector
        {
<<<<<<< HEAD
            public static int BALL_ROTATE = 15;
=======
            public static int BALL_ROTATE = 12;
>>>>>>> HatchCollector
            public static int COLLECTOR_LEFT = 13;
            public static int COLLECTOR_RIGHT = 14;

            public static final boolean BALLROTATE_REVERSED = false;
            public static final boolean COLLECTORLEFT_REVERSED = true;
            public static final boolean COLLECTORRIGHT_REVERSED = false;
        }
    }
    public static class PneumaticsMap{
        public static class HatchCollector {
            public static int PUNCHER1 = 0;
            public static int PUNCHER2 = 1;
        }
    }

    public static class EncoderMap{
        public static class HatchCollector {
            public static int ROTATE1 = 1;
            public static int ROTATE2 = 2;
        }
    }

    public static class SubsystemSpeeds{
        public static class HatchCollectorValues
        {
            public static final double HCspeed = .5;
        }
        public static class BallCollectorValues
        {
            public static final double BCIntakeSpeed = .5;
            public static final double BCOuttakeSpeed = .5;
            public static final double BCRotateSpeed = .5;
        }
    }
    public static class OIMap {
      
    }

    public static class Misc {
        public static Level logLevel = Level.FINE;
   }
}