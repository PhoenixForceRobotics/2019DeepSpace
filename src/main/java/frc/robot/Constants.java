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
            public static int LEFT_1 = 1;
            public static int LEFT_2 = 2;
            public static int LEFT_3 = 3;

            public static int RIGHT_1 = 12;
            public static int RIGHT_2 = 13;
            public static int RIGHT_3 = 14;

            public static final boolean LEFT1_REVERSED = false;
            public static final boolean LEFT2_REVERSED = false;
            public static final boolean LEFT3_REVERSED = false;

            public static final boolean RIGHT1_REVERSED = true;
            public static final boolean RIGHT2_REVERSED = true;
            public static final boolean RIGHT3_REVERSED = true;

            //H-drive motors
            public static int HDRIVE1 = 16;
            public static int HDRIVE2 = 15;
            
            public static final boolean HDRIVE1_REVERSED = true;
            public static final boolean HDRIVE2_REVERSED = true;
        }

        public static class BallCollector
        {
            public static int BALL_ROTATE = 6;
            public static int BALL_ROTATE1 = 7;
            public static int COLLECTOR_LEFT = 5;
            public static int COLLECTOR_RIGHT = 4;

            public static final boolean BALLROTATE_REVERSED = true;
            public static final boolean BALLROTATE1_REVERSED = false;
            public static final boolean COLLECTORLEFT_REVERSED = true;
            public static final boolean COLLECTORRIGHT_REVERSED = false;
        }

        public static class Elevator
        {
            public static int ELEVATOR1 = 10;
            public static int ELEVATOR2 = 11;
            public static int ELEVATOR3 = 8;
            public static int ELEVATOR4 = 9;

            public static final boolean ELEVATOR1_REVERSED = true;
            public static final boolean ELEVATOR2_REVERSED = false;
            public static final boolean ELEVATOR3_REVERSED = true;
            public static final boolean ELEVATOR4_REVERSED = true;
        }
    
    }
    public static class PneumaticsMap{
        public static class HatchCollector {
            public static int PUNCHER1 = 0;
            public static int PUNCHER2 = 1;
        }
    }
    public static class ElevatorSetPoints
    {
        public static final double BOTTOM = .2;
        public static final double MIDDLE = .75;
        public static final double TOP = 1.13;
    }

    public static class CollectorSetPoints
    {
        public static final double DOWN = .15;
        public static final double UP = 1.0;
    }

    public static class EncoderMap{
        public static class Collector 
        {
            public static int COLLECTORDIGITAL1 = 4;
            public static int COLLECTORDIGITAL2 = 5;
            public static final boolean COLLECTORDIGITAL_REVERSED = true;
        }
        public static class Elevator
        {
            public static int ELEVATORDIGITAL1 = 10;
            public static int ELEVATORDIGITAL2 = 11;
            public static boolean ELEVATORDIGITAL_REVERSED = true;
        }
    }
    public static class SubsystemSpeeds{
        public static class DrivebaseValues{
            public static double StickPower = 3;
        }
        public static class HDriveValues{
            public static double MaxSpeed = 1;
            public static double TimerMultiplyer = .4;
            public static int TiggerPower = 2;
            public static double TimerPower = 1.5;
        }
        public static class HatchCollectorValues
        {
            public static final double HCspeed = .5;
        }
        public static class BallCollectorValues
        {
            public static final double BCIntakeSpeed = .4;
            public static final double BCOuttakeSpeed = .4;
            public static final double BCRotateSpeed = 1;
        }
        public static class ElevatorPIDConstants
        {
            public static final class UP
            {
                public static final double kp = -3.75;
                public static final double ki = .00;
                public static final double kd = -5.25;
            }
            public static final class DOWN
            {
                public static final double kp = -.3;
                public static final double ki = .00;
                public static final double kd = -1;
            }
            public static final double tolerance = .05;
        }
        public static class RotateCollectorPIDConstants
        {
            public static final class UP
            {
                public static final double kp = .00;
                public static final double ki = .00;
                public static final double kd = .00;
            }
            public static final class DOWN
            {
                public static final double kp = .00;
                public static final double ki = .00;
                public static final double kd = .00;
            }
            public static final double tolerance = 3;
        }
    }
    public static class OIMap {
      
    }

    public static class Misc {
        public static Level logLevel = Level.FINEST;
   }
}