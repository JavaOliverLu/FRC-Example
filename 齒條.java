package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;





public class Robot extends TimedRobot {
  private TalonSRX talon = new TalonSRX(25);
  private Joystick stick = new Joystick(0);
  boolean boybottom = stick.getRawButton(3);
  boolean girlbottom = stick.getRawButton(4);
  boolean reawaubottom = stick.getRawButton(5);
  double KP =0.0005;
    
  
  @Override
  public void robotInit() {
    talon.configFactoryDefault();
    talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    talon.configClearPositionOnLimitF(true, 10);//甇??璆菟???    talon.configForwardSoftLimitThreshold(11000, 0);
    talon.configForwardSoftLimitEnable(false,10);//?神蝘?=false
    talon.configReverseSoftLimitEnable(false, 10);
    talon.configPeakOutputForward(0.5, 10);
    talon.configPeakOutputReverse(-0.5, 10);
    talon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector,LimitSwitchNormal.NormallyOpen);

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
  boolean boybottom =stick.getRawButton(3);
  boolean girlbottom =stick.getRawButton(4);
  double wrong =10000-talon.getSelectedSensorPosition();

  if (boybottom==true) {
    talon.set(ControlMode.PercentOutput,0.2);
  }
  else if (girlbottom==true) {
    talon.set(ControlMode.PercentOutput,-0.2);
  } else if (reawaubottom==true) {
    talon.set(ControlMode.PercentOutput,KP*wrong);
  } 
  else{
    talon.set(ControlMode.PercentOutput,0);
  }
  SmartDashboard.putNumber("encoder p",talon.getSelectedSensorPosition());
  SmartDashboard.putNumber("encoder v",talon.getSelectedSensorVelocity());
  if(talon.getSelectedSensorPosition()>0){
    SmartDashboard.putBoolean("encoder-m", true);
  }else{
      SmartDashboard.putBoolean("encoder-m", false);
         
  }
  SmartDashboard.putNumber("POWER",KP*wrong);
  

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
