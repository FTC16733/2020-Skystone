package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="Auto1", group="Color1")

public class Auto1 extends LinearOpMode {
    DcMotor Front_Left_Motor, Front_Right_Motor;
    int encoderCount = Properties.COUNTS_PER_REV;
    double wheelSize = Properties.wheelSize;
    double wheelCircumference = Properties.Wheel_Circumference;
    double robotDiameter = Properties.robotDiameter;
    double robotCircumference = Properties.robotCircumference;
    double distancePerPulse = Properties.distancePerPulse;
    double pulsePerInch = Properties.pulsePerInch;
    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime autotime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
    Front_Left_Motor = hardwareMap.get(DcMotor.class,Properties.Front_Left_Motor);
    Front_Right_Motor = hardwareMap.get(DcMotor.class,Properties.Front_Right_Motor);
    Front_Left_Motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    Front_Right_Motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    Front_Left_Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    Front_Right_Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    waitForStart();

    encoderDrive(0.25,0.25, 6, 6, 1000);
    encoderDrive(0.25,  0.25,6, 6, 1000);
    }
    public void encoderDrive(double leftSpeed, double rightSpeed, double leftInches, double rightInches, double timeout) {
        encoderStopAndResetEncoder();
        int newLeftTarget1;
        int newRightTarget1;
        if (opModeIsActive()) {
            newLeftTarget1 = (int) (leftInches * pulsePerInch);
            newRightTarget1 = (int) (rightInches * pulsePerInch);
            encoderSetTargetPosition(newLeftTarget1, newRightTarget1);
            encoderRunToTargetPosition();
            runtime.reset();
                encoderSetPower(leftSpeed, rightSpeed);

        }
        encoderSetPower(0,0);
        sleep(1000);
    }


    public void encoderRunToTargetPosition() {
        Front_Left_Motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Front_Right_Motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void encoderStopAndResetEncoder(){
        Front_Left_Motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Front_Right_Motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void encoderSetTargetPosition(int target1, int target2){
        Front_Left_Motor.setTargetPosition(target1);
        Front_Right_Motor.setTargetPosition(target2);
    }
    public void encoderSetPower(double leftSpeed, double rightSpeed){
        Front_Left_Motor.setPower(leftSpeed);
        Front_Right_Motor.setPower(rightSpeed);
    }
}


