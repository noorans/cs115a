package com.example.sugaranalysis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sugaranalysis.Objects.LogObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.sugaranalysis.MainActivity.logDB;

public class LogActivity extends AppCompatActivity {
    ImageView progressButton, bmiButton, alertsButton, extrasButton,
            settingsButton, logsButton, homeButton;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<LogObject> logObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown);

        // buttons/icons
        homeButton = findViewById(R.id.titleSugar);
        progressButton = findViewById(R.id.progress);
        bmiButton = findViewById(R.id.bmi);
        alertsButton = findViewById(R.id.alerts);
        extrasButton = findViewById(R.id.extra);
        settingsButton = findViewById(R.id.settings);
        logsButton = findViewById(R.id.logs);

        logObjects = new ArrayList<>();
        logDB.fillList(logObjects, "");
        recyclerView = (RecyclerView) findViewById((R.id.rvContacts));
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        LogAdapter logAdapter = new LogAdapter(logObjects);
        recyclerView.setAdapter(logAdapter);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // start new activity to view blood sugar input
        logsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogActivity.this, LogActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // start new activity to view progress activity
    public void clickProgress(View v) {
        Intent intent = new Intent(LogActivity.this, ProgressActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    // start new activity to view main activity
    public void clickHome(View v) {
        Intent intent = new Intent(LogActivity.this, MainActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    public void clickBMI(View v) {
        Intent intent = new Intent(LogActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    public void clickAlerts(View v) {
        Intent intent = new Intent(LogActivity.this, AlertsActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    public void clickExtras(View v) {
        Intent intent = new Intent(LogActivity.this, ExtraActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }
}
