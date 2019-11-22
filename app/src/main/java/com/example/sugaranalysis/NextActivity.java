package com.example.sugaranalysis;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//prints the text values of all the edittexts
public class NextActivity extends AppCompatActivity {

    private TextView bloodSugartv;
    ImageView progressButton, bmiButton, alertsButton, contactsButton,
            settingsButton, logsButton, homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        homeButton = findViewById(R.id.titleSugar);
        progressButton = findViewById(R.id.progress);
        bmiButton = findViewById(R.id.bmi);
        alertsButton = findViewById(R.id.alerts);
        contactsButton = findViewById(R.id.contacts);
        settingsButton = findViewById(R.id.settings);
        logsButton = findViewById(R.id.logs);

        // start new activity to view settings activity
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, SettingsActivity.class);
                startActivity(intent);

            }
        });

        // start new activity to view blood sugar input
        logsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NextActivity.this, NextActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bloodSugartv = (TextView) findViewById(R.id.bloodSugartv);
        for (int i = 0; i < CustomeAdapter.editModelArrayList.size(); i++){
            bloodSugartv.setText(bloodSugartv.getText() + " " + CustomeAdapter.editModelArrayList.get(i).getEditTextValue() +System.getProperty("line.separator"));
        }
    }
    // start new activity to view progress activity
    public void clickProgress(View v) {
        Intent intent = new Intent(NextActivity.this, ProgressActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    // start new activity to view main activity
    public void clickHome(View v) {
        Intent intent = new Intent(NextActivity.this, MainActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();

    }

    public void clickBMI(View v) {
        Intent intent = new Intent(NextActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }
}
