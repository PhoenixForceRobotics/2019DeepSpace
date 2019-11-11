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
            //Ball Rotates rotate the collector 
            //CollectorIO supposedly means Collector Intake Outake (Talk to Erin)(not my fault)(I am Evan btw)
            public static int BALL_ROTATE = 5;
            public static int BALL_ROTATE1 = 6;
            public static int COLLECTORIO = 7;

            public static final boolean BALLROTATE_REVERSED = false;
            public static final boolean BALLROTATE1_REVERSED = true;
            public static final boolean COLLECTORIO_REVERSED = true;
        }

        public static class Elevator
        {
            //These motors drive the elevator up or down
            public static int ELEVATOR1 = 10;
            public static int ELEVATOR2 = 11;

            public static final boolean ELEVATOR1_REVERSED = true;
            public static final boolean ELEVATOR2_REVERSED = true;
        }

        public static class Climber
        {
            //This colson is the current idea of getting on the level two platform
            public static int COLSON = 4;

            public static boolean COLSON_REVERSED = false;
        }
    
    }
    public static class PneumaticsMap{
        public static class HatchCollector {
            //These are the punchers that push the hatch off of the velcro
            public static int PUNCHER1 = 1;
            public static int PUNCHER2 = 0;
            //These are the alignment pins for the floor hatch collector
            public static int PIN1 = 2;
            public static int PIN2 = 3;
        }
        public static class ClimberPistons {
            //These are the ports for the pistons in the back for climbing
            public static int SOLENOID1 = 4;
            public static int SOLENOID2 = 5;
            public static int SOLENOID3 = 7;
            public static int SOLENOID4 = 6;
        }
    }
    public static class ElevatorSetPoints
    {
        //Setpoints for each height of the ball dropoff
        public static class Balls{
            //Height for ball pickup
            public static final double TRUEBOTTOM = .05;
            //Bottom level of the rocket
            public static final double BOTTOM = 12.3;
            //The only ball level for cargo ship
            public static final double CENTER = 22.7;
            //Middle level of the rocket
            public static final double MIDDLE = 33.8;
            //Top level of the rocket (obviously)(This is just here so it doesn't look uneven)
            public static final double TOP = 40.0;
        }
        //Setpoints for each height of the hatch dropoff
        public static class Hatches{
            //This is the height for both the cargo and the bottom of the rocket
            public static final double BOTTOM = 0.05;
            public static final double MIDDLE = 20.0;
            public static final double TOP = 40.0;
        }
    }

    //These are the setpoints for rotation of the collector
    public static class CollectorSetPoints
    {
        //Inside the robot
        public static final double BACK = 0;
        //This is the 90 degree angle for hatch dropoff
        public static final double MIDDLE = 6.42;
        //This is the angle for shooting level 3 or the bottom of the rocket
        public static final double SHOOT = 10.25;
        //Against the ground for hatch pickup and ball intake
        public static final double FRONT = 13.90;
        //This Drives the collector into the ground for climbing
        public static final double CLIMB = .28;
    }

    public static class SubsystemSpeeds{
        public static class DrivebaseValues{
            //This is the power that the stick input is raised to
            public static double StickPower = 3;
        }
        public static class HDriveValues{
            //Max spped of the HDrive
            public static double MaxSpeed = 1;
            //This is the power that the Trigger input is raised to
            public static int TiggerPower = 2;
            //These impact the speed at which the timer value grows for HDrive accel
            public static double TimerMultiplyer = .4;
            public static double TimerPower = 1.5;
        }
        public static class BallCollectorValues
        {
            public static final double BCIntakeSpeed = .7;
            public static final double BCOuttakeSpeed = .6;
        }
        public static class ClimberValues
        {
            public static final double ColsonSpeed = .5;
        }
        public static class ElevatorPIDConstants
        {
            //Values for holding the elevator in place
            public static final class STEADY
            {
                public static final double kp = -6;
                public static final double ki = .00;
                public static final double kd = .00;
            }
            //Values for bringing the elevator up
            public static final class UP
            {
                public static final double kp = .2;
                public static final double ki = .00;
                public static final double kd = .4;
            }
            //Values for bringing the elevator down
            public static final class DOWN
            {
                public static final double kp = .05;
                public static final double ki = .00;
                public static final double kd = .2;
            }
            public static final double tolerance = .05;
        }
        public static class RotateCollectorPIDConstants
        {
            //Values for bringing the Rotator out of the robot
            public static final class FORWARD
            {
                public static final double kp = 0.20;
                public static final double ki = 0;
                public static final double kd = 0;
            }
            //Values for bringing the Rotator into the robot
            public static final class BACK
            {
                public static final double kp = 0.20;
                public static final double ki = 0;
                public static final double kd = 0;
            }
            //Values for holding the collector in place (I don't think it is used currently)
            public static final class STEADY
            {
                public static final double kp = -7;
                public static final double ki = 0;
                public static final double kd = 0;
            }
            //Slams the collector against the climbing platform HARD
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
        //The log level that is actually recorded
        public static Level logLevel = Level.WARNING;
    }
}