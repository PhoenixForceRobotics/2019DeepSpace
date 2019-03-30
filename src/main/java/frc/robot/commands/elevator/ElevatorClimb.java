package frc.robot.commands.elevator;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.PIDCommand;
import java.util.logging.Logger;
import frc.robot.utility.Log;

//This function as a whole is supposedly going to be used when we have the climber working but I don't
//think that it is currently in use

public class ElevatorClimb extends PIDCommand
{
    private Elevator elevator;

    private static final Logger logger = Log.configureLog(ElevatorClimb.class.getName());

    public ElevatorClimb()
    {
        super(Constants.SubsystemSpeeds.ElevatorPIDConstants.DOWN.kp,
                Constants.SubsystemSpeeds.ElevatorPIDConstants.DOWN.ki,
                Constants.SubsystemSpeeds.ElevatorPIDConstants.DOWN.kd);
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
        super.getPIDController().enable();
        super.setSetpoint(Constants.ElevatorSetPoints.Balls.TRUEBOTTOM);
    }

    @Override
    protected double returnPIDInput() {
        //System.out.println(elevator.elevatorEncoder.getPosition());
        return elevator.elevatorEncoder.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        elevator.elevator1.set(output);
        elevator.elevator2.set(-output);
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    public void end(){
        super.getPIDController().disable();
    }
}
