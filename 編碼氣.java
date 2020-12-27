/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import javax.lang.model.element.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * 
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  private TalonSRX talon= new TalonSRX(25);
  private Joystick joy=new Joystick(0);
  @Override
  public void robotInit() {
    talon.configFactoryDefault();
    talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
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
    talon.setSelectedSensorPosition(0);
    talon.setSensorPhase(true);
  }


  @Override
  public void teleopPeriodic() {
    if(joy.getRawButton(3)){
      talon.set(ControlMode.PercentOutput, 0.3);
    }
    else if(joy.getRawButton(4)){
      talon.set(ControlMode.PercentOutput, -0.3);
    } 
    else {
      talon.set(ControlMode.PercentOutput, 0 );
    }
    SmartDashboard.putNumber("encoder p",talon.getSelectedSensorPosition());
    SmartDashboard.putNumber("encoder v",talon.getSelectedSensorVelocity());
    if(talon.getSelectedSensorPosition()>0){
      SmartDashboard.putBoolean("encoder-m", true);
      }
      else{
        SmartDashboard.putBoolean("encoder-m", false);
        }
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
