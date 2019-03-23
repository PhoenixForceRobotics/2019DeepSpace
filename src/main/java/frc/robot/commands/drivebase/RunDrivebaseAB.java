package frc.robot.commands.drivebase;

import frc.robot.subsystems.OI;
import frc.robot.subsystems.DriveBaseAB;

import java.util.logging.Logger;
import frc.robot.utility.Log;
import frc.robot.Constants;
import frc.robot.utility.CustomMath;

import edu.wpi.first.wpilibj.command.Command;

public class RunDrivebaseAB extends Command{

    private OI oiAb;
    private DriveBaseAB driveBaseAb;
    private CustomMath customMathB;
    private double multiplyer;
    //Creates needed variables
    
    public RunDrivebaseAB(DriveBaseAB driveBaseAb, OI oiAb) {

        requires(driveBaseAb);
        customMathB = new CustomMath();

        this.driveBaseAb = driveBaseAb;
        this.oiAb = oiAb;
       
    }

    @Override
    public void initialize(){

    }
    
    @Override
    public void execute()
    {
        //I am not sure as to why this was overridden, I will have to ask Evan
        //This is the part of the show where we get to move the drivebase

        multiplyer = driveBaseAb.getMultiplyer();
        
        driveBaseAb.setLeft (customMathB.makeSign(oiAb.driverController.rightStick.getY(), multiplyer * Math.pow(oiAb.driverController.rightStick.getY(), Constants.SubsystemSpeeds.DrivebaseValues.StickPower)));
        driveBaseAb.setLeft (customMathB.makeSign(oiAb.driverController.rightStick.getX(), multiplyer * Math.pow(oiAb.driverController.leftStick.getY(), Constants.SubsystemSpeeds.DrivebaseValues.StickPower)));
        //This is the part of the show where the code goes ahead and actually drives the robot, taking the value
        //that is returned from the stick ad using it with the custom math to make sure that the robot is actually able to drive

    }

    @Override
    protected boolean isFinished() {
        return false; 
        //I need to ask and find out what this part of the code does

    }

    @Override
    public void interrupted() {
        //This is a thing that I need to ask Evan about

    }

    @Override
    public void end(){


        driveBaseAb.setLeft(0);
        driveBaseAb.setRight(0);
        //The variable (0) means that the motors are ended

    } 
}

