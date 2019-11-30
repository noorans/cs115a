package com.example.sugaranalysis;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageView progressButton, bmiButton, alertsButton, extrasButton,
            settingsButton, logsButton, homeButton;

    ImageButton beforeBreakfastButton, afterBreakfastButton, beforeLunchButton, afterLunchButton,
            beforeDinnerButton, afterDinnerButton, beforeWorkoutButton, afterWorkoutButton;

    TextView beforeBreakfast, afterBreakfast, beforeLunch, afterLunch, beforeDinner, afterDinner,
        beforeWorkout, afterWorkout;

    EditText beforeBreakfastBS, afterBreakfastBS, beforeLunchBS, afterLunchBS,
            beforeDinnerBS, afterDinnerBS, beforeWorkoutBS, afterWorkoutBS;

    String currentTime;
    String timeToCompare;
    boolean check;
    public static LogDB logDB;
    Calendar cal = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final String PREFS_NAME = "MyPrefsFile";

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            Log.d("Comments", "First time");

            // first time task
            Intent intent = new Intent(MainActivity.this, PersonalInformation.class);
            startActivity(intent);

            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false).commit();
        }

            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        timeToCompare = "00:00:00";

        // instanciating the database
        logDB = new LogDB(this,LogDB.DB_NAME, null, 1);


        // buttons/icons
        homeButton = findViewById(R.id.titleSugar);
        progressButton = findViewById(R.id.progress);
        bmiButton = findViewById(R.id.bmi);
        alertsButton = findViewById(R.id.alerts);
        extrasButton = findViewById(R.id.extra);
        settingsButton = findViewById(R.id.settings);
        logsButton = findViewById(R.id.logs);

        // TextViews for moment names
        beforeBreakfast = findViewById(R.id.beforeBreakfast);
        afterBreakfast = findViewById(R.id.afterBreakfast);
        beforeLunch = findViewById(R.id.beforeLunch);
        afterLunch = findViewById(R.id.afterLunch);
        beforeDinner = findViewById(R.id.beforeDinner);
        afterDinner = findViewById(R.id.afterDinner);
        beforeWorkout = findViewById(R.id.beforeWorkout);
        afterWorkout = findViewById(R.id.afterWorkout);

        // EditTexts for BS
        beforeBreakfastBS = findViewById(R.id.bbBS);
        afterBreakfastBS = findViewById(R.id.abBS);
        beforeLunchBS = findViewById(R.id.blBS);
        afterLunchBS = findViewById(R.id.alBS);
        beforeDinnerBS = findViewById(R.id.bdBS);
        afterDinnerBS = findViewById(R.id.adBS);
        beforeWorkoutBS = findViewById(R.id.bwBS);
        afterWorkoutBS = findViewById(R.id.awBS);

        // Buttons for BS
        beforeBreakfastButton = findViewById(R.id.bbButton);
        afterBreakfastButton = findViewById(R.id.abButton);
        beforeLunchButton = findViewById(R.id.blButton);
        afterLunchButton = findViewById(R.id.alButton);
        beforeDinnerButton = findViewById(R.id.bdButton);
        afterDinnerButton = findViewById(R.id.adButton);
        beforeWorkoutButton = findViewById(R.id.bwButton);
        afterWorkoutButton = findViewById(R.id.awButton);

        // buttons revert to empty
        // when time is 00:00:00 (12AM military time)
        check = currentTime.equals(timeToCompare);

        // start new activity to view settings activity
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // start new activity to view blood sugar input
        logsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogActivity.class);
                startActivity(intent);
            }
        });

        beforeBreakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beforeBreakfastButton.setBackgroundResource(R.drawable.filled);
                TextView bstext = findViewById(R.id.bbBS);
                String bs = bstext.getText().toString();
                String moment = beforeBreakfast.getText().toString();
                System.out.println(bs + " ," + moment);
                addToDataBase(bs, moment);
                Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_LONG).show();
                if(check) {
                    beforeBreakfastButton.setBackgroundResource(R.drawable.open);
                }
            }
        });

        afterBreakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afterBreakfastButton.setBackgroundResource(R.drawable.filled);
                TextView bstext = findViewById(R.id.abBS);
                String bs = bstext.getText().toString();
                String moment = afterBreakfast.getText().toString();
                addToDataBase(bs, moment);
                Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_LONG).show();
                if(check) {
                    beforeBreakfastButton.setBackgroundResource(R.drawable.open);
                }
            }
        });

        beforeLunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beforeLunchButton.setBackgroundResource(R.drawable.filled);
                TextView bstext = findViewById(R.id.blBS);
                String bs = bstext.getText().toString();
                String moment = beforeLunch.getText().toString();
                addToDataBase(bs, moment);
                Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_LONG).show();
                if(check) {
                    beforeBreakfastButton.setBackgroundResource(R.drawable.open);
                }
            }
        });

        afterLunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afterLunchButton.setBackgroundResource(R.drawable.filled);
                TextView bstext = findViewById(R.id.alBS);
                String bs = bstext.getText().toString();
                String moment = afterLunch.getText().toString();
                addToDataBase(bs, moment);
                Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_LONG).show();
                if(check) {
                    beforeBreakfastButton.setBackgroundResource(R.drawable.open);
                }
            }
        });

        beforeDinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beforeDinnerButton.setBackgroundResource(R.drawable.filled);
                TextView bstext = findViewById(R.id.bdBS);
                String bs = bstext.getText().toString();
                String moment = beforeDinner.getText().toString();
                addToDataBase(bs, moment);
                Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_LONG).show();
                if(check) {
                    beforeBreakfastButton.setBackgroundResource(R.drawable.open);
                }
            }
        });

        afterDinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afterDinnerButton.setBackgroundResource(R.drawable.filled);
                TextView bstext = findViewById(R.id.adBS);
                String bs = bstext.getText().toString();
                String moment = afterDinner.getText().toString();
                addToDataBase(bs, moment);
                Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_LONG).show();
                if(check) {
                    beforeBreakfastButton.setBackgroundResource(R.drawable.open);
                }
            }
        });

        beforeWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beforeWorkoutButton.setBackgroundResource(R.drawable.filled);
                TextView bstext = findViewById(R.id.bwBS);
                String bs = bstext.getText().toString();
                String moment = beforeWorkout.getText().toString();
                addToDataBase(bs, moment);
                Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_LONG).show();
                if(check) {
                    beforeBreakfastButton.setBackgroundResource(R.drawable.open);
                }
            }
        });

        afterWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afterWorkoutButton.setBackgroundResource(R.drawable.filled);
                TextView bstext = findViewById(R.id.awBS);
                String bs = bstext.getText().toString();
                String moment = afterWorkout.getText().toString();
                addToDataBase(bs, moment);
                Toast.makeText(MainActivity.this, "ADDED", Toast.LENGTH_LONG).show();
                if(check) {
                    beforeBreakfastButton.setBackgroundResource(R.drawable.open);
                }
            }
        });
    }

    // start new activity to view progress activity
    public void clickProgress(View v) {
        Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
        intent.setType("*/*");
        startActivity(intent);

    }

    // start new activity to view main activity
    public void clickHome(View v) {
        Intent intent = new Intent(MainActivity.this, PersonalInformation.class);
        intent.setType("*/*");
        startActivity(intent);

    }

    public void clickBMI(View v) {
        Intent intent = new Intent(MainActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);

    }

    public void clickAlerts(View v) {
        Intent intent = new Intent(MainActivity.this, AlertsActivity.class);
        intent.setType("*/*");
        startActivity(intent);
    }

    public void clickExtras(View v) {
        Intent intent = new Intent(MainActivity.this, ExtraActivity.class);
        intent.setType("*/*");
        startActivity(intent);
    }


    public void addToDataBase(String bs, String moment){
        SharedPreferences myPreferences = getSharedPreferences("com.example.sugaranalysis_preferences", 0);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("MMM/dd/yyyy");
        SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm:ss aa");

        String date;

        //String date = "Date: " + dateformat.format(c.getTime());
        String time = timeformat.format(c.getTime());
        String height = myPreferences.getString("userHeight","");
        String weight = myPreferences.getString("userWeight", "");
        //date = "11/21/2019";
        //System.out.println(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US));
        date = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);
        //date = String.valueOf(cal.get(Calendar.DAY_OF_WEEK));

        logDB.addEntry(bs,moment,date,time,height,weight);
    }
}
