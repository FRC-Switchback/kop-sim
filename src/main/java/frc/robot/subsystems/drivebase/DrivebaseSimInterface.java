package frc.robot.subsystems.drivebase;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import frc.robot.Constants;
import frc.robot.subsystems.drivebase.DrivebaseInterface.DrivebaseInterfaceInputs;

public class DrivebaseSimInterface implements DrivebaseInterface {
    DifferentialDrivetrainSim sim = DifferentialDrivetrainSim.createKitbotSim(KitbotMotor.kDualCIMPerSide, KitbotGearing.k10p71, KitbotWheelSize.kSixInch, null);

    @Override
    public void updateInputs(DrivebaseInterfaceInputs inputs) {
        sim.update(0.02);
        inputs.leftPositionRadian = sim.getLeftPositionMeters() / Constants.Drivebase.WHEEL_RADIUS_METERS;
        inputs.leftVelocityRadiansSecond = sim.getLeftVelocityMetersPerSecond() / Constants.Drivebase.WHEEL_RADIUS_METERS;
        inputs.leftPositionMeter = sim.getLeftPositionMeters();

        inputs.rightPositionRadian = sim.getRightPositionMeters() / Constants.Drivebase.WHEEL_RADIUS_METERS;
        inputs.rightVelocityRadiansSecond = sim.getRightVelocityMetersPerSecond() / Constants.Drivebase.WHEEL_RADIUS_METERS;
        inputs.rightPositionMeter = sim.getRightPositionMeters();

        inputs.gyroYawRadian = sim.getHeading().getRadians() * -1;
    }

    @Override
    public void setPercents(double left, double right) {
        sim.setInputs(MathUtil.clamp(left, -1, 1) * 12, MathUtil.clamp(right, -1, 1) * 12);
    }
}
