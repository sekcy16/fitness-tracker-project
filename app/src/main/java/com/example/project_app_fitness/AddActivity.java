package com.example.project_app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText editTextText01, editTextText0 ,editTextText2,editTextText1;
    Button addbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editTextText01 = findViewById(R.id.editTextdate);
        editTextText0 = findViewById(R.id.editTextText0);
        editTextText1 = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        addbutton = findViewById(R.id.add_button);


        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(AddActivity.this);
                databaseHelper.addTrack(
                        editTextText01.getText().toString().trim(),
                        editTextText0.getText().toString().trim(),
                        editTextText1.getText().toString().trim(),
                        editTextText2.getText().toString().trim()
                );
            }
        });
    }
}