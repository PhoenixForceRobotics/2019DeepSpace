package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utility.Log;
import frc.robot.utility.Motor;
import java.util.logging.Logger;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.sun.org.apache.bcel.internal.classfile.Constant;
//This is something that is not needed


public class DriveBaseAB extends Subsystem{

    public Motor leftA, leftB, leftC;
    public Motor rightA, rightB, rightC;
    //This is where I created the motors that I need to use
    private double Multiplyer = 1;
        public DriveBaseAB() {
            
            leftA = new Motor (Constants.MotorMap.Drivebase.LEFT_1,MotorType.kBrushless,Constants.MotorMap.Drivebase.LEFT1_REVERSED,40);
            leftB = new Motor (Constants.MotorMap.Drivebase.LEFT_2,MotorType.kBrushless,Constants.MotorMap.Drivebase.LEFT2_REVERSED,40);
            leftC = new Motor (Constants.MotorMap.Drivebase.LEFT_3,MotorType.kBrushless,Constants.MotorMap.Drivebase.LEFT3_REVERSED,40);
            //This is the part where I created the new motors that I am going to need, and let the code know where to find them...
            rightA = new Motor (Constants.MotorMap.Drivebase.RIGHT_1,MotorType.kBrushless,Constants.MotorMap.Drivebase.RIGHT1_REVERSED,40);
            rightB = new Motor (Constants.MotorMap.Drivebase.RIGHT_2,MotorType.kBrushless,Constants.MotorMap.Drivebase.RIGHT2_REVERSED,40);
            rightC = new Motor (Constants.MotorMap.Drivebase.RIGHT_3,MotorType.kBrushless,Constants.MotorMap.Drivebase.RIGHT3_REVERSED,40);

            leftC.follow(leftA);
            leftB.follow(leftA);
            //This is the part where the motors on the left follow the other motor
            rightC.follow(rightA);
            rightB.follow(rightA);
            //The same as the above for the motors on the right
        }

        public void setLeft(double value) {

              leftA.set(value);  
            //This sets the value of the first motor, I do not need the other one because they are following
        }

        public void setRight(double value) {

            rightA.set(value);
            //This sets the value of the next motor, I do not need the other one because they are following
        
        }

        public void Multiplyer(){

            if (Multiplyer == 1){
                Multiplyer = .25;
            }else{
                Multiplyer = 1;
            }
        }
        public double getMultiplyer(){
                return Multiplyer;
            }

      
            

		@Override
		protected void initDefaultCommand() {
			
		}
}