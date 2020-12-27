/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Compressor;



public class Robot extends TimedRobot {
  private final Joystick mystick = new Joystick(0);
  private final Compressor myCompressor= new Compressor();
  private final DoubleSolenoid mydoubleSolenoid = new DoubleSolenoid(0,1);

  @Override
  public void robotInit() {
    
    
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
    myCompressor.setClosedLoopControl(true);
   
    if (mystick.getRawButton(2)) {
      mydoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    } else if (mystick.getRawButton(1)) {
      mydoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
 
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

