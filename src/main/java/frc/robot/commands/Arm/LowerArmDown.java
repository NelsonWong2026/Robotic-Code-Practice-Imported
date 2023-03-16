package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class LowerArmDown extends CommandBase {
    private final Arm arm;

    public LowerArmDown(Arm arm) {
        this.arm = arm;
        addRequirements(arm);
    }

    public void initialize() {

    }

    public void execute() {
        this.arm.lowerArmDown();
    }

    public void end(boolean interrupted) {

    }

    public boolean isFinished() {
        return false;
    }


}
