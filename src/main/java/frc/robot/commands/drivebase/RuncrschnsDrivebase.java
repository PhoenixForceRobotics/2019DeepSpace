package frc.robot.commands.drivebase;

import frc.robot.subsystems.OI;
import frc.robot.subsystems.CrschnsDrivebase;

import frc.robot.Constants;
import frc.robot.utility.CustomMath;

import edu.wpi.first.wpilibj.command.Command;

public class RuncrschnsDrivebase extends Command 
{
  private CrschnsDrivebase Drivebase;
  private OI oi;
  private CustomMath customMath;
  private double multiplier;

  public RuncrschnsDrivebase(CrschnsDrivebase drivebase, OI oi)
  {
    requires(Drivebase);
    customMath = new CustomMath();
    
    this.Drivebase = drivebase;
    this.oi = oi;
  }

    @Override
  protected void initialize() {
  }

    @Override
  protected void execute() {
    multiplier = Drivebase.getmultiplier();
    Drivebase.setLeftf(customMath.makeSign(oi.driverController.rightStick.getX(), multiplier * Math.pow(oi.driverController.rightStick.getX(), Constants.SubsystemSpeeds.DrivebaseValues.StickPower)));
    Drivebase.setRightf(customMath.makeSign(oi.driverController.leftStick.getY(), multiplier * Math.pow(oi.driverController.leftStick.getY(), Constants.SubsystemSpeeds.DrivebaseValues.StickPower)));
  }

    @Override
  protected boolean isFinished() 
  {
    return false;
  }

  
  @Override
  protected void end(){
  }

  @Override
  protected void interrupted() {
  }
}
