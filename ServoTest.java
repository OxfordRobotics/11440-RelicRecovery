package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="ServoTest", group="Iterative Opmode")

public class ServoTest extends OpMode  {

    Hardware1718 robot = null;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        robot = new Hardware1718();
        robot.init(hardwareMap);
    }


    @Override
    public void init_loop() {

        robot.pushServoLeft.setPosition(0.79);
        robot.leftTong.setPosition(0);
        robot.rightTong.setPosition(1);

    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.addData("csservo position", robot.pushServoLeft.getPosition());
        telemetry.addData("ltservo position", robot.leftTong.getPosition());
        telemetry.addData("rtservo position", robot.rightTong.getPosition());
        telemetry.addData("sServo position", robot.spinServoLeft.getPosition());
        telemetry.addData("csservo2 position", robot.pushServoRight.getPosition());
        telemetry.addData("sServo2 position", robot.spinServoRight.getPosition());
        telemetry.addData("red cs1 (left):", robot.cs1.red());
        telemetry.addData("blue cs1 (left):", robot.cs1.blue());
        telemetry.addData("red cs2 (right):", robot.cs2.red());
        telemetry.addData("blue cs2 (right):", robot.cs2.blue());

        if (gamepad1.a) {

            if (gamepad1.dpad_up) {
                robot.pushServoLeft.setPosition((robot.pushServoLeft.getPosition()) - 0.01);
            }

            if (gamepad1.dpad_left) {
                robot.leftTong.setPosition((robot.leftTong.getPosition()) - 0.01);
            }

            if (gamepad1.dpad_right) {
                robot.rightTong.setPosition((robot.rightTong.getPosition()) - 0.01);
            }

            if (gamepad1.dpad_down) {
                robot.spinServoLeft.setPosition((robot.spinServoLeft.getPosition()) - 0.01);
            }

            if (gamepad1.x) {
                robot.pushServoRight.setPosition((robot.pushServoRight.getPosition()) - 0.01);
            }

            if (gamepad1.b) {
                robot.spinServoRight.setPosition((robot.spinServoRight.getPosition()) - 0.01);
            }
        }

        else {

            if (gamepad1.dpad_up) {
                robot.pushServoLeft.setPosition((robot.pushServoLeft.getPosition()) + 0.01);
            }

            if (gamepad1.dpad_left) {
                robot.leftTong.setPosition((robot.leftTong.getPosition()) + 0.01);
            }

            if (gamepad1.dpad_right) {
                robot.rightTong.setPosition((robot.rightTong.getPosition()) + 0.01);
            }

            if (gamepad1.dpad_down) {
                robot.spinServoLeft.setPosition((robot.spinServoLeft.getPosition()) + 0.01);
            }

            if (gamepad1.x) {
                robot.pushServoRight.setPosition((robot.pushServoRight.getPosition()) + 0.01);
            }

            if (gamepad1.b) {
                robot.spinServoRight.setPosition((robot.spinServoRight.getPosition()) + 0.01);
            }
    }
    }

    @Override
    public void stop() {
    }

}