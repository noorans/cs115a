package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlertsActivity extends AppCompatActivity {
    ImageView progressButton, bmiButton, alertsButton, contactsButton,
            settingsButton, logsButton, homeButton;

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
        contactsButton = findViewById(R.id.contacts);
        settingsButton = findViewById(R.id.settings);
        logsButton = findViewById(R.id.logs);

        tInput = (ListView) findViewById(R.id.timeList);

        timeItemCmpArrayList = timeListPopulate();
        adapterTime = new AdapterTime(AlertsActivity.this, timeItemCmpArrayList);
        tInput.setAdapter(adapterTime);

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


}
