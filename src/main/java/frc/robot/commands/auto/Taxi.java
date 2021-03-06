// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import frc.robot.commands.DriveDistance;
import frc.robot.commands.Intake;
import frc.robot.commands.IntakeDeploy;
import frc.robot.commands.TurnGyro;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake_Actuate;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class Taxi extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final Drivetrain m_drivetrain;

  /**
   * Creates a new ExampleCommand.
   *
   * @param driveSS The subsystem used by this command.
   */
  public Taxi(Drivetrain driveSS) {

    m_drivetrain = driveSS;

    addCommands(
        new DriveDistance(2, 0.4, m_drivetrain)
    );
  }
}
