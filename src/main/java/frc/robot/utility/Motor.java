package frc.robot.utility;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Motor extends CANSparkMax {
    public Motor(int port, CANSparkMaxLowLevel.MotorType theMotorType, boolean reversed) {
        super(port, theMotorType);
        setInverted(reversed);
    }
}