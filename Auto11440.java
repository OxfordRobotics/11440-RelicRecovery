package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="Auto11440", group="Linear Opmode")

public class Auto11440 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private Hardware1718 robot = new Hardware1718();

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        robot.init(hardwareMap);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            //robot.leftFrontMotor.setPosition(1);
            robot.leftBackMotor.setPower(0.6);
            robot.rightBackMotor.setPower(-0.6);
            robot.leftFrontMotor.setPower(0.6);
            robot.rightFrontMotor.setPower(-0.6);

            sleep(1500);

            robot.leftBackMotor.setPower(0);
            robot.rightBackMotor.setPower(0);
            robot.leftFrontMotor.setPower(0);
            robot.rightFrontMotor.setPower(0);

            break;
        }
        }
    }