package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import com.allyants.notifyme.NotifyMe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlertsActivity extends AppCompatActivity  {
    ImageView progressButton, bmiButton, alertsButton, extrasButton,
            settingsButton, logsButton, homeButton;
    EditText label, time;
    Button notifyButton;
    String labels, times;
    Calendar now = Calendar.getInstance();



    private ListView tInput;

    private AdapterTime adapterTime;
    public ArrayList<TimeItemCmp> timeItemCmpArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        homeButton = findViewById(R.id.titleSugar);
        progressButton = findViewById(R.id.progress);
        bmiButton = findViewById(R.id.bmi);
        alertsButton = findViewById(R.id.alerts);
        extrasButton = findViewById(R.id.extra);
        settingsButton = findViewById(R.id.settings);
        logsButton = findViewById(R.id.logs);

        tInput = (ListView) findViewById(R.id.timeList);

        timeItemCmpArrayList = timeListPopulate();
        adapterTime = new AdapterTime(AlertsActivity.this, timeItemCmpArrayList);
        tInput.setAdapter(adapterTime);

        label = findViewById(R.id.label);
        time = findViewById(R.id.time);
        notifyButton = findViewById(R.id.notifyButton);


        // start new activity to view settings activity
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlertsActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // start new activity to view blood sugar input
        logsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlertsActivity.this, LogActivity.class);
                startActivity(intent);
            }
        });

        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labels = label.getText().toString();
                times = time.getText().toString();
                parseForTime(labels, times);

            }
        });
    }

    public void parseForTime(String labels, String times) {
        /*SimpleDateFormat time = new SimpleDateFormat("hh:mm aa");
        //String [] parts = times.split(" ");
        //String am_or_pm = parts[1];
        Calendar now = Calendar.getInstance();
        Date date = null;

        try {
           date = time.parse(times);


        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        int hours = date.getHours();
        int mins =  date.getMinutes();
        //now.set(Calendar.HOUR, Calendar.HOUR);
        //now.set(Calendar.MINUTE, Calendar.MINUTE);
        /*if(am_or_pm.equals("AM")) {
            now.set(Calendar.AM_PM, 0);
        }
        else if (am_or_pm.equals("PM")){
            now.set(Calendar.AM_PM, 1);
        }*/
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("test","I am a String");
        NotifyMe notifyMe = new NotifyMe.Builder(getApplicationContext())
                .title("Time To Log Blood Sugar")
                .color(255,0,0,255)
                .led_color(255,255,255,255)
                .addAction(intent,"Snooze",false)
                .key("test")
                //.time()
                .addAction(new Intent(),"Dismiss",true,false)
                .addAction(intent, "Home")
                .large_icon(R.mipmap.ic_launcher_round)
                .build();
    }

    // start new activity to view progress activity
    public void clickProgress(View v) {
        Intent intent = new Intent(AlertsActivity.this, ProgressActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    // start new activity to view main activity
    public void clickHome(View v) {
        Intent intent = new Intent(AlertsActivity.this, MainActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    public void clickBMI(View v) {
        Intent intent = new Intent(AlertsActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    public void clickAlerts(View v) {
        Intent intent = new Intent(AlertsActivity.this, AlertsActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    private ArrayList<TimeItemCmp> timeListPopulate(){

        ArrayList<TimeItemCmp> lst = new ArrayList<>();
        String[] array = {"Before Breakfast Time","After Breakfast Time",
                "Before Lunch Time","After Lunch Time",
                "Before Dinner Time","After Dinner Time",
                "Before Workout Time","After Workout Time"};

        for(int i = 0; i < 8; i++) {
            TimeItemCmp tic = new TimeItemCmp();
            tic.setTitle(array[i]);
            tic.setEditTextValue(String.valueOf(i));
            lst.add(tic);
        }
        return lst;
    }

    public void clickExtras(View v) {
        Intent intent = new Intent(AlertsActivity.this, ExtraActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

}
