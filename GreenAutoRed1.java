package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Green on 10/26/2017.
 */
@Autonomous (name = "GreenAutoRed1", group = "jeep")
public class GreenAutoRed1 extends LinearOpMode {

    DcMotor Right1;
    DcMotor Left1;
    DcMotor Center;
    DcMotor Lift;
    Servo BottomGrabber1; //(mac)
    Servo BottomGrabber2; //(cheese)
    Servo BottomLiftUp1; //(jalapeno)
    Servo BottomLiftUp2; //(jeep)
    ColorSensor ThirdEye;
    Servo Jewel1;
    Servo Jewel2;
    Servo TopLiftUp1;
    Servo TopLiftUp2;
    Servo TopGrabber1;  //they all use the same numbers that they previously had
    Servo TopGrabber2;
    DcMotor frontLeft;
    DcMotor frontRight;

    @Override
    public void runOpMode() throws InterruptedException {

        Right1 = hardwareMap.dcMotor.get("Right1");
        Left1 = hardwareMap.dcMotor.get("Left1");
        Center = hardwareMap.dcMotor.get("Center");
        Lift = hardwareMap.dcMotor.get("Lift");
        BottomGrabber1 = hardwareMap.servo.get("BottomGrabber1");
        BottomGrabber2 = hardwareMap.servo.get("BottomGrabber2");
        BottomLiftUp1 = hardwareMap.servo.get("BottomLiftUp1");
        BottomLiftUp2 = hardwareMap.servo.get("BottomLiftUp2");
        ThirdEye = hardwareMap.colorSensor.get("ThirdEye");
        Jewel1 = hardwareMap.servo.get("Jewel1");
        Jewel2 = hardwareMap.servo.get("Jewel2");
        TopLiftUp1 = hardwareMap.servo.get("TopLiftUp1");
        TopLiftUp2 = hardwareMap.servo.get("TopLiftUp2");
        TopGrabber1 = hardwareMap.servo.get("TopGrabber1");
        TopGrabber2 = hardwareMap.servo.get("TopGrabber2");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");

        TopGrabber2.setDirection(Servo.Direction.REVERSE);
        TopLiftUp2.setDirection(Servo.Direction.REVERSE);
        Left1.setDirection(DcMotorSimple.Direction.REVERSE);
        Lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BottomGrabber1.setDirection(Servo.Direction.REVERSE);
        BottomLiftUp2.setDirection(Servo.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        BottomLiftUp1.setPosition(.35);
        BottomLiftUp2.setPosition(.35);
        BottomGrabber1.setPosition(1);
        BottomGrabber2.setPosition(1);
        Jewel1.setPosition(.9);
        Jewel2.setPosition(.5);
        TopLiftUp1.setPosition(.5);
        TopLiftUp2.setPosition(.5);

        TopGrabber1.setPosition(0);
        TopGrabber2.setPosition(0);
//;
        sleep(2000);
        double Time = getRuntime();

        while (getRuntime() - Time <= 1 && opModeIsActive()){

            Jewel1.setPosition(.05);
            idle();
        }

       while (getRuntime() - Time > 1 && getRuntime() - Time < 8 && opModeIsActive()) {
           if (ThirdEye.blue() - ThirdEye.red() < 30) {

               Jewel2.setPosition(.25);
           }
           else if (ThirdEye.blue () - ThirdEye.red() > 60) {
               Jewel2.setPosition(.75);
           }
           idle();
       }

       while (getRuntime() - Time > 8 && getRuntime() - Time <  9 && opModeIsActive())
       {
           idle();
       }

       while (getRuntime() - Time >= 9 && getRuntime() - Time < 10 && opModeIsActive()){

           Jewel1.setPosition(.9);
           Jewel2.setPosition(.5);
           idle();
       }

        while(getRuntime() - Time >= 10 && getRuntime() - Time < 11 && opModeIsActive()) {

           BottomGrabber1.setPosition(.5);
            BottomGrabber2.setPosition(.5);
            BottomLiftUp2.setPosition(.5);
            BottomLiftUp1.setPosition(.5);
            idle();

        }

        while (getRuntime() - Time >= 11 && getRuntime() - Time <= 11.5 && opModeIsActive()){

            BottomLiftUp1.setPosition(1);
            BottomLiftUp2.setPosition(1);
            idle();

        }

        while(getRuntime() - Time > 11.5 && getRuntime() - Time <= 12.5 && opModeIsActive()) {

            BottomGrabber1.setPosition(1);
            BottomGrabber2.setPosition(1);
            Left1.setPower(.35);
            Right1.setPower(.35);
            frontLeft.setPower(-.35);
            frontRight.setPower(-.35);

            idle();

        }

        while (getRuntime() - Time > 12.5 && getRuntime() - Time <= 12.51 && opModeIsActive()) {

            Left1.setPower(0);
            Right1.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            idle();

        }


        while (getRuntime() - Time > 12.51 && getRuntime() - Time <= 13.5 && opModeIsActive()){
            Left1.setPower(.5);
            Right1.setPower(-.5);
            frontLeft.setPower(-.5);
            frontRight.setPower(.5);

            idle();

        }

        while (getRuntime() - Time > 13.5 && getRuntime() - Time < 14 && opModeIsActive()) {

            Left1.setPower(0);
            Right1.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            idle();
        }

        while (getRuntime() - Time >= 14 && getRuntime() - Time <= 15 && opModeIsActive()){

            Right1.setPower(.45);
            Left1.setPower(.45);
            frontLeft.setPower(-.45);
            frontRight.setPower(-.45);
            idle();

        }

        while (getRuntime() - Time > 15 && getRuntime() - Time < 15.5 && opModeIsActive()) {

            Left1.setPower(0);
            Right1.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
            idle();

        }

        while (getRuntime() - Time >= 15.5 && getRuntime() - Time <= 16.5 && opModeIsActive()) {

            Lift.setPower(0);

            idle();
        }

        while (getRuntime() - Time > 16.5 && getRuntime() - Time < 17 && opModeIsActive()) {
            Lift.setPower(0);
            idle();

        }

        while (getRuntime() - Time >= 17 && getRuntime() - Time <= 18 && opModeIsActive()) {

            BottomGrabber1.setPosition(.2);
            BottomGrabber2.setPosition(.2);

            idle();

        }

        while (getRuntime() - Time > 18 && getRuntime() - Time < 18.5 && opModeIsActive()){

            Left1.setPower(-.35);
            Right1.setPower(-.35);
            frontLeft.setPower(.35);
            frontRight.setPower(.35);
            idle();
        }

    }

}
