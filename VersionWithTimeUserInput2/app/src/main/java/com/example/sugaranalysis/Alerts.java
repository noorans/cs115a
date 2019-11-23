package com.example.sugaranalysis;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Alerts extends AppCompatActivity {

    private TextView timeOnlook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        timeOnlook = (TextView) findViewById(R.id.timeOnlook);

        for (int i = 0; i < AdapterTime.timeItemAL.size(); i++){

            timeOnlook.setText(timeOnlook.getText() + " " + AdapterTime.timeItemAL.get(i).getEditTextValue() +System.getProperty("line.separator"));

        }


    }
}
