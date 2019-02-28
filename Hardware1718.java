package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware1718
{
    /* Public OpMode members. */
    public DcMotor     leftBackMotor         = null;
    public DcMotor     rightBackMotor        = null;
    public DcMotor     leftFrontMotor        = null;
    public DcMotor     rightFrontMotor       = null;
    public DcMotor     liftMotor1            = null;
    public DcMotor     liftMotor2            = null;
    public Servo       leftTong              = null;
    public Servo       rightTong             = null;
    public Servo       pushServoLeft         = null;
    public Servo       spinServoLeft         = null;
    public Servo       pushServoRight        = null;
    public Servo       spinServoRight        = null;
    public Servo       pinchServo            = null;
    public Servo       liftServo             = null;
    public Servo       rotateCR              = null;
    public CRServo     reachCR               = null;
    public ColorSensor cs1                   = null;
    public ColorSensor cs2                   = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware1718(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftBackMotor   = hwMap.dcMotor.get("bleft_drive");
        rightBackMotor  = hwMap.dcMotor.get("bright_drive");
        rightFrontMotor = hwMap.dcMotor.get("fright_drive");
        leftFrontMotor  = hwMap.dcMotor.get("fleft_drive");
        liftMotor1      = hwMap.dcMotor.get("lift1");
        liftMotor2      = hwMap.dcMotor.get("lift2");
        leftTong        = hwMap.servo.get("lTong");
        rightTong       = hwMap.servo.get("rTong");
        pushServoLeft   = hwMap.servo.get("pServo");
        spinServoLeft   = hwMap.servo.get("sServo");
        pushServoRight  = hwMap.servo.get("pServo2");
        spinServoRight  = hwMap.servo.get("sServo2");
        pinchServo      = hwMap.servo.get("pinchServo");
        liftServo       = hwMap.servo.get("liftServo");
        rotateCR        = hwMap.servo.get("rotateCR");
        reachCR         = hwMap.crservo.get("reachCR");
        cs1             = hwMap.colorSensor.get("cs1");
        cs2             = hwMap.colorSensor.get("cs2");
    }
}

