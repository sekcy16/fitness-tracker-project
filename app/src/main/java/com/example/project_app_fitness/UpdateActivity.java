package com.example.project_app_fitness;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText editdate,edittitle,editduration,editcomment;
    Button update_button,delete_button;

    String id,date,title,duration,comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editdate = findViewById(R.id.editdate);
        edittitle = findViewById(R.id.edittitle);
        editduration = findViewById(R.id.editduration);
        editcomment = findViewById(R.id.editcomment);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);



        //เรียกใช้
        getAndSetIntentData();

        ActionBar ab =  getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper = new DatabaseHelper(UpdateActivity.this);
                date = editdate.getText().toString().trim();
                title = edittitle.getText().toString().trim();
                duration = editduration.getText().toString().trim();
                comment = editcomment.getText().toString().trim();

                databaseHelper.updateData(id,date,title,duration,comment);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confrimDialog();
            }
        });


    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("date") &&
                getIntent().hasExtra("title") && getIntent().hasExtra("duration") &&
                getIntent().hasExtra("comment")){
            //รับdataจากIntent
            id = getIntent().getStringExtra("id");
            date = getIntent().getStringExtra("date");
            title = getIntent().getStringExtra("title");
            duration = getIntent().getStringExtra("duration");
            comment = getIntent().getStringExtra("comment");

            //setting intent data
            editdate.setText(date);
            edittitle.setText(title);
            editduration.setText(duration);
            editcomment.setText(comment);


        }else{
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
    }

    void confrimDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Are you sure you want to delete " + title + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DatabaseHelper databaseHelper = new DatabaseHelper(UpdateActivity.this);
                databaseHelper.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}