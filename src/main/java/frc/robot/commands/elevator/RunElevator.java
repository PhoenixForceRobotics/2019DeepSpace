package frc.robot.commands.elevator;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

// not sure if I should be using returnPIDInput() or usePIDOutput(),
// not even sure if this will work but it builds ok... I guess we'll see.

public class RunElevator extends Command 
{
    private Elevator elevator;

    public RunElevator(Double setpoint)
    {
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
        
        elevator.setSetpoint(setpoint);
    }

    @Override
    public void initialize()
    {
        elevator.enable();
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