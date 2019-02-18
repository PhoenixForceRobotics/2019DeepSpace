package frc.robot.commands.elevator;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

import org.junit.Assert.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
// import edu.wpi.first.wpilibj.Joystick.ButtonType;
import frc.robot.subsystems.OI;
import junit.framework.Assert;
import edu.wpi.first.wpilibj.command.Command;

// not sure if I should be using returnPIDInput() or usePIDOutput(),
// not even sure if this will work but it builds ok... I guess we'll see.

public class RunElevator extends Command 
{
    private Elevator elevator;
    private OI oi;
    private double point;
    private boolean a;
    private boolean b;
    private boolean c;
    private AssertionError error;

    public RunElevator()
    {
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
        this.oi = Robot.oi;
    }

    @Override
    public void initialize()
    {
        try{
            a = Robot.oi.driverController.Dpad.Up.get();
            b = Robot.oi.driverController.Dpad.Left.get();
            c = Robot.oi.driverController.Dpad.Down.get();
            if(a){
                Assert.assertNotEquals(a, b);
                Assert.assertNotEquals(a, c);
                point = Constants.ElevatorSetPoints.TOP;
            } if(b){
                Assert.assertNotEquals(b, c);
                point = Constants.ElevatorSetPoints.MIDDLE;
            } if(c){
                point = Constants.ElevatorSetPoints.BOTTOM;
            }
        } catch(error){
            end();
        }

        elevator.setSetpoint(point);
        elevator.enable();
        setTimeout(.5);
    }

    @Override
    public void execute()
    {
        
    }

    @Override
    public boolean isFinished()
    {
        return isTimedOut();
    }

    @Override
    public void interrupted()
    {   
        end();
    }

    @Override
    public void end()
    {
        elevator.disable();
        elevator.killmotors();
    }
}