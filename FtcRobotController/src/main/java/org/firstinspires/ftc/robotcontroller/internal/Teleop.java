package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp (name= "Tank Drive", group="TeleOp")
public class Teleop extends OpMode {
    private DcMotor FrontLeftMotor;
    private DcMotor FrontRightMotor;

    @Override
    public void init() {
        FrontLeftMotor = hardwareMap.dcMotor.get(Properties.Front_Left_Motor);
        FrontRightMotor = hardwareMap.dcMotor.get(Properties.Front_Right_Motor);
    }

    @Override
    public void loop() {
        tankDrive(gamepad1.left_stick_x, gamepad1.right_stick_x);
    }

    private void tankDrive(double leftx, double rightx) {
        double fl = leftx;
        double fr = rightx;
        FrontLeftMotor.setPower(fl);
        FrontRightMotor.setPower(fr);
    }
}