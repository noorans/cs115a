package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class ProgressActivity extends AppCompatActivity {
    ImageView progressButton, bmiButton, alertsButton, contactsButton,
            settingsButton, logsButton, homeButton;
    BarChart barChart;
    ArrayList<BarEntry> barEntry;
    ArrayList<String> labelsNames;

    ArrayList<Data> theData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        // buttons
        homeButton = findViewById(R.id.titleSugar);
        logsButton = findViewById(R.id.logs);
        progressButton =  findViewById(R.id.progress);
        bmiButton = findViewById(R.id.bmi);
        alertsButton = findViewById(R.id.alerts);
        contactsButton = findViewById(R.id.contacts);
        settingsButton = findViewById(R.id.settings);

        // start new activity to view settings activity
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // start new activity to view blood sugar input
        logsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProgressActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });


        // barchart stuff
        barChart = findViewById(R.id.barchart);
        barEntry = new ArrayList<>();
        labelsNames = new ArrayList<>();
        fillAverageBloodSugar();
        for(int i = 0; i < theData.size(); i ++) {
            String month = theData.get(i).getDays();
            int sales = theData.get(i).getLevels();
            barEntry.add(new BarEntry(i, sales));
            labelsNames.add(month);
        }
        BarDataSet barDataSet = new BarDataSet(barEntry, "Weekly Progress");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        Description description = new Description();
        description.setText(" ");
        barChart.setDescription(description);
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsNames));
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labelsNames.size());

        xAxis.setLabelRotationAngle(360);
        barChart.animateY(200);
        barChart.invalidate();

    }

    // barchart stuff
    private void fillAverageBloodSugar() {
        theData.clear();
        //int month = new Date().getMonth();
        //int day = new Date().getDate();
        theData.add(new Data("Monday", 5));
        theData.add(new Data("Tuesday", 10));
        theData.add(new Data("Wednesday", 20));
        theData.add(new Data("Thursday", 15));
        theData.add(new Data("Friday", 30));
        theData.add(new Data("Saturday", 10));
        theData.add(new Data("Sunday", 50));
        // find way to reset after all days have been filled
        // average blood sugar is total amount of blood sugar in day/amount of tests that day
    }

    // start new activity to view progress activity
    public void clickProgress(View v) {
        Intent intent = new Intent(ProgressActivity.this, ProgressActivity.class);
        intent.setType("*/*");
        startActivity(intent);
    }

    // start new activity to view main activity
    public void clickHome(View v) {
        Intent intent = new Intent(ProgressActivity.this, MainActivity.class);
        intent.setType("*/*");
        startActivity(intent);
    }

    // start new activity to view BMI acitvity
    public void clickBMI(View v) {
        Intent intent = new Intent(ProgressActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);
    }

}
