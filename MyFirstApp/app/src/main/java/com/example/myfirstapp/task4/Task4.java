package com.example.myfirstapp.task4;

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

public class Task4 extends AppCompatActivity implements SensorEventListener {

    private TextView brightnessView;
    private SensorManager sensorManager;
    private Sensor brightness;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_4);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        brightness = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, brightness, SensorManager.SENSOR_DELAY_NORMAL);

        brightnessView = (TextView) findViewById(R.id.brightness);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float brightnessValue = event.values[0];
        brightnessView.setText("Room rightness is " + brightnessValue);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}