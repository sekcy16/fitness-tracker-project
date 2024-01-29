package com.example.project_app_fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.content.res.Resources;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
public class Exercises_list extends AppCompatActivity implements  recyclerviewinterface{

    ArrayList<exercisemodel> exercisemodel = new ArrayList<>();
    int[] exerciseimage = {  R.drawable.test1 ,R.drawable.test2, R.drawable.test3 ,R.drawable.test4, R.drawable.test5,R.drawable.test6,R.drawable.test7,R.drawable.test8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_list);

        RecyclerView recyclerView = findViewById(R.id.myrecyclerview);

        setupexercisemodel();

        e_recyclerviewadapter adapter = new e_recyclerviewadapter (this, exercisemodel, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_Ex);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_add) {
                startActivity(new Intent(getApplicationContext(), Add_exercises.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_Ex) {
                return true;
            } else if (itemId == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });
    }

    private void setupexercisemodel(){
        String[] exercisename = getResources().getStringArray(R.array.exercisename);
        String[] exercisedescription = getResources().getStringArray(R.array.description);

        for (int i = 0; i<exercisename.length; i++){
            exercisemodel.add(new exercisemodel(exercisename[i],
                    exerciseimage[i],exercisedescription[i]));
        }
    }

    @Override
    public void onitemclick(int position) {
        Intent intent = new Intent(Exercises_list.this, Exercises_data.class);

        intent.putExtra("NAME", exercisemodel.get(position).getExercisename());
        intent.putExtra("IMAGE", exercisemodel.get(position).getImage());
        intent.putExtra("DESCRIPTION", exercisemodel.get(position).getDescription());
        startActivity(intent);

    }
}