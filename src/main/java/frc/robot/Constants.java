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

            public static final boolean LEFT1_REVERSED = true;
            public static final boolean LEFT2_REVERSED = true;
            public static final boolean LEFT3_REVERSED = true;

            public static final boolean RIGHT1_REVERSED = false;
            public static final boolean RIGHT2_REVERSED = false;
            public static final boolean RIGHT3_REVERSED = false;

            //H-drive motors
            public static int HDRIVE1 = 0;
            public static int HDRIVE2 = 15;
            
            public static final boolean HDRIVE1_REVERSED = true;
            public static final boolean HDRIVE2_REVERSED = true;
        }
<<<<<<< HEAD

        public static class HatchCollector
        {
        //¯\_(ツ)_/¯ dunno what the motor is
            public static int ARMCOLLECTOR = 9;
        //Should this be true or false? 
            public static final boolean ARMCOLLECTOR_REVERSED = false;
        }

=======
>>>>>>> 9bc42461d7996d6c79d9b77887d58b2c30728c37
        public static class BallCollector
        {
            public static int BALL_ROTATE = 6;
            public static int COLLECTOR_LEFT = 7;
            public static int COLLECTOR_RIGHT = 8;

            public static final boolean BALLROTATE_REVERSED = false;
            public static final boolean COLLECTORLEFT_REVERSED = true;
            public static final boolean COLLECTORRIGHT_REVERSED = false;
        }

        public static class Elevator
        {
            public static int ELEVATORL = 21;
            public static int ELEVATORR = 42;

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
        public static final double BOTTOM = 100;
        public static final double MIDDLE = 200;
        public static final double TOP = 300;
    }

    public static class EncoderMap{
        public static class HatchCollector {
            public static int ROTATE1 = 1;
            public static int ROTATE2 = 2;
        }
        public static class Elevator
        {
            public static int ELEVATORDIGITAL1 = 0;
            public static int ELEVATORDIGITAL2 = 1;
            public static boolean ELEVATORDIGITAL_REVERSED = true;
        }
    }
    public static class SubsystemSpeeds{
        public static class HDriveValues{
            public static double MaxSpeed = .7;
            public static double TimerMultiplyer = .2;
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
    }
    public static class OIMap {
      
    }

    public static class Misc {
        public static Level logLevel = Level.FINEST;
   }
}