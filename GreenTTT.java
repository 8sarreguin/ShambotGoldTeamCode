package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Green on 10/16/2017.
 */
@TeleOp(name = "turtletribe", group = "1992buick")
public class GreenTTT extends LinearOpMode {

    DcMotor Right1;
    DcMotor Left1;
    DcMotor Center;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor Lift;

    Servo BottomGrabber1;
    Servo BottomGrabber2;
    Servo BottomLiftUp1;
    Servo BottomLiftUp2;
    Servo TopLiftUp1;
    Servo TopLiftUp2;
    Servo TopGrabber1;
    Servo TopGrabber2;
    Servo Jewel1;
    Servo Jewel2;



    boolean turtle = false;
    boolean tiger = false;

    public void runOpMode() {

        Right1 = hardwareMap.dcMotor.get("Right1");
        Left1 = hardwareMap.dcMotor.get("Left1");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        Center = hardwareMap.dcMotor.get("Center");
        Lift = hardwareMap.dcMotor.get("Lift");
        BottomGrabber1 = hardwareMap.servo.get("BottomGrabber1");
        BottomLiftUp1 = hardwareMap.servo.get("BottomLiftUp1");
        BottomLiftUp2 = hardwareMap.servo.get("BottomLiftUp2");
        BottomGrabber2 = hardwareMap.servo.get("BottomGrabber2");
        TopLiftUp1 = hardwareMap.servo.get("TopLiftUp1");
        TopLiftUp2 = hardwareMap.servo.get("TopLiftUp2");
        TopGrabber1 = hardwareMap.servo.get("TopGrabber1");
        TopGrabber2 = hardwareMap.servo.get("TopGrabber2");
        Jewel1 = hardwareMap.servo.get("Jewel1");
        Jewel2 = hardwareMap.servo.get("Jewel2");


        Right1.setDirection(DcMotorSimple.Direction.REVERSE);
        BottomGrabber1.setDirection(Servo.Direction.REVERSE);
        BottomLiftUp2.setDirection(Servo.Direction.REVERSE);
        TopGrabber2.setDirection(Servo.Direction.REVERSE);
        TopLiftUp2.setDirection(Servo.Direction.REVERSE);
        Lift.setDirection(DcMotorSimple.Direction.REVERSE);
        Center.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        BottomLiftUp1.setPosition(.5);
        BottomLiftUp2.setPosition(.5);

        TopLiftUp1.setPosition(.5);
        TopLiftUp2.setPosition(.5);

        TopGrabber1.setPosition(.8);
        TopGrabber2.setPosition(.8);

        BottomGrabber1.setPosition(0);
        BottomGrabber2.setPosition(0);

        Lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Jewel1.setPosition(.9);
        Jewel2.setPosition(.5);
        sleep(2000);

        while(opModeIsActive()) {

            frontRight.setPower(gamepad1.right_stick_y);
            Right1.setPower(gamepad1.right_stick_y);
            frontLeft.setPower(gamepad1.left_stick_y);
            Left1.setPower(gamepad1.left_stick_y);


            Center.setPower(gamepad1.right_trigger);
            Center.setPower(-gamepad1.left_trigger);
            Lift.setPower(gamepad2.right_stick_y);

            if (gamepad2.a) {
                Lift.setPower(.5);
            }

            if (gamepad2.b) {
                Lift.setPower(-.5);
            }

            BottomGrabber1.setPosition(gamepad2.left_trigger);
            BottomGrabber2.setPosition(gamepad2.right_trigger);

            if (gamepad2.right_bumper) {
                TopGrabber2.setPosition(.8);
                TopGrabber1.setPosition(.8);
            } else {
                TopGrabber1.setPosition(0);
                TopGrabber2.setPosition(0);
            }

            if (gamepad2.y && !tiger) {
                tiger = true;
                if (TopLiftUp1.getPosition() == .5 && TopLiftUp2.getPosition() == .5) {
                    TopLiftUp1.setPosition(0);
                    TopLiftUp2.setPosition(0);
                } else if (TopLiftUp1.getPosition() == 0 && TopLiftUp2.getPosition() == 0) {
                    TopLiftUp1.setPosition(.5);
                    TopLiftUp2.setPosition(.5);
                }
            } else if (!gamepad2.y) {
                tiger = false;
            }


            if (gamepad2.x && !turtle) {
                turtle = true;
                if (BottomLiftUp1.getPosition() == .5 && BottomLiftUp2.getPosition() == .5) {
                    BottomLiftUp1.setPosition(1);
                    BottomLiftUp2.setPosition(1);
                } else if (BottomLiftUp1.getPosition() == 1 && BottomLiftUp2.getPosition() == 1) {
                    BottomLiftUp1.setPosition(.5);
                    BottomLiftUp2.setPosition(.5);
                }
            } else if (!gamepad2.x) {
                turtle = false;
            }


        }
    }
}