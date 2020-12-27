/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.cscore.CvSink;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SlewRateLimiter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private final DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(6, 7);
  private final Compressor m_compressor = new Compressor(0);
  private final Joystick stick = new Joystick(0);
  WPI_TalonSRX mlt9 = new WPI_TalonSRX(9);
  WPI_VictorSPX mlv1 = new WPI_VictorSPX(1);
  WPI_TalonSRX mrt0= new WPI_TalonSRX(0);
  WPI_VictorSPX mrv7 = new WPI_VictorSPX(7);
  DifferentialDrive drive=new DifferentialDrive(mlt9,mrt0);
  private UsbCamera camera;
  private CvSink cvSink1;
  SlewRateLimiter smallDickYuCheng =new SlewRateLimiter(0.8);

  @Override
  public void robotInit() {
    camera= CameraServer.getInstance().  startAutomaticCapture(); 
camera.setResolution(320, 240);
 camera.setFPS(2);
 cvSink1= CameraServer.getInstance().getVideo(camera);
cvSink1.setEnabled(true);

    
    mlt9.configFactoryDefault();
    mlv1.configFactoryDefault(); 
    mrt0.configFactoryDefault();
    mrv7.configFactoryDefault();
    mlt9.follow(mlv1);
    mrt0.follow(mrv7);
    
  }

  @Override
  public void robotPeriodic() {
  }
 
  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
 
  drive.arcadeDrive(stick.getY(), stick.getZ());
  double y = smallDickYuCheng.calculate(stick.getY());
  double z = smallDickYuCheng.calculate(stick.getZ());



}
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}

