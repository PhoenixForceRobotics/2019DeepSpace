package frc.robot.commands.elevator;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.subsystems.OI;
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class ElevatorPID extends PIDCommand
{
    private Elevator elevator;
    private OI oi;
    private double fineControl;
    private double newOutput;

    private static final Logger logger = Log.configureLog(ElevatorPID.class.getName());

    public ElevatorPID()
    {
        super(0,0,0);
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
        this.oi = Robot.oi;
    }

    @Override
    protected double returnPIDInput() {
        return elevator.elevatorEncoder.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        fineControl = oi.operatorController.leftStick.getY()/2;
        newOutput = output + fineControl;
        elevator.elevator1.set(newOutput);
        elevator.elevator2.set(-newOutput);
        elevator.elevator3.set(newOutput);
        elevator.elevator4.set(-newOutput);
    }

    public void PIDUp(double setpoint){
        super.getPIDController().reset();
        super.getPIDController().setPID(Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.kp,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.ki,
                                        Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.kd);
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
