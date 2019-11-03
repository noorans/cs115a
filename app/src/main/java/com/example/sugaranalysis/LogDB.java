package com.example.sugaranalysis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.sugaranalysis.Objects.LogObject;

import java.util.List;

public class LogDB extends SQLiteOpenHelper {

    Context ctx;
    SQLiteDatabase db;
    //private static String DB_PATH = "/data/data/com.example.surgaranalysis/databases/";
    static String DB_NAME = "AVG_BMI_DB";
    static String TABLE_NAME = "AVG_BMI_TABLE";
    static int VERSION = 1;
    //APICalls please = new APICalls();



    public LogDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        ctx = context;
        VERSION = version;
        DB_NAME = name;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATE TABLE  TABLE_NAME (_id INTEGER PRIMARY KEY, NDB STRING, NAME STRING, MEASURE STRING, UNIT STRING, VALUE STRING);
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY, AVG_BMI STRING, TIME STRING, HEIGHT STRING, WEIGHT STRING);");

    }
    public int count() {
        db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * FROM " + TABLE_NAME + ";", null);
        return c.getCount();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(VERSION == oldVersion){
            VERSION = newVersion;
            db = getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
            onCreate(db);
        }
    }

    public void addEntry(String avg_bmi, String time, String height, String weight) throws SQLiteException {
        db = getWritableDatabase();
        long count = count();
        if (count < 876) {
            ContentValues cv = new ContentValues();
            cv.put("AVG_BMI", avg_bmi);
            cv.put("TIME" , time);
            cv.put("HEIGHT", height);
            cv.put("WEIGHT", weight);
            db.insert(TABLE_NAME, null, cv);
        }
    }


    //This method will be used when we want to query anything in our table
    public Cursor logQuery( String filter) {
        SQLiteDatabase db = getReadableDatabase();


// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                "AVG_BMI"
        };

        Cursor cursor = db.query(
                TABLE_NAME,
                projection,
                "AVG_BMI" + " LIKE ?",
                new String[]{"%" + filter + "%"},
                null, null, "AVG_BMI", null);
        return cursor;
    }

    //NOT FINALIZED
    //This method will be used to get all log objects from the table to display them
    public List<LogObject> fillList(List<LogObject> foodItems, String filter) {
        Cursor cursor = logQuery(filter);

        if(cursor != null & cursor.getCount() > 0) {
            cursor.moveToFirst();
            int index;
            String avg_bmi;
            String time;
            String height;
            String weight;

            do{
                index = cursor.getColumnIndex("AVG_BMI");
                avg_bmi = cursor.getString(index);
                index = cursor.getColumnIndex("TIME");
                time = cursor.getString(index);
                index = cursor.getColumnIndex("HEIGHT");
                height = cursor.getString(index);
                index = cursor.getColumnIndex("WEIGHT");
                weight = cursor.getString(index);
                LogObject fi = new LogObject(avg_bmi, time, height, weight);
                foodItems.add(fi);
            }while (cursor.moveToNext());
            cursor.close();
        }

        return foodItems;
    }

}