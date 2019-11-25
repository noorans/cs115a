package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sugaranalysis.Objects.LogObject;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import static com.example.sugaranalysis.MainActivity.log;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class ProgressActivity extends AppCompatActivity {
    ImageView progressButton, bmiButton, alertsButton, extrasButton,
            settingsButton, logsButton, homeButton;
    BarChart barChart;
    ArrayList<String> labelsNames;
    ArrayList<BarEntry> barEntry;
    ArrayList<Data> theData = new ArrayList<>();


    ArrayList<LogObject> theAvg = new ArrayList<>();

    int blue1, blue2, blue3;
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
        extrasButton = findViewById(R.id.extra);
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
                Intent intent = new Intent(ProgressActivity.this, LogActivity.class);
                startActivity(intent);

            }
        });


        // barchart stuff
        barChart = findViewById(R.id.barchart);
        barEntry = new ArrayList<>();
        labelsNames = new ArrayList<>();

        fillAverageBloodSugar();

        // barchart arraylist takes in a label and value
        for(int i = 0; i < theData.size(); i ++) {
            String month = theData.get(i).getDays();
            int levels = theData.get(i).getLevels();
            barEntry.add(new BarEntry(i, levels));
            labelsNames.add(month);
        }

        blue1 = Color.rgb(21,104,184);
        blue2 = Color.rgb(27, 129, 225);
        blue3= Color.rgb(117, 181, 240);

        BarDataSet barDataSet = new BarDataSet(barEntry, "Weekly Progress");
        barDataSet.setColors(new int []
                {blue1, blue2, blue3, blue1, blue2, blue3, blue1});
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
        int sum = 0;
        //theData.clear();
        //if date == current date
        // fill list with values
        // calculate average
        // add the bar chart with  corresponding label of date
        // cannot due currentdate+ 1
        log.fillList(theAvg, "11/21/2019");
        for(int i = 0; i < theAvg.size(); i ++) {
           if(!(theAvg.get(i).getLogAvg_bs().equals(""))) {
               sum = Integer.valueOf(theAvg.get(i).getLogAvg_bs());
           }
        }
        int avg_of_day = sum/theAvg.size();
        theData.add(new Data("11/21/19", avg_of_day));


        //int month = new Date().getMonth();
        //int day = new Date().getDate();

        //for(int i = 0; i < levels.size(); i++) {
        // if (sql.database.day MONDAY == my barchart MONDAY) {
        // sum of blood sugar/ number of non empty inputs
        // add to chart monday

        // find way to reset after all days have been filled
        // average blood sugar is total amount of blood sugar in day/amount of tests that day
    }

    // start new activity to view progress activity
    public void clickProgress(View v) {
        Intent intent = new Intent(ProgressActivity.this, ProgressActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    // start new activity to view main activity
    public void clickHome(View v) {
        Intent intent = new Intent(ProgressActivity.this, MainActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    // start new activity to view BMI acitvity
    public void clickBMI(View v) {
        Intent intent = new Intent(ProgressActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    public void clickAlerts(View v) {
        Intent intent = new Intent(ProgressActivity.this, AlertsActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

    public void clickExtras(View v) {
        Intent intent = new Intent(ProgressActivity.this, ExtraActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

}
