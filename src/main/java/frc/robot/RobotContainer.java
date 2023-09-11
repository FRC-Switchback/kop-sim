// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import frc.robot.commands.DefaultDrive;
import frc.robot.subsystems.drivebase.DrivebaseLogic;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
    controller = new CommandPS4Controller(0);
  }

  CommandPS4Controller controller;

  private void configureBindings() {
    DrivebaseLogic.instance.setDefaultCommand(new DefaultDrive(() -> -controller.getLeftY(), () -> -controller.getRightX()));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}