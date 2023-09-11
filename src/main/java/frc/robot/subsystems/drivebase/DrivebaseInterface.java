package frc.robot.subsystems.drivebase;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

import edu.wpi.first.math.geometry.Pose2d;

public interface DrivebaseInterface {
    @AutoLog
    public static class DrivebaseInterfaceInputs {
        public double leftPositionMeter = 0;
        public double leftPositionRadian = 0;
        public double leftVelocityRadiansSecond = 0;
        public double rightPositionMeter = 0;
        public double rightPositionRadian = 0;
        public double rightVelocityRadiansSecond = 0;
        public double gyroYawRadian = 0;
    }

    public void updateInputs(DrivebaseInterfaceInputs inputs);

    public void setPercents(double left, double right);
}
