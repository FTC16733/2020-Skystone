package org.firstinspires.ftc.teamcode;

    public class RobotPreferences {
        public static final String motor1 = "motor1";
        public static final String motor2 = "motor2";
        public static final String servo1 = "servo1";
        public static final Integer encoderCount = 0;
        public static final double wheelSize = 0;
        public static final double wheelCircumference = wheelSize * Math.PI;
        public static final double distancePerPulse = wheelCircumference / (encoderCount);
        public static final double pulsePerInch = 90;
}
