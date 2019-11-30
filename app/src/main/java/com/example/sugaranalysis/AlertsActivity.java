package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.allyants.notifyme.NotifyMe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlertsActivity extends AppCompatActivity  {
    ImageView progressButton, bmiButton, alertsButton, extrasButton,
            settingsButton, logsButton, homeButton;
    ImageButton bb, ab, bl, al, bd, ad, bw, aw;
    EditText label, time;
    Button notifyButton;
    String labels, times;
    Calendar now = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        homeButton = findViewById(R.id.titleSugar);
        progressButton = findViewById(R.id.progress);
        bmiButton = findViewById(R.id.bmi);
        alertsButton = findViewById(R.id.alerts);
        extrasButton = findViewById(R.id.extra);
        settingsButton = findViewById(R.id.settings);
        logsButton = findViewById(R.id.logs);

        //label = findViewById(R.id.label);
        time = findViewById(R.id.time);
        bb = findViewById(R.id.bb);
        ab = findViewById(R.id.ab);
        bl = findViewById(R.id.bl);
        al = findViewById(R.id.al);
        bd = findViewById(R.id.bd);
        ad = findViewById(R.id.ad);
        bw = findViewById(R.id.bw);
        aw = findViewById(R.id.aw);


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

        //parseForTime(times);

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bb.setBackgroundResource(R.drawable.bb_filled);
                times = time.getText().toString();
                labels = "Before Breakfast";
                parseForTime(times);
                Toast.makeText(AlertsActivity.this, "NOTIFICATION SET BEFORE BREAKFAST", Toast.LENGTH_LONG).show();
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ab.setBackgroundResource(R.drawable.ab_filled);
                times = time.getText().toString();
                labels = "After Breakfast";
                parseForTime(times);
                Toast.makeText(AlertsActivity.this, "NOTIFICATION SET AFTER BREAKFAST", Toast.LENGTH_LONG).show();
            }
        });

        bl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bl.setBackgroundResource(R.drawable.bl_filled);
                times = time.getText().toString();
                labels = "Before Lunch";
                parseForTime(times);
                Toast.makeText(AlertsActivity.this, "NOTIFICATION SET BEFORE LUNCH", Toast.LENGTH_LONG).show();
            }
        });

        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                al.setBackgroundResource(R.drawable.al_filled);
                times = time.getText().toString();
                labels = "After Lunch";
                parseForTime(times);
                Toast.makeText(AlertsActivity.this, "NOTIFICATION SET AFTER LUNCH", Toast.LENGTH_LONG).show();
            }
        });

        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.setBackgroundResource(R.drawable.bd_filled);
                times = time.getText().toString();
                labels = "Before Dinner";
                parseForTime(times);
                Toast.makeText(AlertsActivity.this, "NOTIFICATION SET BEFORE DINNER", Toast.LENGTH_LONG).show();
            }
        });

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.setBackgroundResource(R.drawable.ad_filled);
                times = time.getText().toString();
                labels = "After Dinner";
                parseForTime(times);
                Toast.makeText(AlertsActivity.this, "NOTIFICATION SET AFTER DINNER", Toast.LENGTH_LONG).show();
            }
        });

        bw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bw.setBackgroundResource(R.drawable.bw_filled);
                times = time.getText().toString();
                labels = "Before Workout";
                parseForTime(times);
                Toast.makeText(AlertsActivity.this, "NOTIFICATION SET BEFORE WORKOUT", Toast.LENGTH_LONG).show();
            }
        });

        aw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aw.setBackgroundResource(R.drawable.aw_filled);
                times = time.getText().toString();
                labels = "After Workout";
                parseForTime(times);
                Toast.makeText(AlertsActivity.this, "NOTIFICATION SET AFTER WORKOUT", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void parseForTime(String times) {
        // military time
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        Calendar now = Calendar.getInstance();
        Date date1 = null;

        try {
            date1 = time.parse(times);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int hours = date1.getHours();
        int mins = date1.getMinutes();

        // setting time
        now.set(Calendar.HOUR_OF_DAY, hours);
        now.set(Calendar.MINUTE, mins);
        now.set(Calendar.SECOND, 0);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("test","I am a String");
        NotifyMe notifyMe = new NotifyMe.Builder(getApplicationContext())
                .title(labels)
                .content("Please check blood you blood sugar")
                .color(27,129,225,0)
                .led_color(89,180,248,0)
                .key("test")
                .time(now) // where time is set
                .addAction(new Intent(),"Dismiss",true,false)
                .addAction(intent, "Home")
                .large_icon(R.mipmap.ic_launcher_round)
                .build();
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

    public void clickExtras(View v) {
        Intent intent = new Intent(AlertsActivity.this, ExtraActivity.class);
        intent.setType("*/*");
        startActivity(intent);
        finish();
    }

}
