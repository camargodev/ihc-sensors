package com.example.myfirstapp.task2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.R;

public class Task2Display extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_2_display);

        text = (TextView) findViewById(R.id.text);
        display();
    }

    private void display() {
        Intent lastScreen = getIntent();
        String strtText = lastScreen.getStringExtra("text");
        text.setText(strtText);
    }
}