package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
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

    public ShootFlywheel(){
        requires(Robot.flywheel);

        this.flywheel = Robot.flywheel;
    }

    public void initialize() {
        this.oi = Robot.oi;
        System.out.println(oi);
    }


    public void execute() {
        flywheel.outtake(ControlMode.PercentOutput, true);
    }


    public boolean isFinished()
    {
        //System.out.println(oi.theXboxController.rightTriggerButton.get());
        if (oi.theXboxController.rightTriggerButton.get())
        { return false;}
        else
        { return true;}
    }


    public void end() {
        flywheel.outtake(ControlMode.PercentOutput, false);
    }

    @Override
    public void interrupted() {

    }
}
