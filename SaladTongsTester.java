package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="SaladTongTester", group="Iterative Opmode")

public class SaladTongsTester extends OpMode  {

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

    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {
        telemetry.addData("Status", "Running: " + runtime.toString());
        telemetry.addData("memes are", robot.leftTong.getPosition() + robot.rightTong.getPosition());


        while (gamepad1.left_bumper) {
            robot.rightTong.setPosition(0);
            robot.leftTong.setPosition(1);

        }

        robot.rightTong.setPosition(1);
        robot.leftTong.setPosition(0);

    }

    @Override
    public void stop() {
    }

}