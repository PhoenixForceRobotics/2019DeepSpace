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
        elevator.elevator2.set(-output);
    }

    public void PIDUp(double setpoint){
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.kp,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.ki,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.kd);
        super.getPIDController().enable();
        super.setSetpoint(setpoint);
    }

    //jt adding this to try to build a steady state PID
    public void PIDSteady(double setpoint){
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.ElevatorPIDConstants.STEADY.kp,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.STEADY.ki,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.STEADY.kd);
        super.getPIDController().enable();
        super.setSetpoint(setpoint);
    }

    public void PIDDown(double setpoint){
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

    public void end(){
        super.getPIDController().disable();
    }
}
