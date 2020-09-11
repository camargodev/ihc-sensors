package com.example.myfirstapp.task6;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.myfirstapp.MainActivity;
import com.example.myfirstapp.R;

public class Task6 extends AppCompatActivity {

    private TextView result;
    private EditText operand1;
    private EditText operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_6);

        Button getGPSBtn = (Button) findViewById(R.id.gpstatus);
        ActivityCompat.requestPermissions(Task6.this, new
                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        getGPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GpsTracker gps = new GpsTracker(getApplicationContext());
                Location location = gps.getLocation();
                if(location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    Toast.makeText(getApplicationContext(),
                            "LAT: " + latitude + "\nLONG: " + longitude, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}