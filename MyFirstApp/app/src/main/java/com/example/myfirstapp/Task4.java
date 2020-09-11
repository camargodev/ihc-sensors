package com.example.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Task4 extends AppCompatActivity {

    private TextView result;
    private EditText operand1;
    private EditText operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_4);

        result = (TextView) findViewById(R.id.result);
        operand1 = (EditText) findViewById(R.id.operand1);
        operand2 = (EditText) findViewById(R.id.operand2);
    }

    public void sumValues(View view) {
        try {
            Integer op1 = Integer.parseInt(operand1.getText().toString());
            Integer op2 = Integer.parseInt(operand2.getText().toString());
            Integer res = op1 + op2;
            result.setText(res.toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
        }
    }
}