package frc.robot.commands.elevator;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class RunElevatorUp extends PIDCommand
{
    private Elevator elevator;
    private double setpoint;

    public RunElevatorUp(double setpoint)
    {
        super(Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.kp,
                Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.ki,
                Constants.SubsystemSpeeds.ElevatorPIDConstants.UP.kd);
        requires(Robot.elevator);
        this.elevator = Robot.elevator;
        this.setpoint = setpoint;
    }
    
    @Override
    protected double returnPIDInput() {
         return elevator.elevatorEncoder.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        elevator.elevatorL.set(output);
    }

    @Override
    protected void initialize() {
        super.initialize();
        super.setSetpoint(setpoint);
    }

    @Override
    protected void execute() {
        super.execute();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        super.interrupted();
        super.end();
    }

    @Override
    protected void end() {
        super.end();
        elevator.killmotors();
    }
}
