/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
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
  private final Joystick stick = new Joystick(1);
  boolean boybottom = stick.getRawButton(0);

  WPI_VictorSPX lM = new WPI_VictorSPX(1);
  WPI_VictorSPX lF = new WPI_VictorSPX(3);
  WPI_VictorSPX rM= new WPI_VictorSPX(2);
  WPI_VictorSPX rF = new WPI_VictorSPX(4);
  DifferentialDrive drive=new DifferentialDrive(lM,rM);
  SlewRateLimiter smallDickYuCheng =new SlewRateLimiter(0.8);

  @Override
  public void robotInit() {
    lF.configFactoryDefault();
    lM.configFactoryDefault(); 
    rF.configFactoryDefault();
    rM.configFactoryDefault();
    lF.follow(lM);
    rF.follow(rM);
    
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
     drive.curvatureDrive(stick.getY()*0.5, stick.getZ(),boybottom);

  
  double y = smallDickYuCheng.calculate(stick.getX());
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

