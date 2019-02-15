package frc.robot.commands.elevator;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

// not sure if I should be using returnPIDInput() or usePIDOutput(),
// not even sure if this will work but it builds ok... I guess we'll see.

public class RunElevator1 extends Command 
{
    private Elevator elevator;

    public RunElevator1()
    {
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
    }

    @Override
    public void initialize()
    {
        elevator.setSetpoint(Constants.ElevatorSetPoints.BOTTOM);
    }

    @Override
    public void execute()
    {
        elevator.enable();
    }

    @Override
    public boolean isFinished()
    {
        if(elevator.getSetpoint()-elevator.getPosition() < 0.1)
        {
            return true;
        }
        else
        {
            return false;
        }
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
    }
}