package org.firstinspires.ftc.teamcode;

    public class RobotPreferences {
        public static final String motor1 = "frontLeftMotor";
        public static final String motor2 = "frontRightMotor";
        public static final String motor3 = "backLeftMotor";
        public static final String motor4 = "backRightMotor";
        public static final String servo1 = "servo1";
        public static final String servo2 = "servo2";
        public static final Integer encoderCount = 0;
        public static final double WHEEL_DIAMETER = 90 / 25.4;
        public static final double wheelCircumference = WHEEL_DIAMETER * Math.PI;
        public static final double distancePerPulse = wheelCircumference / (encoderCount);
        public static final double pulsePerInch = 90;
}
