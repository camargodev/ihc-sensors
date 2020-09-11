package com.example.myfirstapp.task5;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.R;

public class Task5 extends AppCompatActivity implements SensorEventListener {

    private static final int X = 0, Y = 1, Z = 2;
    private TextView brightnessView;
    private TextView gyroscopeView;
    private SensorManager sensorManager;
    private Sensor brightness;
    private Sensor gyroscope;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_5);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        brightness = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, brightness, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);

        brightnessView = (TextView) findViewById(R.id.brightness);
        gyroscopeView = (TextView) findViewById(R.id.gyroscope);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int eventType = event.sensor.getType();
        switch (eventType) {
            case Sensor.TYPE_LIGHT:
                float brightnessValue = event.values[0];
                brightnessView.setText("Room rightness is " + brightnessValue);
                break;
            case Sensor.TYPE_GYROSCOPE:
                float gyroscopeX = event.values[X];
                float gyroscopeY = event.values[Y];
                float gyroscopeZ = event.values[Z];
                String display = "X rotation = " + gyroscopeX;
                display += "\nY rotation = " + gyroscopeY;
                display += "\nZ rotation = " + gyroscopeZ;
                gyroscopeView.setText(display);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}