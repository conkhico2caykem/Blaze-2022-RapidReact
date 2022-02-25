// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.HangArms;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class WinchIn extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final HangArms m_hangArms;

  private XboxController driveController = new XboxController(OIConstants.kDriverControllerPort);
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public WinchIn(HangArms subsystem) {
    m_hangArms = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_hangArms);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (driveController.getRightTriggerAxis() > 0.1) {
      m_hangArms.runWinchArms(0.5);  
    } else {
      m_hangArms.runWinchArms(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      m_hangArms.runWinchArms(0);
  }
}
