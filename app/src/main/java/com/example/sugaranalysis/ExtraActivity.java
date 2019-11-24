package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ExtraActivity extends AppCompatActivity {

    ImageView progressButton, bmiButton, alertsButton, contactsButton,
            settingsButton, logsButton, homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        // buttons/icons
        homeButton = findViewById(R.id.titleSugar);
        progressButton = findViewById(R.id.progress);
        bmiButton = findViewById(R.id.bmi);
        alertsButton = findViewById(R.id.alerts);
        contactsButton = findViewById(R.id.contacts);
        settingsButton = findViewById(R.id.settings);
        logsButton = findViewById(R.id.logs);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExtraActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // start new activity to view blood sugar input
        logsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExtraActivity.this, LogActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // start new activity to view progress activity
    public void clickProgress(View v) {
        Intent intent = new Intent(ExtraActivity.this, ProgressActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    // start new activity to view main activity
    public void clickHome(View v) {
        Intent intent = new Intent(ExtraActivity.this, MainActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    public void clickBMI(View v) {
        Intent intent = new Intent(ExtraActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    public void clickAlerts(View v) {
        Intent intent = new Intent(ExtraActivity.this, AlertsActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }
}
