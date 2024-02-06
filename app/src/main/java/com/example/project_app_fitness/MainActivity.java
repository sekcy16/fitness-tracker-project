package com.example.project_app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    ImageView imageView_bmi , imageView_Exercises_List , imageView_Recommend_Ex , imageView_next_page ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView_bmi = findViewById(R.id.image_Bmi);
        imageView_Recommend_Ex =findViewById(R.id.imageRec);
        imageView_Exercises_List = findViewById(R.id.imageEX);
        imageView_next_page = findViewById(R.id.imagenextpage1);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_home) {

                return true;
            } else if (itemId == R.id.bottom_Rc) {
                startActivity(new Intent(getApplicationContext(), Rec_exercises.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_Ex) {
                startActivity(new Intent(getApplicationContext(), Exercises_list.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), Track_Exercises.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });


        imageView_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BMI_Calculator.class);
                startActivity(intent);
                finish();
            }
        });

        imageView_Exercises_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Exercises_list.class);
                startActivity(intent);
                finish();
            }
        });

        imageView_Recommend_Ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rec_exercises.class);
                startActivity(intent);
                finish();
            }
        });

        imageView_next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rec_exercises.class);
                startActivity(intent);
                finish();
            }
        });




    }
}