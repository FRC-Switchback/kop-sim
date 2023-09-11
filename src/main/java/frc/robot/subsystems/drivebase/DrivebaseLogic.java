package frc.robot.subsystems.drivebase;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.inputs.LoggableInputs;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drivebase.DrivebaseInterface.DrivebaseInterfaceInputs;

public class DrivebaseLogic extends SubsystemBase {
    public static DrivebaseLogic instance;

    private final DrivebaseInterface drivebaseInterface;

    private final DrivebaseInterfaceInputsAutoLogged interfaceIO;

    private final DifferentialDriveOdometry odometry;

    public DrivebaseLogic(DrivebaseInterface _interface) {
        instance = this;
        drivebaseInterface = _interface;
        interfaceIO = new DrivebaseInterfaceInputsAutoLogged();
        odometry = new DifferentialDriveOdometry(new Rotation2d(), 0, 0);
    }

    public void ArcadeDrive(double speed, double rotation) {
        WheelSpeeds speeds = DifferentialDrive.arcadeDriveIK(speed, rotation, true);
        drivebaseInterface.setPercents(speeds.left, speeds.right);
    }

    @Override
    public void periodic() {
        drivebaseInterface.updateInputs(interfaceIO);        
        Logger.getInstance().processInputs("Drive", interfaceIO);

        odometry.update(new Rotation2d(-interfaceIO.gyroYawRadian), interfaceIO.leftPositionMeter, interfaceIO.rightPositionMeter);
        Logger.getInstance().recordOutput("Odometry", odometry.getPoseMeters());

        // odomLog.odom = odometry.getPoseMeters();
        // Logger.getInstance().processInputs("Odom", odomLog);
        // System.out.println(odomLog.odom);
    }

    // @AutoLog
    // public static class OdomLog{
    //     public Pose2d odom;
    // }
}
