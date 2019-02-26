package frc.robot.commands.collector;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import edu.wpi.first.wpilibj.command.PIDCommand;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.logging.Logger;
import frc.robot.utility.Log;


public class RotateUp extends PIDCommand
{   
    private Collector collector;
    private double setpoint;

    private static final Logger logger = Log.configureLog(RotateUp.class.getName());

    public RotateUp(double setpoint) {
        
        super(Constants.SubsystemSpeeds.RotateCollectorPIDConstants.UP.kp,
            Constants.SubsystemSpeeds.RotateCollectorPIDConstants.UP.ki,
            Constants.SubsystemSpeeds.RotateCollectorPIDConstants.UP.kd);
        
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
        logger.fine("Initialize RotateUp");
        super.initialize();
        super.setSetpoint(setpoint);
    }

    @Override
    protected void execute() {
        logger.fine("Execute RotateUp");
        super.execute();
    }

    @Override
    protected boolean isFinished() {
        logger.fine("RotateUp isFinished?");
        return false;
    }

    @Override
    protected void interrupted() {
        logger.fine("RotateUp interrupted");
        super.interrupted();
        super.end();
    }

    @Override
    protected void end() {
        logger.fine("End RotateUp");
        super.end();
        collector.killrotatemotors();
    }
}