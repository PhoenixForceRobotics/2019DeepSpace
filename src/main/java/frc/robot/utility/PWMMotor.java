package frc.robot.utility;

import edu.wpi.first.wpilibj.Spark;

public class PWMMotor extends Spark {
    public PWMMotor(int port, boolean reversed) {
        super(port);
        setInverted(reversed);
    }
}