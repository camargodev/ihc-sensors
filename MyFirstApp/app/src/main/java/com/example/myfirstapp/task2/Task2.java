package com.example.myfirstapp.task2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstapp.R;

public class Task2 extends AppCompatActivity {

    private TextView result;
    private EditText text;
    private EditText operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_2);

        text = (EditText) findViewById(R.id.text);
    }

    public void next(View view) {

        String strText = text.getText().toString();

        Intent nextScreen = new Intent(this, Task2Display.class);
        nextScreen.putExtra("text", strText);

        finish();
        startActivity(nextScreen);
    }
}