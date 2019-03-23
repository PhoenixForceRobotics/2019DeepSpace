package frc.robot.commands.drivebase;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveBaseAB;

public class ShifterAB extends Command {
                                //As Evan where Command is
DriveBaseAB myDriveAB ;
    
  public ShifterAB (){

    requires (Robot.drivebaseAB);
    this.myDriveAB = Robot.drivebaseAB;
    //thins finds things and tells things to use the things that are above

  }

  @Override
  public void initialize(){

    myDriveAB.shift();

  }

  @Override 
  public void execute(){


  }

  @Override
  public boolean isFinished(){
    
    return true;
    //This code runs once, and not much is supposed to happen, so once it has run, it finishes.
  
  }
  
  @Override
  public void interrupted(){

    end();
    //This part of the code is designed to end the rest of the code

  }








}