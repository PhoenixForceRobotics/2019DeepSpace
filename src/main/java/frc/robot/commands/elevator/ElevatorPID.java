package frc.robot.commands.elevator;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.PIDCommand;
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class ElevatorPID extends PIDCommand
{
    private Elevator elevator;
    private double setpoint;

    private static final Logger logger = Log.configureLog(ElevatorPID.class.getName());

    public ElevatorPID()
    {
        super(0,0,0);
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
    }

    @Override
    protected double returnPIDInput() {
        System.out.println(elevator.elevatorEncoder.getPosition());
        return elevator.elevatorEncoder.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        elevator.elevator1.set(output);
        elevator.elevator2.set(output);
    }

    public void PIDUp(double setpoint){
        this.setpoint = setpoint;
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.kp,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.ki,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.kd);
        super.getPIDController().enable();
        super.setSetpoint(setpoint);
    }

    public void PIDDown(double setpoint){
        this.setpoint = setpoint;
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.ElevatorPIDConstants.DOWN.kp,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.DOWN.ki,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.DOWN.kd);
        super.getPIDController().enable();
        super.setSetpoint(setpoint);
    }

    @Override
    protected boolean isFinished(){
        return false;
    }
}
