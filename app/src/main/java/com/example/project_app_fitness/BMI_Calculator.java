package com.example.project_app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BMI_Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        EditText editTextWeight  = findViewById(R.id.weight);
        EditText editTextHeight  = findViewById(R.id.height);
        Button button = findViewById(R.id.btnSummitBMI);
        TextView textView = findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100 ;
                float weight = Float.parseFloat(String.valueOf(editTextWeight.getText()));
                float bmi = weight / (height * height);
                textView.setText(String.valueOf(bmi));
            }
        });

    }
}