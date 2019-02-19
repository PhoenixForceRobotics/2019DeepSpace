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
    private OI oi;
    private double point;
    private boolean a;
    private boolean b;
    private boolean c;

    public RunElevator()
    {
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
        this.oi = Robot.oi;
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
            System.out.println("shit");
        } else if(!a && b && !c){
            elevator.setSetpoint(Constants.ElevatorSetPoints.MIDDLE);
            elevator.enable();
            System.out.println("shit2");
        } else if(!a && !b && c){
            elevator.setSetpoint(Constants.ElevatorSetPoints.BOTTOM);
            elevator.enable();
            System.out.println("shit3");
        } else {
            elevator.disable();   
            System.out.println("shit4");     
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