package frc.robot.commands.Arm;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class UpperArmDown extends CommandBase {
    private final Arm arm;

    public UpperArmDown(Arm arm) {
        this.arm = arm;
        addRequirements(arm);
    }

    public void initialize() {

    }

    public void execute() {
        this.arm.upperArmDown();
    }

    public void end (boolean interrupted) {

    }

    public boolean isFinished() {
        return false;
    }
}
