package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.OI;

import frc.robot.Robot;
import frc.robot.subsystems.Flywheel;
import edu.wpi.first.wpilibj.command.Command;

/*

public class AutoCollectCubeOpened extends CommandGroup {

	public AutoCollectCubeOpened(boolean liftWristAfterCubeCollected) {

		addParallel(new StartDriverControllerRumble(1.0));
		addParallel(new StartOperatorControllerRumble(1.0));
		addParallel(new WristGoToCollectCube());

 */
public class ShootFlywheel extends Command
{
    private Flywheel flywheel;
    private OI oi;
    private Timer spinup;

    public ShootFlywheel(){
        requires(Robot.flywheel);

        this.flywheel = Robot.flywheel;
    }

    public void initialize() {
        this.oi = Robot.oi;
        spinup = new Timer();
        spinup.reset();
        spinup.start();
        setTimeout(.9);
    }


    public void execute() {
        System.out.println(spinup.get());
        if(spinup.get() < .5){
            flywheel.shoot(ControlMode.PercentOutput, 1);
        } else {
            flywheel.shoot(ControlMode.PercentOutput, 1);
            flywheel.outtake(ControlMode.PercentOutput, true);
        }
    }


    public boolean isFinished()
    {
        return isTimedOut();
    //     System.out.println(oi.theXboxController.rightTriggerButton.get());
    //     if (oi.theXboxController.rightTriggerButton.get())
    //     { return false;}
    //     else
    //     { return true;}
    // 
    }


    public void end() {
        flywheel.shoot(ControlMode.PercentOutput, 0);
        flywheel.outtake(ControlMode.PercentOutput, false);
    }

    @Override
    public void interrupted() {

    }
}
