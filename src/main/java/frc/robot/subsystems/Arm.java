package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
    private CANSparkMax lowerArm, upperArm;

    public Arm() {
        this.lowerArm = new CANSparkMax(Constants.Subsystems.LowerArm.kPORT, MotorType.kBrushless);
        this.upperArm = new CANSparkMax(Constants.Subsystems.UpperArm.kPORT, MotorType.kBrushless);
    }

    public void lowerArmUp() {
        this.lowerArm.set(Constants.Subsystems.LowerArm.kPOWER);
    }

    public void lowerArmDown() {
        this.lowerArm.set(-Constants.Subsystems.LowerArm.kPOWER);
    }

    public void lowerArmStop() {
        this.lowerArm.stopMotor();
    }

    public void upperArmUp() {
        this.upperArm.set(Constants.Subsystems.UpperArm.kPOWER);
    }

    public void upperArmDown() {
        this.upperArm.set(-Constants.Subsystems.UpperArm.kPOWER);
    }

    public void upperArmStop() {
        this.upperArm.stopMotor();
    }
}
}
