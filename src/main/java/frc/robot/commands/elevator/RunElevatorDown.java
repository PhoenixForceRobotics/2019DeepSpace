package frc.robot.commands.elevator;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.command.PIDCommand;
import java.util.logging.Logger;
import frc.robot.utility.Log;

public class RunElevatorDown extends PIDCommand
{
    private Elevator elevator;
    private double setpoint;

    private static final Logger logger = Log.configureLog(RunElevatorDown.class.getName());

    public RunElevatorDown(double setpoint)
    {
        super(Constants.SubsystemSpeeds.ElevatorPIDConstants.DOWN.kp,
            Constants.SubsystemSpeeds.ElevatorPIDConstants.DOWN.ki,
            Constants.SubsystemSpeeds.ElevatorPIDConstants.DOWN.kd);
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
        logger.fine("Initialize RunElevtorDown");
        super.initialize();
        super.setSetpoint(setpoint);
    }

    @Override
    protected void execute() {
        logger.fine("Execute RunElevatorDown");
        super.execute();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        logger.fine("RunElevatorDown");
        super.interrupted();
        super.end();
    }

    @Override
    protected void end() {
        logger.fine("End RunElevatorDown");
        super.end();
        elevator.killmotors();
    }
}
