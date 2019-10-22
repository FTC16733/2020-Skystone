package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp1", group="Iterative OpMode")
public class Teleop extends OpMode {

    DcMotor leftFrontMotor;
    DcMotor rightFrontMotor;
    Servo servo1;
    @Override
    public void init() {
        leftFrontMotor = hardwareMap.get(DcMotor.class, RobotPreferences.motor1);
        rightFrontMotor = hardwareMap.get(DcMotor.class, RobotPreferences.motor2);
        servo1 = hardwareMap.get(Servo.class, RobotPreferences.servo1);
    }

    @Override
    public void loop(){
        arcadeDrive(-gamepad1.right_stick_x, gamepad1.left_stick_y);
        if(gamepad1.a){
            servo(0,servo1);
        }
        else if(gamepad1.b){
            servo(90, servo1);
        }
        }




    public void arcadeDrive(double drive , double turn){
        double leftPower = Range.clip(drive + turn, -1.0, 1.0 );
        double rightPower = Range.clip(drive-turn,-1.0, 1.0);
        leftFrontMotor.setPower(leftPower);
        rightFrontMotor.setPower(rightPower);

    }

    public void servo(int position, Servo servo){
        servo.setPosition(position);
    }

}