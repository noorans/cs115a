package com.example.sugaranalysis;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.FeatureGroupInfo;
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
    static String DB_NAME = "AVG_BS_DB";
    static String TABLE_NAME = "AVG_BS_TABLE";
    static int VERSION = 1;

    static int FETCH_LIMIT = 876;



    public LogDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        ctx = context;
        VERSION = version;
        DB_NAME = name;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATE TABLE  TABLE_NAME (_id INTEGER PRIMARY KEY, NDB STRING, NAME STRING, MEASURE STRING, UNIT STRING, VALUE STRING);
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY, AVG_BS STRING, MOMENT STRING, DATE STRING, TIME STRING, HEIGHT STRING, WEIGHT STRING);");

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

    public void addEntry(String avg_bs, String moment, String date, String time, String height, String weight) throws SQLiteException {
        db = getWritableDatabase();
        long count = count();
        if (count < FETCH_LIMIT) {
            ContentValues cv = new ContentValues();
            cv.put("AVG_BS", avg_bs);
            cv.put("MOMENT", moment);
            cv.put("DATE", date);
            cv.put("TIME" , time);
            cv.put("HEIGHT", height);
            cv.put("WEIGHT", weight);
            db.insert(TABLE_NAME, null, cv);
        }
    }
    
    // This method will be used when we want to query anything in our table
    public Cursor logQuery( String filter) {
        SQLiteDatabase db = getReadableDatabase();


    // Define a projection that specifies which columns from the database
    // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                "AVG_BS",
                "MOMENT",
                "DATE",
                "TIME",
                "HEIGHT",
                "WEIGHT"
        };

        Cursor cursor = db.query(
                TABLE_NAME,
                projection,
                "DATE" + " LIKE ?",
                new String[]{"%" + filter + "%"},
                null, null, "AVG_BS", null);
        return cursor;
    }

    public Cursor logGet( String filter) {
        SQLiteDatabase db = getReadableDatabase();


// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                "AVG_BS",
                "MOMENT",
                "DATE",
                "TIME",
                "HEIGHT",
                "WEIGHT"
        };

        Cursor cursor = db.query(
                TABLE_NAME,
                projection,
                "DATE" + " LIKE ?",
                new String[]{"%" + filter + "%"},
                null, null, "_ID", null);
        return cursor;
    }

    //NOT FINALIZED
    //This method will be used to get all log objects from the table to display them
    public List<LogObject> fillList(List<LogObject> LogObject, String filter) {
        Cursor cursor;
        if(filter == ""){
            cursor = logGet(filter);
        }
        else {
            cursor = logQuery(filter);
        }

        if(cursor != null & cursor.getCount() > 0) {
            cursor.moveToFirst();
            int index;
            String avg_bs;
            String moment;
            String date;
            String time;
            String height;
            String weight;

            do{
                index = cursor.getColumnIndex("AVG_BS");
                avg_bs = cursor.getString(index);
                index = cursor.getColumnIndex("MOMENT");
                moment = cursor.getString(index);
                index = cursor.getColumnIndex("DATE");
                date = cursor.getString(index);
                index = cursor.getColumnIndex("TIME");
                time = cursor.getString(index);
                index = cursor.getColumnIndex("HEIGHT");
                height = cursor.getString(index);
                index = cursor.getColumnIndex("WEIGHT");
                weight = cursor.getString(index);
                LogObject fi = new LogObject(avg_bs, moment, date, time, height, weight);
                LogObject.add(fi);
            }while (cursor.moveToNext());
            cursor.close();
        }

        return LogObject;
    }

}