package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants.ShooterConstants;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Shooter extends SubsystemBase {
    
    // Setup motors and Encoders
    private final CANSparkMax m_Front_ShooterW = new CANSparkMax(ShooterConstants.kFrontShooterMotorPort, MotorType.kBrushless);
    private final CANSparkMax m_Back_ShooterW = new CANSparkMax(ShooterConstants.kBackShooterMotorPort, MotorType.kBrushless);

    private final RelativeEncoder m_frontShooterEncoder = m_Front_ShooterW.getEncoder();
    private final RelativeEncoder m_backShooterkEncoder = m_Back_ShooterW.getEncoder();

    // Shooter PID variables 
    private SparkMaxPIDController m_frontShootPID, m_backShootPID;
    public double kP, kI, kD, kIz, kFF; 
    public double kMaxOut, kMinOut, maxRPM;


    public Shooter() {
        m_Front_ShooterW.setInverted(ShooterConstants.frontShooterInverted);
        m_Back_ShooterW.setInverted(ShooterConstants.backShooterInverted);

        m_frontShooterEncoder.setVelocityConversionFactor(1.0);
        m_backShooterkEncoder.setVelocityConversionFactor(1.0);

        resetEncoders();
        
        // ** SETTING UP PID FOR SHOOTER
        // PID init
        m_frontShootPID = m_Front_ShooterW.getPIDController();
        m_backShootPID = m_Back_ShooterW.getPIDController();
        // PID coefficients
        kP = 6e-5; 
        kI = 0;
        kD = 0; 
        kIz = 0; 
        kFF = 1.0/5700.0; 
        kMaxOut = 1; 
        kMinOut = -1;
        maxRPM = 5700;

        // set PID coefficients
        m_frontShootPID.setP(kP);
        m_frontShootPID.setI(kI);
        m_frontShootPID.setD(kD);
        m_frontShootPID.setIZone(kIz);
        m_frontShootPID.setFF(kFF);
        m_frontShootPID.setOutputRange(kMinOut, kMaxOut);

        m_backShootPID.setP(kP);
        m_backShootPID.setI(kI);
        m_backShootPID.setD(kD);
        m_backShootPID.setIZone(kIz);
        m_backShootPID.setFF(kFF);
        m_backShootPID.setOutputRange(kMinOut, kMaxOut);

        //dashboardOut();
    }
    
    

    @Override
    public void periodic() {
    //dashboardOut();

    }

    @Override
    public void simulationPeriodic() {

    }

    public void runShooter(double frontRPM, double backRPM) {
        double frontSetpoint = frontRPM;
        double backSetpoint = backRPM;

        m_frontShootPID.setReference(frontSetpoint, CANSparkMax.ControlType.kVelocity);
        m_backShootPID.setReference(backSetpoint, CANSparkMax.ControlType.kVelocity);
      }

    /** Resets the drive encoders to currently read a position of 0. */
    public void resetEncoders() {
        m_frontShooterEncoder.setPosition(0);
        m_backShooterkEncoder.setPosition(0);
    }

    public double inchToClicks(double inches) {
        double clicks;

        clicks = inches * 10;

        return clicks;
    }


    public void dashboardOut() {
        SmartDashboard.putNumber("Front Shoot Enc", m_frontShooterEncoder.getPosition());
        SmartDashboard.putNumber("Back Shoot Enc", m_backShooterkEncoder.getPosition());

        SmartDashboard.putNumber("Front Shoot Vel", m_frontShooterEncoder.getVelocity());
        SmartDashboard.putNumber("Back Shoot Vel", m_backShooterkEncoder.getVelocity());
    }
}