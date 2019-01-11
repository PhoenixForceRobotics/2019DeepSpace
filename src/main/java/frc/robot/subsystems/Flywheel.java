package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;

public class Flywheel extends Subsystem {
    public Motor fleft;
    public Motor fright;
    public Motor indexer;

    public Flywheel(){
        fleft = new Motor(Constants.MotorMap.Collector.FLEFT, Constants.MotorMap.Collector.FLEFT_REVERSED);
        fright = new Motor(Constants.MotorMap.Collector.FRIGHT, Constants.MotorMap.Collector.FRIGHT_REVERSED);
        indexer = new Motor(Constants.MotorMap.Collector.INDEXER, Constants.MotorMap.Collector.INDEXER_REVERSED);
        fright.follow(fleft);
    }

    public void shoot(ControlMode mode, double value){
        fleft.set(mode, value);
    }
    public void intake(ControlMode mode, boolean value){
        if(value){
            fleft.set(mode, -1);
            indexer.set(mode, Constants.FlywheelValues.CSPEED);
        } else {
            fleft.set(mode, 0);
            indexer.set(mode, 0);
        }
    }
    public void outtake(ControlMode mode, boolean value){
        if(value){
            indexer.set(mode, -Constants.FlywheelValues.CSPEED);
        } else {
            indexer.set(mode, 0);
        }
    }

    @Override
    protected void initDefaultCommand() {

    }
}
