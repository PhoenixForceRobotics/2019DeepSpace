package frc.robot.commands.elevator;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.PIDController;
// import edu.wpi.first.wpilibj.Joystick.ButtonType;
import frc.robot.subsystems.OI;
import edu.wpi.first.wpilibj.command.Command;


public class RunElevator extends Command 
{
    private Elevator elevator;
    private boolean a;
    private boolean b;
    private boolean c;

    public RunElevator()
    {
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
    }

    @Override
    public void initialize()
    {
        a = Robot.oi.driverController.Dpad.Up.get();
        b = Robot.oi.driverController.Dpad.Left.get();
        c = Robot.oi.driverController.Dpad.Down.get();
        System.out.println(a);

        if(a && !b && !c){
            elevator.setSetpoint(Constants.ElevatorSetPoints.TOP);
            elevator.enable();
        } else if(!a && b && !c){
            elevator.setSetpoint(Constants.ElevatorSetPoints.MIDDLE);
            elevator.enable();
        } else if(!a && !b && c){
            elevator.setSetpoint(Constants.ElevatorSetPoints.BOTTOM);
            elevator.disable();
        } else {
            elevator.disable();        
        }
    }

    @Override
    public void execute()
    {
        
    }

    @Override
    public boolean isFinished()
    {
        return false;
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