package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="BallBumperRightLeft", group="Linear Opmode")

public class BallBumperRightLeft extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private Hardware1718 robot = new Hardware1718();

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        robot.init(hardwareMap);

        double time = 0;
        robot.leftTong.setPosition(0);
        robot.rightTong.setPosition(1);
        robot.pushServoLeft.setPosition(0.039);
        robot.spinServoLeft.setPosition(0.679);
        robot.pushServoRight.setPosition(1);
        robot.spinServoRight.setPosition(0.29);
        sleep(500);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            robot.pushServoRight.setPosition(0.32);
            sleep(500);

            while ((robot.cs2.blue() < 75) && (robot.cs2.red() < 75 && time < 7)) {
                robot.spinServoRight.setPosition((robot.spinServoRight.getPosition()) - 0.01);
                sleep(500);
                time += 1;
            }

            if (robot.cs2.red() > 75) {
                robot.spinServoRight.setPosition(0.43);
                sleep(500);
                robot.spinServoRight.setPosition(0.29);
                sleep(500);
            }

            else if (time < 7){
                robot.spinServoRight.setPosition(0.20);
                sleep(500);
                robot.spinServoRight.setPosition(0.29);
                sleep(500);
            }

            robot.spinServoRight.setPosition(0.29);
            robot.pushServoRight.setPosition(1);
            sleep(1000);

            robot.leftBackMotor.setPower(0.3);
            robot.rightBackMotor.setPower(-0.6);
            robot.leftFrontMotor.setPower(0.3);
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