// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Mode Setting
    public enum Modes {
        competition,
        test, 
        sim
    }

    public static final class ModeConstants {

        public static final Modes mode = Modes.test;
        public static final boolean navxDebug = true;
    }

    // Constants for the intake
    public static final class IntakeConstants {
        public static final int kIntakeRollerMotorPort = 14;
        public static final int kLeftIntakeArmMotorPort = 19;
        public static final int kRightIntakeArmMotorPort = 5;
        public static final int kCentererLeftMotorPort = 13;
        public static final int kCentererRightMotorPort = 4;

        // Motor inverted?
        public static final boolean intakeRollerInverted = false;
        public static final boolean intakeLeftArmInverted = true;
        public static final boolean intakeRightArmInverted = false;
        public static final boolean intakeCentererLeftInverted = true;
        public static final boolean intakeCentererRightInverted = false;

    }

    // Constants for the shooter
    public static final class ShooterConstants {
        public static final int kHighShooterMotorPort = 11;
        public static final int kLowShooterMotorPort = 10;
        public static final int kKickerMotorPort = 12;

        public static final int highODSPort = 0;
        public static final int lowODSPort = 5;

        // Motor inverted?
        public static final boolean highShooterInverted = true;
        public static final boolean lowShooterInverted = false;
        public static final boolean kickerInverted = true;
    }

    // Constants for the shooter
    public static final class HangConstants {
        public static final int kWinchLeft = 15;
        public static final int kWinchRight = 9;
        public static final int kActuateLeft = 18;
        public static final int kActuateRight = 6;

        public static final int hangActuateUpLeftLimitPort = 0;
        public static final int hangActuateUpRightLimitPort = 1;
        public static final int hangActuateDownLeftLimitPort = 2;
        public static final int hangActuateDownRightLimitPort = 3;

        // Motor inverted?
        public static final boolean winchLeftInverted = false;
        public static final boolean winchRightInverted = true;
        public static final boolean actuateLeftInverted = false;
        public static final boolean actuateRightInverted = true;
    }

    // Constants for the drivetrain
    public static final class DriveConstants {
        public static final double inchToClickScaler = 0.405;
        // DRIVE CONSTANTS SHOULD DEFAULT TO COMP ROBOT SETTINGS
        // Motor CAN port
        public static final int kLeftFrontMotorPort = 16;
        public static final int kLeftBackMotorPort = 17;
        public static final int kRightFrontMotorPort = 8;
        public static final int kRightBackMotorPort = 7;

        // Motor grouping for encoders
        public static final int[] kLeftEncoderPorts = new int[] {kLeftFrontMotorPort, kLeftBackMotorPort};
        public static final int[] kRightEncoderPorts = new int[] {kRightFrontMotorPort, kRightBackMotorPort};

        // Motor inverted?
        public static final boolean rightInverted = true;
        public static final boolean leftInverted = false;

        // Gyro PID Constants 
        /* The following PID Controller coefficients will need to be tuned */
        /* to match the dynamics of your drive system.  Note that the      */
        /* SmartDashboard in Test mode has support for helping you tune    */
        /* controllers by displaying a form where you can enter new P, I,  */
        /* and D constants and test the mechanism.                         */
        
        public static final double kP = 0.03;
        public static final double kI = 0.00;
        public static final double kD = 0.00;
        public static final double kF = 0.00;

        /* This tuning parameter indicates how close to "on target" the    */
        /* PID Controller will attempt to get.                             */

        static final double kToleranceDegrees = 2.0f;
    }

    public static final class OIConstants {
        public static final int kDriverControllerPort = 0;
        public static final int kGunnerControllerPort = 1;
    }
}
