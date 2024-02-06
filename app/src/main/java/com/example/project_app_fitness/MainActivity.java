package com.example.project_app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements ExerciseClickListener {

    ImageView imageView_bmi, imageView_Exercises_List, imageView_Recommend_Ex, imageView_next_page;

    private View.OnClickListener exerciseListClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Exercises_list.class);
            startActivity(intent);
            finish();

            // Call the polymorphic method
            if (Exercises_list.class.isInstance(MainActivity.this)) {
                ((ExerciseClickListener) MainActivity.this).showText();
            }
        }
    };

    private View.OnClickListener recommendExClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), Rec_exercises.class);
            startActivity(intent);
            finish();

            // Call the polymorphic method
            if (Rec_exercises.class.isInstance(MainActivity.this)) {
                ((ExerciseClickListener) MainActivity.this).showText();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_bmi = findViewById(R.id.image_Bmi);
        imageView_Recommend_Ex = findViewById(R.id.imageRec);
        imageView_Exercises_List = findViewById(R.id.imageEX);
        imageView_next_page = findViewById(R.id.imagenextpage1);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_home) {
                // Do nothing or handle accordingly
            } else if (itemId == R.id.bottom_Rc) {
                startActivity(new Intent(getApplicationContext(), Rec_exercises.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            } else if (itemId == R.id.bottom_Ex) {
                // Handle exercise list click
                exerciseListClickListener.onClick(imageView_Exercises_List);
            } else if (itemId == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), Track_Exercises.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
            return true;
        });

        imageView_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BMI_Calculator.class);
                startActivity(intent);
                finish();
            }
        });

        imageView_Exercises_List.setOnClickListener(exerciseListClickListener);

        imageView_Recommend_Ex.setOnClickListener(recommendExClickListener);

        imageView_next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Rec_exercises.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });
    }

    @Override
    public void showText() {
        // Handle showing text for polymorphism
        Toast.makeText(this, "Polymorphism: Clicked on Exercise List or Recommendation", Toast.LENGTH_SHORT).show();
    }
}