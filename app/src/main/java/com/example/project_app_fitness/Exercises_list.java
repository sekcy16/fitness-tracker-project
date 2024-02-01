package com.example.project_app_fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Exercises_list extends AppCompatActivity {


    RecyclerView recyclerView;
    List<DataClassEx> dataList;

    MyAdapter adapter;
    DataClassEx androidData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_list);

        // แถบเมนูข้างล่าง
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_Ex);

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
                return true;
            } else if (itemId == R.id.bottom_profile) {
                startActivity(new Intent(getApplicationContext(), Profile.class)); // Change this line
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });


        // Search หา ท่า Exercises
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });


        // ท่าออกกำลังกาย
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Exercises_list.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();


        androidData = new DataClassEx("Push up", R.string.Pushup, "Bodyweight", R.drawable.pushup);
        dataList.add(androidData);
        androidData = new DataClassEx("Squat", R.string.Squat, "Bodyweight", R.drawable.squat);
        dataList.add(androidData);
        androidData = new DataClassEx("Pull up", R.string.Pullup, "Bodyweight", R.drawable.pullup);
        dataList.add(androidData);
        androidData = new DataClassEx("Dip", R.string.Dip, "Bodyweight", R.drawable.dip);
        dataList.add(androidData);
        androidData = new DataClassEx("Chin up", R.string.Chinup, "Bodyweight", R.drawable.chinup);
        dataList.add(androidData);
        androidData = new DataClassEx("Burpee", R.string.Burpee, "Bodyweight", R.drawable.burpee);
        dataList.add(androidData);
        androidData = new DataClassEx("Plank", R.string.Plank, "Bodyweight", R.drawable.plank);
        dataList.add(androidData);
        androidData = new DataClassEx("Lunges", R.string.Lunges, "Bodyweight", R.drawable.lunges);
        dataList.add(androidData);
        androidData = new DataClassEx("Crunches", R.string.Crunch, "Bodyweight", R.drawable.crunches);
        dataList.add(androidData);
        androidData = new DataClassEx("Knee push up", R.string.knee, "Bodyweight", R.drawable.knee);
        dataList.add(androidData);
        androidData = new DataClassEx("Wall Shoulder Press", R.string.wall, "Bodyweight", R.drawable.wall);
        dataList.add(androidData);
        androidData = new DataClassEx("Bench Press", R.string.bp, "Weight training", R.drawable.bp);
        dataList.add(androidData);
        androidData = new DataClassEx("Incline dumbbell press", R.string.incline, "Weight training", R.drawable.incline);
        dataList.add(androidData);
        androidData = new DataClassEx("Chest fly", R.string.chestfly, "Weight training", R.drawable.chestfly);
        dataList.add(androidData);
        androidData = new DataClassEx("Lat Pulldown", R.string.latpd, "Weight training", R.drawable.latpd);
        dataList.add(androidData);
        androidData = new DataClassEx("Seated Cable Row", R.string.seatedcbrow, "Weight training", R.drawable.seated);
        dataList.add(androidData);
        androidData = new DataClassEx("Leg Press", R.string.legpress, "Weight training", R.drawable.legpress);
        dataList.add(androidData);
        androidData = new DataClassEx("Romanian Deadlift", R.string.rdeadlift, "Weight training", R.drawable.rdl);
        dataList.add(androidData);
        androidData = new DataClassEx("Lateral raise", R.string.latraise, "Weight training", R.drawable.lateralraise);
        dataList.add(androidData);
        androidData = new DataClassEx("Dumbbell Hammer Curl", R.string.dhamcurl, "Weight training", R.drawable.hamcurl);
        dataList.add(androidData);
        androidData = new DataClassEx("Overhead Triceps Extension", R.string.oht, "Weight training", R.drawable.oht);
        dataList.add(androidData);
        androidData = new DataClassEx("Cable Crossover", R.string.ccrossover, "Weight training", R.drawable.ccross);
        dataList.add(androidData);
        androidData = new DataClassEx("Leg Extension", R.string.legex, "Weight training", R.drawable.legex);
        dataList.add(androidData);
        androidData = new DataClassEx("Calf Raise", R.string.calfraise, "Weight training", R.drawable.calfraise);
        dataList.add(androidData);
        androidData = new DataClassEx("Leg Curl", R.string.legcurl, "Weight training", R.drawable.legcurl);
        dataList.add(androidData);
        androidData = new DataClassEx("Cable Face Pulls", R.string.cbfacepull, "Weight training", R.drawable.facepull);
        dataList.add(androidData);
        androidData = new DataClassEx("Triceps Extension", R.string.tricepextension, "Weight training", R.drawable.tex);
        dataList.add(androidData);
        androidData = new DataClassEx("Biceps Curl", R.string.bicepcurl, "Weight training", R.drawable.bicepcurl);
        dataList.add(androidData);
        androidData = new DataClassEx("Barbell Squat", R.string.bbsquat, "Weight training", R.drawable.bbsq);
        dataList.add(androidData);
        androidData = new DataClassEx("Chest Press", R.string.chestpress, "Weight training", R.drawable.chestpress);
        dataList.add(androidData);
        androidData = new DataClassEx("Shoulder Press", R.string.shoulderpress, "Weight training", R.drawable.sdp);
        dataList.add(androidData);
        androidData = new DataClassEx("Reverse Fly", R.string.rvfly, "Weight training", R.drawable.revfly);
        dataList.add(androidData);
        androidData = new DataClassEx("Upright Row", R.string.uprightrow, "Weight training", R.drawable.uprightrow);
        dataList.add(androidData);
        androidData = new DataClassEx("Upright Row", R.string.uprightrow, "Weight training", R.drawable.uprightrow);
        dataList.add(androidData);
        androidData = new DataClassEx("Deadlift", R.string.deadlift, "Weight training", R.drawable.deadlift);
        dataList.add(androidData);
        androidData = new DataClassEx("Bent Over Row", R.string.bentoverrow, "Weight training", R.drawable.bentorow);
        dataList.add(androidData);
        androidData = new DataClassEx("Incline Dumbbell Curl", R.string.icdumbbellcurl, "Weight training", R.drawable.icd);
        dataList.add(androidData);
        androidData = new DataClassEx("Bulgarian split squat", R.string.bgsq, "Weight training", R.drawable.split);
        dataList.add(androidData);


        adapter = new MyAdapter(Exercises_list.this, dataList);
        recyclerView.setAdapter(adapter);
    }
    private void searchList(String text){
        List<DataClassEx> dataSearchList = new ArrayList<>();
        for (DataClassEx data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
    }
