package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlertsActivity extends AppCompatActivity {

    private ListView tInput;

    private AdapterTime adapterTime;
    public ArrayList<TimeItemCmp> timeItemCmpArrayList;
    // private TextView timeOnlook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        tInput = (ListView) findViewById(R.id.timeList);

        timeItemCmpArrayList = timeListPopulate();
        adapterTime = new AdapterTime(AlertsActivity.this, timeItemCmpArrayList);
        tInput.setAdapter(adapterTime);


//        timeOnlook = (TextView) findViewById(R.id.timeOnlook);
//
//        for (int i = 0; i < AdapterTime.timeItemAL.size(); i++){
//
//            timeOnlook.setText(timeOnlook.getText() + " " + AdapterTime.timeItemAL.get(i).getEditTextValue() +System.getProperty("line.separator"));
//
//        }

    }

    private ArrayList<TimeItemCmp> timeListPopulate(){

        ArrayList<TimeItemCmp> lst = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            TimeItemCmp tic = new TimeItemCmp();
            if(i == 0) {
                // title at position 0
                tic.setTitle("Before Breakfast Time");
            }
            else if (i == 1) {
                // title at position 1
                tic.setTitle("After Breakfast Time");
            }
            else if(i == 2) {
                // title at position 2
                tic.setTitle("Before Lunch Time");
            }
            else if(i == 3) {
                // title at position 3
                tic.setTitle("After Lunch Time");
            }
            else if (i == 4) {
                // title at position 4
                tic.setTitle("Before Dinner Time");
            }
            else if(i == 5) {
                // title at position 5
                tic.setTitle("After Dinner Time");
            }
            else if (i == 6) {
                // title at position 6
                tic.setTitle("Before Workout Time");
            }
            else if(i == 7) {
                // title at position 7
                tic.setTitle("After Workout Time");
            }
            tic.setEditTextValue(String.valueOf(i));
            lst.add(tic);
        }
        System.out.println("----------------");
        System.out.println(lst);
        System.out.println("----------------");
        return lst;
    }
}
