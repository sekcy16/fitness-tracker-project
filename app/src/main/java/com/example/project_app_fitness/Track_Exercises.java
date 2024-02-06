package com.example.project_app_fitness;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Track_Exercises extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;

    DatabaseHelper myDB;
    ArrayList<String> ex_id, ex_date, ex_title, ex_duration, ex_comment;
    CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_exercises);
        recyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.add_button);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
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

                return true;
            }
            return false;
        });



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Track_Exercises.this,AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new DatabaseHelper(Track_Exercises.this);
        ex_id = new ArrayList<>();
        ex_date = new ArrayList<>();
        ex_title = new ArrayList<>();
        ex_duration = new ArrayList<>();
        ex_comment = new ArrayList<>();

        DataInArrays();

        customAdapter = new CustomAdapter (Track_Exercises.this,this,ex_id,ex_date,ex_title,ex_duration
                ,ex_comment);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Track_Exercises.this));


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void DataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor == null) {
            Toast.makeText(this, "Error reading data", Toast.LENGTH_SHORT).show();
            return; // Exit the method if the cursor is null
        }

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                ex_id.add(cursor.getString(0));
                ex_date.add(cursor.getString(1));
                ex_title.add(cursor.getString(2));
                ex_duration.add(cursor.getString(3));
                ex_comment.add(cursor.getString(4));
            }
        }

        // Close the cursor after using it
        cursor.close();
    }

}