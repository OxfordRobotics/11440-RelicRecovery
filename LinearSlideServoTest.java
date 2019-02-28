package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="SlideServoTest", group="Iterative Opmode")

public class LinearSlideServoTest extends OpMode  {

    Hardware1718 robot = null;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robot = new Hardware1718();
        robot.init(hardwareMap);
        robot.pushServoLeft.setPosition(0.79);
        robot.leftTong.setPosition(0);
        robot.rightTong.setPosition(1);
        robot.pinchServo.setPosition(0);
        robot.liftServo.setPosition(0);
        robot.rotateCR.setPosition(0);
        robot.reachCR.setPower(0);

    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.addData("reach power", robot.reachCR.getPower());
        telemetry.addData("lift power", robot.liftServo.getPosition());
        telemetry.addData("rotate position", robot.rotateCR.getPosition());
        telemetry.addData("pinch position", robot.pinchServo.getPosition());

        if (gamepad1.dpad_up) {

            if (gamepad1.a) {
                robot.reachCR.setPower(1);
            }

            if (gamepad1.b) {
                robot.reachCR.setPower(-1);
            }

            if (gamepad1.x) {
                robot.reachCR.setPower(gamepad1.left_stick_y);
            }

            if (gamepad1.left_bumper) {
                robot.liftServo.setPosition(robot.liftServo.getPosition() - 0.001);
            }

            if (gamepad1.right_bumper) {
                robot.pinchServo.setPosition(robot.pinchServo.getPosition() - 0.001);
            }

            if (gamepad1.y) {
                robot.rotateCR.setPosition(robot.rotateCR.getPosition() - 0.001);
            }

        }

        else {

            if (gamepad1.a) {
                robot.reachCR.setPower(1);
            }

            if (gamepad1.b) {
                robot.reachCR.setPower(-1);
            }

            if (gamepad1.x) {
                robot.reachCR.setPower(gamepad1.left_stick_y);
            }

            if (gamepad1.left_bumper) {
                robot.liftServo.setPosition(robot.liftServo.getPosition() + 0.001);
            }

            if (gamepad1.right_bumper) {
                robot.pinchServo.setPosition(robot.pinchServo.getPosition() + 0.001);
            }

            if (gamepad1.y) {
                robot.rotateCR.setPosition(robot.rotateCR.getPosition() + 0.001);
            }

            if (gamepad1.dpad_down) {
                robot.liftServo.setPosition(0.6);
            }

            }

    }

    @Override
    public void stop() {
    }

}