package frc.robot.commands.collector;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.PIDCommand;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.logging.Logger;
import frc.robot.utility.Log;


public class RotateDown extends PIDCommand
{   
    private Collector collector;
    private double setpoint;

    private static final Logger logger = Log.configureLog(RotateUp.class.getName());

    public RotateDown(double setpoint) {
        
        super(Constants.SubsystemSpeeds.RotateCollectorPIDConstants.DOWN.kp,
            Constants.SubsystemSpeeds.RotateCollectorPIDConstants.DOWN.ki,
            Constants.SubsystemSpeeds.RotateCollectorPIDConstants.DOWN.kd);
        
        requires(Robot.collector);
        this.collector = Robot.collector;
        this.setpoint = setpoint;
    }
    
    @Override
    protected double returnPIDInput() {
        return collector.collectorEncoder.getPosition();
    }

    @Override
    protected void usePIDOutput(double output) {
        collector.collectorrotate.set(output);
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
        collector.killrotatemotors();
    }
}