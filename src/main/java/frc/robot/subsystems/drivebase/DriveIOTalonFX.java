// Copyright 2021-2023 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot.subsystems.drivebase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.subsystems.drivebase.DrivebaseInterface;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;

public class DriveIOTalonFX implements DrivebaseInterface {
    private static final double GEAR_RATIO = 6.0;

    private final WPI_TalonSRX leftLeader = new WPI_TalonSRX(0);
    private final WPI_TalonSRX leftFollower = new WPI_TalonSRX(1);
    private final WPI_TalonSRX rightLeader = new WPI_TalonSRX(2);
    private final WPI_TalonSRX rightFollower = new WPI_TalonSRX(3);

    public DriveIOTalonFX() {
        var config = new TalonFXConfiguration();
        config.CurrentLimits.StatorCurrentLimit = 30.0;
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        leftLeader.configContinuousCurrentLimit(60);
        leftFollower.configContinuousCurrentLimit(60);
        rightLeader.configContinuousCurrentLimit(60);
        rightFollower.configContinuousCurrentLimit(60);

        leftLeader.setNeutralMode(NeutralMode.Coast);
        rightLeader.setNeutralMode(NeutralMode.Coast);
        leftFollower.setNeutralMode(NeutralMode.Coast);
        rightFollower.setNeutralMode(NeutralMode.Coast);

        rightLeader.setInverted(true);
        rightFollower.setInverted(true);

        leftFollower.follow(leftLeader);
        rightFollower.follow(rightLeader);
//        leftLeader.getConfigurator().apply(config);
//        leftFollower.getConfigurator().apply(config);
//        rightLeader.getConfigurator().apply(config);
//        rightFollower.getConfigurator().apply(config);
//        leftFollower.setControl(new Follower(leftLeader.getDeviceID(), false));
//        rightFollower.setControl(new Follower(rightLeader.getDeviceID(), false));
    }

    @Override
    public void updateInputs(DrivebaseInterfaceInputs inputs) {
//        leftPosition.refresh();
//        leftVelocity.refresh();
//        rightPosition.refresh();
//        rightVelocity.refresh();
//        inputs.leftPositionRadian = Units.rotationsToRadians(leftPosition.getValue()) / GEAR_RATIO;
//        inputs.leftVelocityRadiansSecond =
//                Units.rotationsToRadians(leftVelocity.getValue()) / GEAR_RATIO;
//        inputs.rightPositionRadian =
//                Units.rotationsToRadians(rightPosition.getValue()) / GEAR_RATIO;
//        inputs.rightVelocityRadiansSecond =
//                Units.rotationsToRadians(rightVelocity.getValue()) / GEAR_RATIO;
    }

    @Override
    public void setPercents(double leftVolts, double rightVolts) {
        leftLeader.set(leftVolts);
        rightLeader.set(rightVolts);
    }
}
