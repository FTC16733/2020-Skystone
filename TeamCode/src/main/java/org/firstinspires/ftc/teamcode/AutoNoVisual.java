package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="AutoNoVisual", group="Linear Opmode")

public class AutoNoVisual extends LinearOpMode{
    DcMotor motor1, motor2;
    Servo servo1;
    int encoderCount = RobotPreferences.encoderCount;
    double wheelSize = RobotPreferences.wheelSize;
    double wheelCircumference = RobotPreferences.wheelCircumference;
    double distancePerPulse = RobotPreferences.distancePerPulse;
    double pulsePerInch = RobotPreferences.pulsePerInch;
    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime autotime = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
        motor1 = hardwareMap.get(DcMotor.class, RobotPreferences.motor1);
        motor2 = hardwareMap.get(DcMotor.class, RobotPreferences.motor2);
        servo1 = hardwareMap.get(Servo.class, RobotPreferences.servo1);
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        encoderDrive(1.0, 0, 0, 1000);
        encoderDrive(1.0, 0, 0, 3000);
        encoderDrive(1.0, 0, 0, 1000);
        encoderDrive(1.0, 0, 0, 1000);
    }

    public void encoderDrive(double speed, double leftInches, double rightInches, double timeout) {
        encoderStopAndResetEncoder();
        int newLeftTarget1;
        int newRightTarget1;
        if (opModeIsActive()) {
            newLeftTarget1 = motor1.getCurrentPosition() + (int)(leftInches * pulsePerInch);
            newRightTarget1 = motor2.getCurrentPosition() + (int)(leftInches * pulsePerInch);
            encoderSetTargetPosition(newLeftTarget1, newRightTarget1);
            encoderRunToTargetPosition();
            runtime.reset();
            while((motor2.getCurrentPosition()< newLeftTarget1)&&(motor1.getCurrentPosition()<newRightTarget1)){
                encoderSetPower(speed);
            }
            encoderSetPower(0);

        }

    }
    public void encoderRunToTargetPosition(){
        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public void encoderStopAndResetEncoder(){
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void encoderSetTargetPosition(int target1, int target2){
        motor1.setTargetPosition(target1);
        motor2.setTargetPosition(target2);
    }

    public void encoderSetPower(double speed){
        motor2.setPower(speed);
        motor1.setPower(speed);
    }

}
