package com.example.project_app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Exercises_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_data);

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");

        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView nameTextView = findViewById(R.id.textView2);
        TextView descriptionTextView = findViewById(R.id.textView3);

        ImageView ex_image = findViewById(R.id.imageView2);

        nameTextView.setText(name);
        descriptionTextView.setText(description);
        ex_image.setImageResource(image);

    }
}