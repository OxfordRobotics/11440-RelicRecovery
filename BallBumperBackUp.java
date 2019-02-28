package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BallBumperBackUpLeft", group="Linear Opmode")

public class BallBumperBackUp extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private Hardware1718 robot = new Hardware1718();



    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        robot.init(hardwareMap);

        robot.leftTong.setPosition(0);
        robot.rightTong.setPosition(1);
        robot.pushServoLeft.setPosition(0.039);
        robot.spinServoLeft.setPosition(0.679);
        robot.pushServoRight.setPosition(1);
        robot.spinServoRight.setPosition(0.328);
        sleep(500);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            robot.pushServoLeft.setPosition(0.709);
            sleep(500);

            while ((robot.cs1.blue() < 85) && (robot.cs1.red() < 85)) {
                robot.spinServoLeft.setPosition((robot.spinServoLeft.getPosition()) + 0.01);
                sleep(500);
            }

            if (robot.cs1.blue() > 85) {
                robot.spinServoLeft.setPosition(0.809);
                sleep(500);
                robot.spinServoLeft.setPosition(0.679);
                sleep(500);
            }

            else {
                robot.spinServoLeft.setPosition(0.548);
                sleep(500);
                robot.spinServoLeft.setPosition(0.679);
                sleep(500);
            }

            robot.pushServoLeft.setPosition(0.039);
            sleep(1000);

            robot.rightTong.setPosition(0.46);
            robot.leftTong.setPosition(0.56);

            robot.liftMotor1.setPower(1);
            sleep(750);
            robot.liftMotor1.setPower(0);

            robot.leftBackMotor.setPower(-0.6);
            robot.rightBackMotor.setPower(0.6);
            robot.leftFrontMotor.setPower(-0.6);
            robot.rightFrontMotor.setPower(0.6);

            sleep(1500);

            robot.leftBackMotor.setPower(0);
            robot.rightBackMotor.setPower(0);
            robot.leftFrontMotor.setPower(0);
            robot.rightFrontMotor.setPower(0);

            break;
        }
        }
    }