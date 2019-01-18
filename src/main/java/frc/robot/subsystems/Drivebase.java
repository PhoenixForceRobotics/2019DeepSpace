package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class Drivebase extends Subsystem {
    public Motor left1, left2, left3;
    public Motor right1, right2, right3;
    public Motor hdrive1, hdrive2;

    public Drivebase() {

        left1 = new Motor(Constants.MotorMap.Drivebase.LEFT_1, Constants.MotorMap.Drivebase.LEFT1_REVERSED);
        left2 = new Motor(Constants.MotorMap.Drivebase.LEFT_2, Constants.MotorMap.Drivebase.LEFT2_REVERSED);
        left3 = new Motor(Constants.MotorMap.Drivebase.LEFT_3, Constants.MotorMap.Drivebase.LEFT3_REVERSED);

        right1 = new Motor(Constants.MotorMap.Drivebase.RIGHT_1, Constants.MotorMap.Drivebase.RIGHT1_REVERSED);
        right2 = new Motor(Constants.MotorMap.Drivebase.RIGHT_2, Constants.MotorMap.Drivebase.RIGHT2_REVERSED);
        right3 = new Motor(Constants.MotorMap.Drivebase.RIGHT_3, Constants.MotorMap.Drivebase.RIGHT3_REVERSED);

        hdrive1 = new Motor(Constants.MotorMap.Drivebase.HDRIVE1, Constants.MotorMap.Drivebase.HDRIVE1_REVERSED);
        hdrive2 = new Motor(Constants.MotorMap.Drivebase.HDRIVE2, Constants.MotorMap.Drivebase.HDRIVE2_REVERSED);
        //left1.addChild(left2);
        //left3.follow(left1);

        //right2.follow(right1);
        //right3.follow(right1);
    }
    public void setLeft(double value)
    {
        left1.set(value);
    }

    public void setRight(double value)
    {
        right1.set(value);
    }
    public void hDrive(char direction, double value){
        if(direction == 'l'){
            hdrive1.set(value);
        } else if(direction == 'r'){
            hdrive1.set(-value);
        } else {
            hdrive1.set(0);
        }
    }

    public void initDefaultCommand()
    {

    }
}