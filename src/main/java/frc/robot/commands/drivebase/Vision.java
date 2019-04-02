package frc.robot.commands.drivebase;

import java.util.logging.Logger;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Constants.MotorMap.Drivebase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.utility.Motor;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.utility.Log;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.HDrive;

import java.util.Scanner;

import frc.robot.subsystems.OI;

import frc.robot.utility.CustomMath;
import edu.wpi.first.wpilibj.Timer;
import java.lang.Math;




public class Vision extends Command
{


    public Double vis1;
    public Double vis2;
    public Double finalvis;
    public Double vis;

    //these allow the HDrive to work
    private HDrive hDrive;
    private OI oi;
    private Timer startUp;
    private CustomMath customMath;

private static final Logger logger = Log.configureLog(Vision.class.getName());

public Vision() {

    logger.fine("Vision spinup");

    Scanner visvalin = new Scanner(System.in);

    //this math finds the number that we have, I know the number that we are looking for
        vis1 = visvalin.nextDouble();
        vis2 = visvalin.nextDouble();
        finalvis = vis1 + vis2 ;

        vis = (finalvis/2);
        //the final value that I will tune to
}

    @Override
    public void initialize()
    {
        requires(Robot.hDrive);

        this.hDrive = Robot.hDrive;
    }


    @Override
    public void execute()
    {

    //activate the HDRIVE based on the value that my math is able to find

        if(vis > 151.5){
            hDrive.hDrive('r', customMath.returnLesserMag(
                Math.pow(oi.driverController.triggers.getRight(), Constants.SubsystemSpeeds.HDriveValues.TiggerPower)*Constants.SubsystemSpeeds.HDriveValues.MaxSpeed, 
                Math.pow(startUp.get(), Constants.SubsystemSpeeds.HDriveValues.TimerPower)*Constants.SubsystemSpeeds.HDriveValues.TimerMultiplyer));

        } else if(vis < 171.5){

            hDrive.hDrive('l', customMath.returnLesserMag(
                Math.pow(oi.driverController.triggers.getLeft(), Constants.SubsystemSpeeds.HDriveValues.TiggerPower)*Constants.SubsystemSpeeds.HDriveValues.MaxSpeed, 
                Math.pow(startUp.get(), Constants.SubsystemSpeeds.HDriveValues.TimerPower)*Constants.SubsystemSpeeds.HDriveValues.TimerMultiplyer));

        } else if(vis == 161.5){

            hDrive.hDrive('l',0);
        }

        else{
            hDrive.hDrive('l',0);
        }


    }


    @Override
    public void interrupted(){
        
    }

    @Override
        protected boolean isFinished()
        {
            return false;
        }


    @Override
        public void end()
        {
            hDrive.hDrive('l', 0);
        }
}

