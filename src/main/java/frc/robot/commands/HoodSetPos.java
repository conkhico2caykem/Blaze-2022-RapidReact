// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.Sensors.Sensor_Limelight;
import frc.robot.subsystems.Shooter.Shooter_Hood;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class HoodSetPos extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final Shooter_Hood m_hood;
  private final Sensor_Limelight m_limelight;
  private double targetPos, currPos, error, speed;
  private double hoodDeadZone = 0.1;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public HoodSetPos(Shooter_Hood subsystem, Sensor_Limelight lime) {
    m_hood = subsystem;
    m_limelight = lime;
    targetPos = calcHoodWithLimelight();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_hood);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    speed = ShooterConstants.defHoodRPM;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      calcHoodWithLimelight();
      currPos = m_hood.getHoodEnc();
      error = targetPos - currPos;

      SmartDashboard.putNumber("auto hood pos", calcHoodWithLimelight());
      SmartDashboard.putNumber("target POS", targetPos);
      SmartDashboard.putNumber("Current pos", currPos);


      if (Math.abs(error) < 1) {
          speed = speed / 2.0;
      }
    
      if (error > hoodDeadZone) {
        m_hood.runHood(speed);
      } else if (error < -hoodDeadZone) {
        m_hood.runHood(-speed);
      } else {
        m_hood.runHood(0);
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  public double calcHoodWithLimelight() {
    targetPos = m_limelight.getDistFromFender() + 1.5;
    return targetPos;
  }
}
