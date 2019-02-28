package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleOp11440", group="Iterative Opmode")

public class TeleOp11440 extends OpMode  {

    Hardware1718 robot = null;
    private boolean servoPosition = false;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robot = new Hardware1718();
        robot.init(hardwareMap);
    }


    @Override
    public void init_loop() {

        robot.pushServoLeft.setPosition(0);
        robot.pushServoRight.setPosition(1);
        robot.rightTong.setPosition(1);
        robot.leftTong.setPosition(0);
        robot.pinchServo.setPosition(1);

    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.addData("left", robot.leftTong.getPosition());
        telemetry.addData("right", robot.rightTong.getPosition());
        telemetry.addData("leftstick", gamepad2.left_stick_y);

        robot.pushServoLeft.setPosition(0);
        robot.pushServoRight.setPosition(1);

        robot.leftBackMotor.setPower(gamepad1.left_stick_y*-.75);
        robot.rightBackMotor.setPower(gamepad1.right_stick_y*.75);
        robot.leftFrontMotor.setPower(gamepad1.left_stick_y*-.75);
        robot.rightFrontMotor.setPower(gamepad1.right_stick_y*.75);

        if (gamepad1.left_trigger > 0.05) {

            robot.leftBackMotor.setPower(gamepad1.left_trigger*.75);
            robot.rightBackMotor.setPower(gamepad1.left_trigger*.75);
            robot.leftFrontMotor.setPower(gamepad1.left_trigger*-.75);
            robot.rightFrontMotor.setPower(gamepad1.left_trigger*-.75);

        }

        if (gamepad1.right_trigger > 0.05) {

            robot.leftBackMotor.setPower(gamepad1.right_trigger*-.75);
            robot.rightBackMotor.setPower(gamepad1.right_trigger*-.75);
            robot.leftFrontMotor.setPower(gamepad1.right_trigger*.75);
            robot.rightFrontMotor.setPower(gamepad1.right_trigger*.75);

        }

        if (gamepad2.left_trigger > 0.05) {

            robot.rightTong.setPosition(0.46);
            robot.leftTong.setPosition(0.56);

        }

        else {

            robot.rightTong.setPosition(1);
            robot.leftTong.setPosition(0.15);

        }

        if (gamepad2.b) {
            robot.liftMotor1.setPower(1);
        }
        else if (gamepad2.a) {
            robot.liftMotor1.setPower(-1);
        }

        else {
            robot.liftMotor1.setPower(0);
        }

        if (gamepad2.dpad_up) {
            robot.liftMotor2.setPower(-1);
        }

        else if (gamepad2.dpad_down) {

            robot.liftMotor2.setPower(1);
        }

        else {
            robot.liftMotor2.setPower(0);
        }

        if (gamepad1.b) {
            robot.liftServo.setPosition(0.15);
        }

        if (gamepad1.a) {
            robot.liftServo.setPosition(1);
        }

        robot.reachCR.setPower((gamepad2.left_stick_y+1)/2);
    }



    @Override
    public void stop() {

    }

}