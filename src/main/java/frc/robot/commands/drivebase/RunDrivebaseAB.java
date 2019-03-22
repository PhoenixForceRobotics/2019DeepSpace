package frc.robot.commands.drivebase;

import frc.robot.subsystems.OI;
import frc.robot.subsystems.DriveBaseAB;

import java.util.logging.Logger;
import frc.robot.utility.Log;
import frc.robot.Constants;
import frc.robot.utility.CustomMath;

import edu.wpi.first.wpilibj.command.Command;

public class RunDrivebaseAB extends Command{

    private OI oi;
    private DriveBaseAB driveBaseAb;
    private CustomMath customMathB;
    private double Multiplyer;
    
    public void runDriveBaseAB(DriveBaseAB drivebaseAB, OI oi){

        requires(driveBaseAb);
        customMathB = new CustomMath();

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}

