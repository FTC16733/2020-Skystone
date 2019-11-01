package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="TeleOp1", group="Iterative OpMode")
public class Teleop extends OpMode {

    
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    Servo servo1;
    Servo servo2;
    @Override
    public void init() {
        frontLeftMotor = hardwareMap.get(DcMotor.class, RobotPreferences.motor1);
        frontRightMotor = hardwareMap.get(DcMotor.class, RobotPreferences.motor3);
        backLeftMotor =hardwareMap.get(DcMotor.class, RobotPreferences.motor2);
        backRightMotor =hardwareMap.get(DcMotor.class, RobotPreferences.motor4);


        servo1 = hardwareMap.get(Servo.class, RobotPreferences.servo1);
        servo2 = hardwareMap.get(Servo.class, RobotPreferences.servo2);
    }

    @Override
    public void loop(){
        mecanumDrive(-gamepad1.left_stick_x, gamepad1.right_stick_x, -gamepad1.left_stick_y );
      //  servo1(gamepad1.a,gamepad1.b);
        if(gamepad1.a){
            servo(0,servo1);
        }
        else if(gamepad1.b){
            servo(90, servo1);
        }
        if(gamepad1.a){
            servo(0, servo2);
        }
        else if(gamepad1.b){
            servo(90, servo2);
        }
        telemetry.addData("Running: ", "Running at %7d: %7d: %7d: %7d", frontLeftMotor.getCurrentPosition(), frontRightMotor.getCurrentPosition(), backLeftMotor.getCurrentPosition(), backRightMotor.getCurrentPosition());
        telemetry.update();
    }




    private void mecanumDrive(double leftx, double lefty, double rightx) {
        double fl = lefty-leftx+rightx;
        double fr = lefty+leftx-rightx;
        double bl = lefty+leftx+rightx;
        double br = lefty-leftx-rightx;
        frontLeftMotor.setPower(fl);
        frontRightMotor.setPower(fr);
        backLeftMotor.setPower(bl);
        backRightMotor.setPower(br);
    }

    public void servo(int position, Servo servo){
        servo.setPosition(position);
    }

}