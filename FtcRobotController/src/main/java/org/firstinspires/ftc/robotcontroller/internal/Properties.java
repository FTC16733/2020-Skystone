package org.firstinspires.ftc.robotcontroller.internal;

public class Properties {
    public static final String Front_Right_Motor = "FrontRightMotor";
    public static final String Front_Left_Motor = "FrontLeftMotor";

    public static final int COUNTS_PER_REV = 0;

    public static final double Wheel_Diameter = 2.5 ;
    public static final double Wheel_Circumference = Wheel_Diameter * Math.PI;
    public static final double wheelSize = 3.125;
    public static final Integer encoderCount = 0;
    public static final double distancePerPulse = Wheel_Circumference / (encoderCount);
    public static final double pulsePerInch = 0;
}
