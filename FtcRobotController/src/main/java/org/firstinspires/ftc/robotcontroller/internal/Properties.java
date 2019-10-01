package org.firstinspires.ftc.robotcontroller.internal;

public class Properties {
    public static final String Front_Right_Motor = "FrontRightMotor";
    public static final String Front_Left_Motor = "FrontLeftMotor";
    //public static final String Back_Right_Motor = "BackLeftMotor";
    //public static final String Back_Left_Motor = "BackLeftMotor";

    public static final int COUNTS_PER_REV = 0;

    public static final double Wheel_Diameter = 0 ;
    public static final double Wheel_Circumference = Wheel_Diameter * Math.PI;
    public static final double wheelSize = 0;
    public static final Integer encoderCount = 0;
    public static final double robotDiameter = 0;
    public static final double robotCircumference = robotDiameter*Math.PI;
    public static final double distancePerPulse = Wheel_Circumference / (encoderCount);
    public static final double pulsePerInch = 0;
}
