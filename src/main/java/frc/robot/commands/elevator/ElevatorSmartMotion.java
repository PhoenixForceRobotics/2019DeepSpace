package frc.robot.commands.elevator;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import java.util.logging.Logger;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

import frc.robot.utility.Log;

public class ElevatorSmartMotion
{
    //local reference to elevator
    private Elevator _elevator; 
   
    private CANPIDController _pidcontroller;
    private static final Logger logger = Log.configureLog(ElevatorPID.class.getName());

    public ElevatorSmartMotion()
    {
        //create local reference to elevator and encoder
        this._elevator = Robot.elevator;
        this._pidcontroller = _elevator.elevator1.getPIDController();
    }
    /**
     * 
     * Smart Motion coefficients are set on a CANPIDController object
     * 
     * - setSmartMotionMaxVelocity() will limit the velocity in RPM of
     * the pid controller in Smart Motion mode
     * - setSmartMotionMinOutputVelocity() will put a lower bound in
     * RPM of the pid controller in Smart Motion mode
     * - setSmartMotionMaxAccel() will limit the acceleration in RPM^2
     * of the pid controller in Smart Motion mode
     * - setSmartMotionAllowedClosedLoopError() will set the max allowed
     * error for the pid controller in Smart Motion mode
     */
    
    public void DoIt(double position)
    {
    _pidcontroller.setP(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.kp);    
    _pidcontroller.setI(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.ki);
    _pidcontroller.setD(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.kd);
    _pidcontroller.setIZone(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.kiz);
    _pidcontroller.setFF(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.kff);
    _pidcontroller.setOutputRange(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.kMinOutput, Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.kMaxOutput);


    int smartMotionSlot = 0;
    _pidcontroller.setSmartMotionMaxVelocity(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.maxVel, smartMotionSlot);
    _pidcontroller.setSmartMotionMinOutputVelocity(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.minVel, smartMotionSlot);
    _pidcontroller.setSmartMotionMaxAccel(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.maxAcc, smartMotionSlot);
    _pidcontroller.setSmartMotionAllowedClosedLoopError(Constants.SubsystemSpeeds.ElevatorPIDConstants.MOTIONPROFILE.allowedErr, smartMotionSlot);

    // m_pidController.setReference(setPoint, ControlType.kSmartMotion);
    _pidcontroller.setReference(position, ControlType.kSmartMotion);
}

public void end(){
    //_pidcontroller.
}
}