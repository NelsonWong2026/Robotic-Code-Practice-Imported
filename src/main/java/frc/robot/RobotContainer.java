// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Arm.LowerArmDown;
import frc.robot.commands.Arm.LowerArmStop;
import frc.robot.commands.Arm.LowerArmUp;
import frc.robot.commands.Arm.UpperArmDown;
import frc.robot.commands.Arm.UpperArmStop;
import frc.robot.commands.Arm.UpperArmUp;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  Arm arm;

  XboxController driverController, driverPartnerController;

  JoystickButton buttonA, buttonB, buttonX, buttonY;

  POVButton upPOV, downPOV, rightPOV, leftPOV;


  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
      this.arm = new Arm();

      this.driverController = new XboxController(Constants.Control.ControllerPort.kDRIVER);
      this.driverPartnerController = new XboxController(Constants.Control.ControllerPort.kPARTNER);

      this.upPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kUP);
      this.downPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kDOWN);
      this.rightPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kRIGHT);
      this.leftPOV = new POVButton(driverPartnerController, Constants.Control.POVButton.kLEFT);

    // Configure the button bindings
    this.configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {    
    this.upPOV.onTrue(new UpperArmUp(this.arm)).onFalse(new UpperArmStop(this.arm));
    this.downPOV.onTrue(new UpperArmDown(this.arm)).onFalse(new UpperArmStop(this.arm));
    this.rightPOV.onTrue(new LowerArmDown(this.arm)).onFalse(new LowerArmStop(this.arm));
    this.leftPOV.onTrue(new LowerArmUp(this.arm)).onFalse(new LowerArmStop(this.arm));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
