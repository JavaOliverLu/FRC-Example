package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;

public class Robot extends TimedRobot {
  public TalonFX strangething = new TalonFX(15);
  public TalonSRX strangething1 = new TalonSRX(0);
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
    strangething.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector,LimitSwitchNormal.NormallyClosed);
  }

  @Override
  public void teleopPeriodic() {
    if(strangething1.getSensorCollection().isRevLimitSwitchClosed() ) {
      strangething1.set(ControlMode.PercentOutput,1);
    }else{
      strangething1.set(ControlMode.PercentOutput,0);
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