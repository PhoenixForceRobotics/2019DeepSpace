package frc.robot.commands.collector;

import frc.robot.Robot;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.OI;
import frc.robot.Constants;
import frc.robot.commands.collector.CollectorPID;
import edu.wpi.first.wpilibj.command.Command;
import com.revrobotics.CANEncoder;


public class RotateCollector extends Command
{
    private boolean a;
    private boolean b;
    private boolean c;
    private double setpoint;
    private double lastSet;

    private Collector collector;
    private CANEncoder encoder;
    private OI oi;
    
    private CollectorPID collectorPID;

    public RotateCollector() {
        requires(Robot.collector);
        this.collector = Robot.collector;
        this.encoder = collector.collectorEncoder;
        this.oi = Robot.oi;
        collectorPID = new CollectorPID();
    }
    
    @Override
    protected void initialize() {     

    }

    @Override
    protected void execute() {
        a = oi.driverController.aButton.get();
        b = oi.driverController.bButton.get();
        c = oi.driverController.xButton.get();
        
        if(a && !b && !c){
            setpoint = Constants.CollectorSetPoints.BACK;
        } else if(!a && b && !c){
            setpoint = Constants.CollectorSetPoints.MIDDLE;
        } else if(!a && !b && c) {
            setpoint = Constants.CollectorSetPoints.FRONT;
        }

        if(lastSet!=setpoint){
            newCom();
        }
        lastSet = setpoint;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        collectorPID.end();
    }

    private void newCom(){
        if(encoder.getPosition() < setpoint){
            collectorPID.PIDForward(setpoint);
        } else {
            collectorPID.PIDBack(setpoint);
        }
    }
}