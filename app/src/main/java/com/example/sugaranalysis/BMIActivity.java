package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.cat.CountAnimationTextView;

public class BMIActivity extends AppCompatActivity {
    ImageView progressButton, bmiButton, alertsButton, extrasButton,
            settingsButton, logsButton, homeButton;
    EditText weight, height;
    int pounds, inches;
    float meters, kg;
    float formulation;
    ImageButton sI, uS;
    public boolean metric;
    TextView category;
    CountAnimationTextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.result);
        category = findViewById(R.id.category);

        sI = findViewById(R.id.SI);
        uS = findViewById(R.id.US);

        // buttons/icons
        homeButton = findViewById(R.id.titleSugar);
        logsButton = findViewById(R.id.logs);
        progressButton = findViewById(R.id.progress);
        bmiButton = findViewById(R.id.bmi);
        alertsButton = findViewById(R.id.alerts);
        extrasButton = findViewById(R.id.extra);
        settingsButton = findViewById(R.id.settings);

        SharedPreferences prefs = getSharedPreferences("bmiprefs", MODE_PRIVATE);
        String restoredResult = prefs.getString("result", null);
        String restoredCategory = prefs.getString("category", null);
        System.out.println(restoredCategory + restoredResult);
        if (restoredResult != null && restoredCategory != null) {
            result.setText(restoredResult);
            category.setText(restoredCategory);
        }



        // start new activity to view settings activity
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMIActivity.this, SettingsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // start new activity to view blood sugar input
        logsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMIActivity.this, LogActivity.class);
                startActivity(intent);
                finish();
            }
        });

        sI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sI.setBackgroundResource(R.drawable.filled);
                Toast.makeText(BMIActivity.this, "Meters and kilograms required",
                        Toast.LENGTH_SHORT).show();
                metric = true;
            }
        });

        uS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uS.setBackgroundResource(R.drawable.filled);
                Toast.makeText(BMIActivity.this, "Inches and pounds required",
                        Toast.LENGTH_SHORT).show();
                metric = false;
            }
        });
    }

    public void calculateBMI(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
        if(metric) {

            kg = Float.valueOf(weightStr);
            meters = Float.valueOf(heightStr);
            formulation = kg/(meters * meters);
            displayBMI(formulation);
        }
        else {
            pounds = Integer.valueOf(weightStr);
            inches = Integer.valueOf(heightStr);
            formulation = pounds*703/(inches*inches);
            displayBMI(formulation);
        }
    }

    public void displayBMI(final float bmi) {
        String bmiLabel = "";
        if(bmi < 18.5) {
            bmiLabel = getString(R.string.underweight);
        }
        if(bmi >= 18.5 && bmi <= 24.9) {
            bmiLabel = getString(R.string.normal);
        }
        if(bmi >= 25 && bmi <= 29.9) {
            bmiLabel = getString(R.string.overweight);
        }
        if(bmi >= 30) {
            bmiLabel = getString(R.string.obesity);
        }
        // add
        SharedPreferences.Editor edit = getSharedPreferences("bmiprefs", MODE_PRIVATE).edit();
        edit.clear();
        edit.putString("result", String.valueOf((int)bmi));
        edit.putString("category", bmiLabel);
        result.setAnimationDuration(2000)
        .countAnimation(0, (int)bmi);
        category.setText(bmiLabel);
        edit.commit();

    }
    // start new activity to view progress activity
    public void clickProgress(View v) {
        Intent intent = new Intent(BMIActivity.this, ProgressActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    public void clickAlerts(View v) {
        Intent intent = new Intent(BMIActivity.this, AlertsActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    // start new activity to view main activity
    public void clickHome(View v) {
        Intent intent = new Intent(BMIActivity.this, MainActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    // start new activity to view BMI acitvity
    public void clickBMI(View v) {
        Intent intent = new Intent(BMIActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    public void clickExtras(View v) {
        Intent intent = new Intent(BMIActivity.this, ExtraActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }
}
