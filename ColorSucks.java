package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by Green on 1/27/2018.
 */

@Autonomous(name="ColorSucks", group="Auton")
public class ColorSucks extends OpMode
{
    ColorSensor ThirdEye;

    public void init()
    {
        ThirdEye = hardwareMap.colorSensor.get("ThirdEye");
        ThirdEye.enableLed(false);
    }


    public void loop()
    {
        telemetry.addData("Red", ThirdEye.red());
        telemetry.addData("Green", ThirdEye.green());
        telemetry.addData("Blue", ThirdEye.blue());
        telemetry.update();
    }



}
