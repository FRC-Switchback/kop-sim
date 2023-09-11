package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivebase.DrivebaseLogic;

public class DefaultDrive extends CommandBase {

    DoubleSupplier speed;

    DoubleSupplier rotation;

    public DefaultDrive(DoubleSupplier _speed, DoubleSupplier _rotation) {
        speed = _speed;
        rotation = _rotation;
        addRequirements(DrivebaseLogic.instance);
    }

    @Override
    public void execute() {
        DrivebaseLogic.instance.ArcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    }
}
