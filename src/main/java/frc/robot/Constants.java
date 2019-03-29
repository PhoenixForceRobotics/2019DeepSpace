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
            public static int BALL_ROTATE = 4;
            public static int BALL_ROTATE1 = 6;
            public static int COLLECTORIO = 7;

            public static final boolean BALLROTATE_REVERSED = true;
            public static final boolean BALLROTATE1_REVERSED = false;
            public static final boolean COLLECTORIO_REVERSED = true;
        }

        public static class Elevator
        {
            public static int ELEVATOR1 = 10;
            public static int ELEVATOR2 = 11;

            public static final boolean ELEVATOR1_REVERSED = true;
            public static final boolean ELEVATOR2_REVERSED = true;
        }

        public static class Climber
        {
            public static int COLSON = 6;

            public static boolean COLSON_REVERSED = false;
        }
    
    }
    public static class PneumaticsMap{
        public static class HatchCollector {
            public static int PUNCHER1 = 1;
            public static int PUNCHER2 = 0;
            public static int PIN1 = 2;
            public static int PIN2 = 3;
        }
        public static class ClimberPistons {
            public static int SOLENOID1 = 4;
            public static int SOLENOID2 = 5;
            public static int SOLENOID3 = 7;
            public static int SOLENOID4 = 6;
        }
    }
    public static class ElevatorSetPoints
    {
        public static class Balls{
            public static final double TRUEBOTTOM = .15;
            public static final double BOTTOM = -.52;
            public static final double CENTER = -.77;
            public static final double MIDDLE = -1.17;
            public static final double TOP = -1.25;
        }
        public static class Hatches{
            public static final double BOTTOM = 0;
            public static final double MIDDLE = -.56;
            public static final double TOP = -1.25;
        }
    }

    public static class CollectorSetPoints
    {
        public static final double BACK = .05;
        public static final double MIDDLE = .22;
        public static final double FRONT = .43;
        public static final double CLIMB = .28;
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
        public static class BallCollectorValues
        {
            public static final double BCIntakeSpeed = .4;
            public static final double BCOuttakeSpeed = 1;
        }
        public static class ClimberValues
        {
            public static final double ColsonSpeed = .5;
        }
        public static class ElevatorPIDConstants
        {
            //JT added this to try a steady
            public static final class STEADY
            {
                public static final double kp = -6;
                public static final double ki = .00;
                public static final double kd = .00;
            }
            public static final class UP
            {
                public static final double kp = -7;
                public static final double ki = .00;
                public static final double kd = -13;
            }
            public static final class DOWN
            {
                public static final double kp = -1.0;
                public static final double ki = .00;
                public static final double kd = -5.0;
                //public static final double kp = -4;
                //public static final double ki = .00;
                //public static final double kd = -10;
            }
            public static final double tolerance = .05;
        }
        public static class RotateCollectorPIDConstants
        {
            public static final class FORWARD
            {
                public static final double kp = -10.00;
                public static final double ki = 0;
                public static final double kd = -16;
            }
            public static final class BACK
            {
                public static final double kp = -10.00;
                public static final double ki = 0;
                public static final double kd = -10;
            }
            public static final class STEADY
            {
                public static final double kp = -7;
                public static final double ki = 0;
                public static final double kd = 0;
            }
            public static final class CLIMB
            {
                public static final double kp = 1000;
                public static final double ki = .00;
                public static final double kd = .00;
            }
            public static final double tolerance = .05;
        }
    }
    public static class OIMap {
      
    }

    public static class Misc {
        public static Level logLevel = Level.WARNING;
   }
}