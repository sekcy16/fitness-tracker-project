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
