package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Motor;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class CrschnsDrivebase extends Subsystem{

    public Motor leftf, leftm, leftb; 
    public Motor rightf, rightm, rightb;
    public double Multiplier = 1;

    public CrschnsDrivebase(){ //Defining drivebase motors
        leftf = new Motor(Constants.MotorMap.CrschnsDrivebase.LEFT_1, MotorType.kBrushless, Constants.MotorMap.CrschnsDrivebase.LEFT1_REVERSED, 40);
        leftm = new Motor(Constants.MotorMap.CrschnsDrivebase.LEFT_2, MotorType.kBrushless, Constants.MotorMap.CrschnsDrivebase.LEFT2_REVERSED, 40);
        leftb = new Motor(Constants.MotorMap.CrschnsDrivebase.LEFT_3, MotorType.kBrushless, Constants.MotorMap.CrschnsDrivebase.LEFT3_REVERSED, 40);

        rightf = new Motor(Constants.MotorMap.CrschnsDrivebase.RIGHT_1, MotorType.kBrushless, Constants.MotorMap.CrschnsDrivebase.RIGHT1_REVERSED, 40);
        rightm = new Motor(Constants.MotorMap.CrschnsDrivebase.RIGHT_2, MotorType.kBrushless, Constants.MotorMap.CrschnsDrivebase.RIGHT2_REVERSED, 40);
        rightb = new Motor(Constants.MotorMap.CrschnsDrivebase.RIGHT_3, MotorType.kBrushless, Constants.MotorMap.CrschnsDrivebase.RIGHT3_REVERSED, 40);
    
        //Makes middle and back follow front motors
        leftm.follow(leftf);
        leftb.follow(leftf);
            
        rightm.follow(rightf);
        rightb.follow(rightb);
    }

    public void setLeftf(double value) { //Sets left motor values
        leftf.set(value);
    }

    public void setRightf(double value) { //Sets right motor values
        rightf.set(value);
    }

    public void turtlemode()
    {
        if(Multiplier == 1){
            Multiplier = .01;
        } else {
            Multiplier = 1; 
        }
    }

	@Override
	protected void initDefaultCommand() {
		
	}

	public double getmultiplier() {
		return 0;
	}
        
}