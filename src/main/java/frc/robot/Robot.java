// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
// import wpilib apis
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
// creates the command run during autonomous
  private Command m_autonomousCommand;

// manages subsystems and inputs
  private final RobotContainer m_robotContainer;

// makes a new period of managing inputs
  public Robot() {
    m_robotContainer = new RobotContainer();
  }

// overrides the current state and checks for different states about every 20 ms
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run(); 
  }

//resets states or vars
  @Override
  public void disabledInit() {}

//used for monitoring or debugging
  @Override
  public void disabledPeriodic() {}

//reset settings
  @Override
  public void disabledExit() {}

//recieves auton code from m_robotContainer and schedules it as long as auton is active
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      CommandScheduler.getInstance().schedule(m_autonomousCommand);
    }
  }

//used to monitor auton or add logic
  @Override
  public void autonomousPeriodic() {}

//resets auton operation
  @Override
  public void autonomousExit() {}

//cancels auton commands if its still active and lets us shine
  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

//where driver inputs are processed
  @Override
  public void teleopPeriodic() {}

// used to exit teleop and reset settings and all states
  @Override
  public void teleopExit() {}

//cancels all commands, used for testing only
  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

//processes inputs
  @Override
  public void testPeriodic() {}

//exits and resets
  @Override
  public void testExit() {}

//simulates inputs with no bot
  @Override
  public void simulationPeriodic() {}
}
