package com.example.myfirstapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myfirstapp.task1.Task1;
import com.example.myfirstapp.task2.Task2;
import com.example.myfirstapp.task3.Task3;
import com.example.myfirstapp.task4.Task4;
import com.example.myfirstapp.task5.Task5;
import com.example.myfirstapp.task6.Task6;

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

    public void task2(View view) {
        Intent nextTask = new Intent(this, Task2.class);
        finish();
        startActivity(nextTask);}

    public void task3(View view) {
        Intent nextTask = new Intent(this, Task3.class);
        finish();
        startActivity(nextTask);}

    public void task4(View view) {
        Intent nextTask = new Intent(this, Task4.class);
        finish();
        startActivity(nextTask);}

    public void task5(View view) {
        Intent nextTask = new Intent(this, Task5.class);
        finish();
        startActivity(nextTask);}

    public void task6(View view) {
        Intent nextTask = new Intent(this, Task6.class);
        finish();
        startActivity(nextTask);}
}