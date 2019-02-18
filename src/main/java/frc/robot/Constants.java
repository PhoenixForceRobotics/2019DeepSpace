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

        public static class HatchCollector
        {
        //¯\_(ツ)_/¯ dunno what the motor is
            public static int ARMCOLLECTOR = 9;
        //Should this be true or false? 
            public static final boolean ARMCOLLECTOR_REVERSED = false;
        }

        public static class BallCollector
        {
<<<<<<< HEAD
            public static int BALL_ROTATE = 5;
            public static int BALL_ROTATE1 = 7;
            public static int COLLECTOR_LEFT = 8;
            public static int COLLECTOR_RIGHT = 9;
=======
            public static int BALL_ROTATE = 4;
            public static int COLLECTOR_LEFT = 5;
            public static int COLLECTOR_RIGHT = 6;
>>>>>>> 823ccf7128d2f8042926cba129fcfd341effdd02

            public static final boolean BALLROTATE_REVERSED = true;
            public static final boolean BALLROTATE1_REVERSED = false;
            public static final boolean COLLECTORLEFT_REVERSED = true;
            public static final boolean COLLECTORRIGHT_REVERSED = false;
        }

        public static class Elevator
        {
            public static int ELEVATORL = 10;
            public static int ELEVATORR = 11;

            public static final boolean ELEVATORL_REVERSED = false;
            public static final boolean ELEVATORR_REVERSED = true;
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
        public static final double BOTTOM = .05;
        public static final double MIDDLE = .75;
        public static final double TOP = 1.3;
    }

    public static class EncoderMap{
        public static class HatchCollector {
            public static int ROTATE = 5;
        }
        public static class Elevator
        {
<<<<<<< HEAD
            public static int ELEVATORDIGITAL1 = 11;
            public static int ELEVATORDIGITAL2 = 1;
=======
            public static int ELEVATORDIGITAL1 = 10;
            public static int ELEVATORDIGITAL2 = 11;
>>>>>>> 823ccf7128d2f8042926cba129fcfd341effdd02
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
            public static final double BCIntakeSpeed = .5;
            public static final double BCOuttakeSpeed = .5;
            public static final double BCRotateSpeed = .5;
        }
        public static class ElevatorPIDConstants
        {
<<<<<<< HEAD
            public static final double kp = .001;
=======
            public static final double kp = 0;
>>>>>>> 823ccf7128d2f8042926cba129fcfd341effdd02
            public static final double ki = .00;
            public static final double kd = .00;
            public static final double tolerance = .05;
        }
        public static class RotateBallCollectorPIDConstants
        {
            public static final double kp = .00;
            public static final double ki = .00;
            
            public static final double kd = .00;
            public static final double tolerance = 3;
        }
    }
    public static class OIMap {
      
    }

    public static class Misc {
        public static Level logLevel = Level.FINEST;
   }
}