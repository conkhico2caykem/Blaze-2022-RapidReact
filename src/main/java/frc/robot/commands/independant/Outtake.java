// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.independant;
import frc.robot.subsystems.Intake.Intake_Centerer;
import frc.robot.subsystems.Intake.Intake_Roller;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Outtake extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final Intake_Roller m_intakeRoller;
  private final Intake_Centerer m_intakeCenter;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Outtake(Intake_Roller subsystem, Intake_Centerer centerSubsystem) {
    m_intakeRoller = subsystem;
    m_intakeCenter = centerSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intakeRoller);
    addRequirements(m_intakeCenter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakeRoller.outtake(0.5);
    m_intakeCenter.outtake(0.1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeRoller.outtake(0.0);
    m_intakeCenter.outtake(0.0);
  }
}