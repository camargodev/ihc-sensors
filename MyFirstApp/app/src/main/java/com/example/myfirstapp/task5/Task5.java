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

    private TextView brightnessView;
    private TextView proximityView;
    private SensorManager sensorManager;
    private Sensor brightness;
    private Sensor proximity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_5);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        brightness = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this, brightness, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL);

        brightnessView = (TextView) findViewById(R.id.brightness);
        proximityView = (TextView) findViewById(R.id.proximity);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int eventType = event.sensor.getType();
        switch (eventType) {
            case Sensor.TYPE_LIGHT:
                float brightnessValue = event.values[0];
                brightnessView.setText("Room rightness is " + brightnessValue);
                break;
            case Sensor.TYPE_PROXIMITY:
                float proximityValue = event.values[0];
                proximityView.setText("Proximity to phone is " + proximityValue);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}