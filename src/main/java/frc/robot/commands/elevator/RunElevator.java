package frc.robot.commands.elevator;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

import org.graalvm.compiler.replacements.nodes.AssertionNode;
import org.junit.Assert;
import org.junit.Assert.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
// import edu.wpi.first.wpilibj.Joystick.ButtonType;
import frc.robot.subsystems.OI;
// import junit.framework.Assert;
import edu.wpi.first.wpilibj.command.Command;


public class RunElevator extends Command 
{
    private Elevator elevator;
    private OI oi;
    private double point;
    private boolean a;
    private boolean b;
    private boolean c;
    private Assert assert1;

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
                assert1.Assert.assertNotEquals(a, b);
                assert1.Assert.assertNotEquals(a, c);
                point = Constants.ElevatorSetPoints.TOP;
            } if(b){
                assert1.Assert.assertNotEquals(b, c);
                point = Constants.ElevatorSetPoints.MIDDLE;
            } if(c){
                point = Constants.ElevatorSetPoints.BOTTOM;
            }
        } catch(AssertionError assert1){
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