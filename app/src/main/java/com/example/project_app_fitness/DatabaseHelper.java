package com.example.project_app_fitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME1 = "ExerciseTracking.db";
    private static final int DATABASE_VERSION1 = 1;
    private static final String TABLE_NAME1 = "Tracking_list1";
    private static final String COLUMN_ID1 = "_id1";
    private static final String COLUMN_DATE1 = "date1";

    private static final String COLUMN_TITLE1 = "exercise_name1";
    private static final String COLUMN_duration1= "exercise_duration1";
    private static final String COLUMN_comment1 = "exercise_comment1";

    DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME1, null, DATABASE_VERSION1);
        this.context= context;
        SQLiteDatabase db = this.getWritableDatabase(); // Ensure the database is created on instantiation
        onCreate(db);  // Ensure onCreate is called to create the table if it doesn't exist
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + " (" +
                COLUMN_ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DATE1 + " TEXT, " +
                COLUMN_TITLE1 + " TEXT, " +
                COLUMN_duration1 + " TEXT, " +
                COLUMN_comment1 + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME1);
        onCreate(db);
    }
    void addTrack(String date, String title, String duration, String comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DATE1, date);
        cv.put(COLUMN_TITLE1, title);
        cv.put(COLUMN_duration1, duration);
        cv.put(COLUMN_comment1, comment);

        long result = db.insert(TABLE_NAME1, null,cv);
        if(result == -1 ){
            Toast.makeText(context, "Failed to add track: " + result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!!", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id,String date, String title, String duration, String comment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_DATE1, date);
        cv.put(COLUMN_TITLE1, title);
        cv.put(COLUMN_duration1, duration);
        cv.put(COLUMN_comment1, comment);

        long result = db.update(TABLE_NAME1, cv, "_id1=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Update: " + result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully!!", Toast.LENGTH_SHORT).show();
        }


    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME1,"_id1=?", new String[]{row_id});
        if(result == -1 ){
            Toast.makeText(context, "Failed to Delete: " + result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Deleted Successfully!!", Toast.LENGTH_SHORT).show();
        }
    }
}