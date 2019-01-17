package frc.robot.utility;

/*import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
*/
import edu.wpi.first.wpilibj.Spark;

public class Motor extends Spark {
    public Motor(int port, boolean reversed) {
        super(port);
        setInverted(reversed);
    }
}