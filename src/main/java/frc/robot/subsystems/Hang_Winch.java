package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;

import frc.robot.Constants.*;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Hang_Winch extends SubsystemBase {
    
    // Setup motors and Encoders
    private final CANSparkMax m_WinchL = new CANSparkMax(HangConstants.kWinchLeft, MotorType.kBrushless);
    private final CANSparkMax m_WinchR= new CANSparkMax(HangConstants.kWinchRight, MotorType.kBrushless);

    private final RelativeEncoder m_WinchLEncoder = m_WinchL.getEncoder();
    private final RelativeEncoder m_WinchREncoder = m_WinchR.getEncoder();

    public Hang_Winch() {
        m_WinchL.setInverted(HangConstants.winchLeftInverted);
        m_WinchR.setInverted(HangConstants.winchRightInverted);

        m_WinchLEncoder.setVelocityConversionFactor(1.0);
        m_WinchREncoder.setVelocityConversionFactor(1.0);

        resetEncoders();

        dashboardOut();
    }
    
    

    @Override
    public void periodic() {
    dashboardOut();

    }

    @Override
    public void simulationPeriodic() {

    }

    public void runWinchArms(double WinchSpeed) {
        m_WinchL.set(WinchSpeed);
        m_WinchR.set(WinchSpeed);
    }

    /** Resets the drive encoders to currently read a position of 0. */
    public void resetEncoders() {
        m_WinchLEncoder.setPosition(0);
        m_WinchREncoder.setPosition(0);
    }

    public void dashboardOut() {

    }
}
