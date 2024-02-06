package com.example.project_app_fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class Rec_exercises extends AppCompatActivity implements ExerciseClickListener{

    RecyclerView recyclerView;
    List<DataClassEx> dataList;
    MyAdapter adapter;
    DataClassEx androidData;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_exercises);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_Rc);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.bottom_Rc) {
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

        //code recommend exercise
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchrc);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Rec_exercises.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();


        androidData = new DataClassEx("home workout", R.string.beginnerhome, "Beginner", R.drawable.homeworkout);
        dataList.add(androidData);
        androidData = new DataClassEx("3 days gym workout", R.string.threedaygym, "intermediate", R.drawable.threedaygymworkout);
        dataList.add(androidData);
        androidData = new DataClassEx("4 days gym workout", R.string.fourday, "advance", R.drawable.fourdaygymworkout);
        dataList.add(androidData);
        androidData = new DataClassEx("5 days gym workout", R.string.fivedaygym, "advance", R.drawable.fivedaygymworkout);
        dataList.add(androidData);
        androidData = new DataClassEx("6 days gym workout", R.string.sixdaygym, "advance", R.drawable.sixdaygymworkout);
        dataList.add(androidData);
        adapter = new MyAdapter(Rec_exercises.this, dataList, Rec_exercises.this);
        recyclerView.setAdapter(adapter);
    }

    //Polymorphism interface ExerciseClickListener
    @Override
    public void showText() {
        // Implement the behavior you want when the user clicks on Exercise Recommendation
        Toast.makeText(this, "Exercise Recommendation Clicked!", Toast.LENGTH_SHORT).show();
    }

    // Data Searching
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

