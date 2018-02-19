/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;


@Autonomous(name="Vuforia Red", group ="Vuforia")
public class ConceptVuMarkIdentification extends LinearOpMode {

    DcMotor Right1;
    DcMotor Left1;
    DcMotor Center;
    DcMotor Lift;
    Servo BottomGrabber1;
    Servo BottomGrabber2;
    Servo BottomLiftUp1;
    Servo BottomLiftUp2;
    ColorSensor ThirdEye;
    Servo Jewel1;
    Servo Jewel2;
    Servo TopLiftUp1;
    Servo TopLiftUp2;
    Servo TopGrabber1;
    Servo TopGrabber2;
    DcMotor frontLeft;
    DcMotor frontRight;


    public static final String TAG = "Vuforia VuMark Sample";

    OpenGLMatrix lastLocation = null;
    VuforiaLocalizer vuforia;

    @Override public void runOpMode() {

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

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "AbKdR0T/////AAAAmb3s0bzph0ZMnemDqc8iEYiEvUs4Qf7Ob8YGZMLpwmolzTU9lGG4jWDpTa6YKP556PTHysbUsWD7y4Ju6Wev0hhjY+OiYqasxsU7S3NzZRAqdWH/ugJrbT5p+GWtGs2VKgiyh2YeYbMaN+LhbZb0NEsVGleJmb+7NG/aWqXmcaI4XUvU3zT8FkM0HMrPhDZwGpvMwlYzbboKGf2fTrYd8uvr22S9yHnXV2jcvh+uagHaLZCyfFMnMzoIxpDmz9qmEH75F69hnEVnCsItf2vuaAD4arDGrWJ5F/mgk2/FB+yB5xWQidowy/Sc54EhYKPCOqxNGUEKFBlDwY3On1I5pGrKn1XoNDCk+oOeUVoENG5i";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        telemetry.addData(">", "Press Play to start");
        telemetry.update();
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

        sleep(2000);

        double Time = getRuntime();
        telemetry.addData("Step", 0);
        telemetry.update();

        while (getRuntime() - Time <= 1 && opModeIsActive()){

            Jewel1.setPosition(.05);
            telemetry.addData("Step", 1);
            telemetry.update();
            idle();
        }

        while (getRuntime() - Time > 1 && getRuntime() - Time < 7 && opModeIsActive()) {
            if (ThirdEye.red() - ThirdEye.blue   () > 60) {

                Jewel2.setPosition(.25);

            }
            else if (ThirdEye.blue () - ThirdEye.red() > 30) {
                Jewel2.setPosition(.75);
            }
            telemetry.addData("Step",2);
            telemetry.update();
            idle();
        }

        while (getRuntime() - Time >= 7 && getRuntime() - Time < 8 && opModeIsActive()){

            Jewel1.setPosition(.9);
            Jewel2.setPosition(.5);
            telemetry.addData("Step", 3);
            telemetry.update();
            idle();
        }

        relicTrackables.activate();

        while (opModeIsActive()) {

            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
                telemetry.addData("VuMark", "%s visible", vuMark);

                if (vuMark == RelicRecoveryVuMark.LEFT){
                    while(getRuntime() - Time >= 8 && getRuntime() - Time < 11 && opModeIsActive()) {

                        BottomGrabber1.setPosition(.5);
                        BottomGrabber2.setPosition(.5);
                        BottomLiftUp1.setPosition(.5);
                        BottomLiftUp2.setPosition(.5);
                        idle();

                    }

                    while (getRuntime() - Time >= 11 && getRuntime() - Time <= 12.5 && opModeIsActive()){

                        BottomLiftUp1.setPosition(1);
                        BottomLiftUp2.setPosition(1);
                        idle();

                    }

                    while(getRuntime() - Time > 12.5 && getRuntime() - Time <= 14 && opModeIsActive()) {

                        BottomGrabber1.setPosition(1);
                        BottomGrabber2.setPosition(1);
                        Left1.setPower(.4);
                        Right1.setPower(.4);
                        frontLeft.setPower(-.6);
                        frontRight.setPower(-.6);
                        idle();

                    }

                    while (getRuntime() - Time > 14 && getRuntime() - Time <= 15.51 && opModeIsActive()) {

                        Left1.setPower(0);
                        Right1.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        idle();

                    }


                    while (getRuntime() - Time > 15.51 && getRuntime() - Time <= 16.5 && opModeIsActive()){
                        Left1.setPower(-.255);
                        Right1.setPower(.255);
                        frontLeft.setPower(.255);
                        frontRight.setPower(-.255);
                        idle();

                    }

                    while (getRuntime() - Time > 16.5 && getRuntime() - Time < 17 && opModeIsActive()) {

                        Left1.setPower(0);
                        Right1.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        idle();
                    }

                    while (getRuntime() - Time >= 17 && getRuntime() - Time <= 18 && opModeIsActive()){

                        Right1.setPower(.4);
                        Left1.setPower(.4);
                        frontLeft.setPower(-.4);
                        frontRight.setPower(-.4);
                        idle();

                    }

                    while (getRuntime() - Time > 18 && getRuntime() - Time < 19.5 && opModeIsActive()) {

                        Left1.setPower(0);
                        Right1.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        idle();

                    }

                    while (getRuntime() - Time >= 19.5 && getRuntime() - Time <= 20.5 && opModeIsActive()) {

                        Lift.setPower(0);

                        idle();
                    }

                    while (getRuntime() - Time > 20.5 && getRuntime() - Time < 22 && opModeIsActive()) {
                        Lift.setPower(0);
                        idle();

                    }

                    while (getRuntime() - Time >= 22 && getRuntime() - Time <= 24 && opModeIsActive()) {

                        BottomGrabber1.setPosition(0);
                        BottomGrabber2.setPosition(0);

                        idle();

                    }

                    while (getRuntime() - Time > 24 && getRuntime() - Time < 25.5 && opModeIsActive()){

                        Left1.setPower(-.15);
                        Right1.setPower(-.15);
                        frontLeft.setPower(.15);
                        frontRight.setPower(.15);
                        idle();
                    }

                }

                if (vuMark == RelicRecoveryVuMark.CENTER){
                    while(getRuntime() - Time >= 8 && getRuntime() - Time < 10 && opModeIsActive()) {

                        BottomGrabber1.setPosition(.5);
                        BottomGrabber2.setPosition(.5);
                        BottomLiftUp2.setPosition(.5);
                        BottomLiftUp1.setPosition(.5);
                        idle();

                    }

                    while (getRuntime() - Time >= 10 && getRuntime() - Time <= 10.5 && opModeIsActive()){

                        BottomLiftUp1.setPosition(1);
                        BottomLiftUp2.setPosition(1);
                        idle();

                    }

                    while(getRuntime() - Time > 10.5 && getRuntime() - Time <= 11.5 && opModeIsActive()) {

                        BottomGrabber1.setPosition(1);
                        BottomGrabber2.setPosition(1);
                        Left1.setPower(.35);
                        Right1.setPower(.35);
                        frontLeft.setPower(-.35);
                        frontRight.setPower(-.35);

                        idle();

                    }

                    while (getRuntime() - Time > 11.5 && getRuntime() - Time <= 11.51 && opModeIsActive()) {

                        Left1.setPower(0);
                        Right1.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        idle();

                    }


                    while (getRuntime() - Time > 11.51 && getRuntime() - Time <= 12.5 && opModeIsActive()){
                        Left1.setPower(.5);
                        Right1.setPower(-.5);
                        frontLeft.setPower(-.5);
                        frontRight.setPower(.5);

                        idle();

                    }

                    while (getRuntime() - Time > 12.5 && getRuntime() - Time < 13 && opModeIsActive()) {

                        Left1.setPower(0);
                        Right1.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        idle();
                    }

                    while (getRuntime() - Time >= 13 && getRuntime() - Time <= 14 && opModeIsActive()){

                        Right1.setPower(.45);
                        Left1.setPower(.45);
                        frontLeft.setPower(-.45);
                        frontRight.setPower(-.45);
                        idle();

                    }

                    while (getRuntime() - Time > 14 && getRuntime() - Time < 14.5 && opModeIsActive()) {

                        Left1.setPower(0);
                        Right1.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        idle();

                    }

                    while (getRuntime() - Time >= 14.5 && getRuntime() - Time <= 15.5 && opModeIsActive()) {

                        Lift.setPower(0);

                        idle();
                    }

                    while (getRuntime() - Time > 15.5 && getRuntime() - Time < 16 && opModeIsActive()) {
                        Lift.setPower(0);
                        idle();

                    }

                    while (getRuntime() - Time >= 16 && getRuntime() - Time <= 17 && opModeIsActive()) {

                        BottomGrabber1.setPosition(.2);
                        BottomGrabber2.setPosition(.2);

                        idle();

                    }

                    while (getRuntime() - Time > 17 && getRuntime() - Time < 17.5 && opModeIsActive()){

                        Left1.setPower(-.35);
                        Right1.setPower(-.35);
                        frontLeft.setPower(.35);
                        frontRight.setPower(.35);
                        idle();
                    }


                }
                if (vuMark == RelicRecoveryVuMark.RIGHT){

                    while(getRuntime() - Time >= 9 && getRuntime() - Time < 10 && opModeIsActive()) {

                        BottomGrabber1.setPosition(.5);
                        BottomGrabber2.setPosition(.5);
                        BottomLiftUp2.setPosition(.5);
                        BottomLiftUp1.setPosition(.5);
                        idle();

                    }

                    while (getRuntime() - Time >= 10 && getRuntime() - Time <= 10.5 && opModeIsActive()){

                        BottomLiftUp1.setPosition(1);
                        BottomLiftUp2.setPosition(1);
                        idle();

                    }

                    while(getRuntime() - Time > 10.5 && getRuntime() - Time <= 11.5 && opModeIsActive()) {

                        BottomGrabber1.setPosition(1);
                        BottomGrabber2.setPosition(1);
                        Left1.setPower(.35);
                        Right1.setPower(.35);
                        frontLeft.setPower(-.35);
                        frontRight.setPower(-.35);

                        idle();

                    }

                    while (getRuntime() - Time > 11.5 && getRuntime() - Time <= 11.51 && opModeIsActive()) {

                        Left1.setPower(0);
                        Right1.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        idle();

                    }


                    while (getRuntime() - Time > 11.51 && getRuntime() - Time <= 12.5 && opModeIsActive()){
                        Left1.setPower(.5);
                        Right1.setPower(-.5);
                        frontLeft.setPower(-.5);
                        frontRight.setPower(.5);

                        idle();

                    }

                    while (getRuntime() - Time > 12.5 && getRuntime() - Time < 13 && opModeIsActive()) {

                        Left1.setPower(0);
                        Right1.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        idle();
                    }

                    while (getRuntime() - Time >= 13 && getRuntime() - Time <= 14 && opModeIsActive()){

                        Right1.setPower(.45);
                        Left1.setPower(.45);
                        frontLeft.setPower(-.45);
                        frontRight.setPower(-.45);
                        idle();

                    }

                    while (getRuntime() - Time > 14 && getRuntime() - Time < 14.5 && opModeIsActive()) {

                        Left1.setPower(0);
                        Right1.setPower(0);
                        frontLeft.setPower(0);
                        frontRight.setPower(0);
                        idle();

                    }

                    while (getRuntime() - Time >= 14.5 && getRuntime() - Time <= 15.5 && opModeIsActive()) {

                        Lift.setPower(0);

                        idle();
                    }

                    while (getRuntime() - Time > 15.5 && getRuntime() - Time < 16 && opModeIsActive()) {
                        Lift.setPower(0);
                        idle();

                    }

                    while (getRuntime() - Time >= 16 && getRuntime() - Time <= 17 && opModeIsActive()) {

                        BottomGrabber1.setPosition(.2);
                        BottomGrabber2.setPosition(.2);

                        idle();

                    }

                    while (getRuntime() - Time > 17 && getRuntime() - Time < 17.5 && opModeIsActive()){

                        Left1.setPower(-.35);
                        Right1.setPower(-.35);
                        frontLeft.setPower(.35);
                        frontRight.setPower(.35);
                        idle();
                    }
                }
            }


            else {
                telemetry.addData("VuMark", "not visible");
            }

            telemetry.update();
        }
    }
}
