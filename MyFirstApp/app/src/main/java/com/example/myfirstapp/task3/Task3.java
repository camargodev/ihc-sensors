package com.example.myfirstapp.task3;

import android.content.Context;
import android.content.Intent;
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
import com.example.myfirstapp.task6.Task6;

public class Task3 extends AppCompatActivity implements SensorEventListener {


    private SensorManager sensorManager;
    private Sensor accelerometer;

    private TextView xView, yView, zView;

    private static final int X = 0, Y = 1, Z = 2;

    private static final float TOO_MUCH_ACCELERATION = 5f;

    private float x, y, z;
    private boolean hasAcceleration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_3);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        xView = (TextView) findViewById(R.id.x);
        yView = (TextView) findViewById(R.id.y);
        zView = (TextView) findViewById(R.id.z);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float currentX = event.values[X];
        float currentY = event.values[Y];
        float currentZ = event.values[Z];

        xView.setText("X: " + Float.toString(currentX));
        yView.setText("Y: " + Float.toString(currentY));
        zView.setText("Z: " + Float.toString(currentZ));

        if (hasAcceleratedTooMuch(currentX, currentY, currentZ))
            nextScreen();
    }

    private boolean hasAcceleratedTooMuch(float currentX, float currentY, float currentZ) {
        if (!hasAcceleration) {
            x = currentX;
            y = currentY;
            z = currentZ;
            hasAcceleration = true;
            return false;
        }
        boolean hasAccelerated = false;
        if (Math.abs(currentX-x) > TOO_MUCH_ACCELERATION) hasAccelerated =  true;
        if (Math.abs(currentY-y) > TOO_MUCH_ACCELERATION) hasAccelerated =  true;
        if (Math.abs(currentZ-z) > TOO_MUCH_ACCELERATION) hasAccelerated =  true;
        x = currentX;
        y = currentY;
        z = currentZ;
        return hasAccelerated;
    }

    private void nextScreen() {
        Intent nextTask = new Intent(this, Task3Display.class);
        finish();
        startActivity(nextTask);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }

    private float format(float val) {
        return val;
    }


}