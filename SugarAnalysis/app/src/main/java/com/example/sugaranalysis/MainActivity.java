package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView progressButton, bmiButton, alertsButton, contactsButton, settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressButton = findViewById(R.id.progressIcon);
        bmiButton = findViewById(R.id.bmiIcon);
        alertsButton = findViewById(R.id.bellIcon);
        contactsButton = findViewById(R.id.contactIcon);
        settingsButton = findViewById(R.id.settingsIcon);


        // start new activity to view settings activity
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                //startActivity(intent);
            }
        });


        // start new activity to view progress activity
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
                // startActivity(intent);
            }
        });

        // start new acitivity to view BMI activity
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                // startActivity(intent);
            }
        });

        // start new activity to view alerts activity
        alertsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(MainActivity.this, AlertsActivity.class);
                // startActivity(intent);
            }

        });

        // start new activity to view contacts activity
        contactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
                // startActivity(intent);
            }

        });

    }
}


