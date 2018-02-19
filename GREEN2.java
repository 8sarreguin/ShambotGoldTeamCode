package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Green on 10/16/2017.
 */
@TeleOp(name = "turtletribe2", group = "19buick")
public class GREEN2 extends OpMode {

    Servo Mac;
    Servo Cheese;
    Servo Jalapeno; // turny bitch
    Servo Jeep; // turny bitch

    boolean turtle = false;

    public void init() {

        Mac = hardwareMap.servo.get("Mac");
        Cheese = hardwareMap.servo.get("Cheese");
        Jalapeno = hardwareMap.servo.get("Jalapeno");
        Jeep = hardwareMap.servo.get("Jeep");

        Mac.setDirection(Servo.Direction.REVERSE);
        Jeep.setDirection(Servo.Direction.REVERSE);

        Mac.setPosition(0);
        Cheese.setPosition(0);
        Jalapeno.setPosition(.5);
        Jeep.setPosition(.5);

    }

    @Override
    public void loop() {

        if (gamepad2.a){
            Mac.setPosition(1);
            Cheese.setPosition(1);
        }
        else{
            Mac.setPosition(0);
            Mac.setPosition(0);
        }

        if (gamepad2.y && !turtle) {
            turtle = true;
            if (Jalapeno.getPosition() == .5 && Jeep.getPosition() == .5){
                Jalapeno.setPosition(1);
                Jeep.setPosition(1);
            }
            else if (Jalapeno.getPosition() == 1 && Jeep.getPosition() == 1){
                Jalapeno.setPosition(.5);
                Jeep.setPosition(.5);
            }
        }
        else if (!gamepad2.y){
            turtle = false;
        }

    }
}
