package com.example.myfirstapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void task1(View view) {
        Intent nextTask = new Intent(this, Task1.class);
        finish();
        startActivity(nextTask);
    }

    public void task2(View view) { }

    public void task3(View view) { }

    public void task4(View view) { }

    public void task5(View view) { }

    public void task6(View view) { }
}