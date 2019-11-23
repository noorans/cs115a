package com.example.sugaranalysis;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.sugaranalysis.SettingsFragment.PREFERENCE_HEIGHT;
import static com.example.sugaranalysis.SettingsFragment.PREFERENCE_WEIGHT;


public class MainActivity extends AppCompatActivity {

    ImageView progressButton, bmiButton, alertsButton, contactsButton, settingsButton;
    int i;
    //private Button sugarInputbtn;
    //private ListView sugarInputlv;
    //private CustomeAdapter customeAdapter;
    //public ArrayList<EditModel> editModelArrayList;
    public static LogDB log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Instanciating the Database
        log = new LogDB(this,LogDB.DB_NAME, null, 1);

        /*sugarInputlv = (ListView) findViewById(R.id.listView);
        sugarInputbtn = (Button) findViewById(R.id.sugarInputbtn);

        editModelArrayList = populateList();
        customeAdapter = new CustomeAdapter(this,editModelArrayList);
        sugarInputlv.setAdapter(customeAdapter);*/


        // buttons/icons
        progressButton = (ImageView) findViewById(R.id.progressIcon);
        bmiButton = findViewById(R.id.bmiIcon);
        alertsButton = findViewById(R.id.bellIcon);
        contactsButton = findViewById(R.id.contactIcon);
        settingsButton = findViewById(R.id.settingsIcon);

        // TextViews for moment names
        final TextView beforeBreakfast = findViewById(R.id.beforeBreakfast);
        final TextView afterBreakfast = findViewById(R.id.afterBreakfast);
        final TextView beforeLunch = findViewById(R.id.beforeLunch);
        final TextView afterLunch = findViewById(R.id.afterLunch);
        final TextView beforeDinner = findViewById(R.id.beforeDinner);
        final TextView afterDinner = findViewById(R.id.afterDinner);
        final TextView beforeWorkout = findViewById(R.id.beforeWorkout);
        final TextView afterWorkout = findViewById(R.id.afterWorkout);

        // EditTexts for BS
        EditText beforeBreakfastBS = findViewById(R.id.bbBS);
        EditText afterBreakfastBS = findViewById(R.id.abBS);
        EditText beforeLunchBS = findViewById(R.id.blBS);
        EditText afterLunchBS = findViewById(R.id.alBS);
        EditText beforeDinnerBS = findViewById(R.id.bdBS);
        EditText afterDinnerBS = findViewById(R.id.adBS);
        EditText beforeWorkoutBS = findViewById(R.id.bwBS);
        EditText afterWorkoutBS = findViewById(R.id.awBS);

        // Buttons for BS
        Button beforeBreakfastButton = findViewById(R.id.bbButton);
        Button afterBreakfastButton = findViewById(R.id.abButton);
        Button beforeLunchButton = findViewById(R.id.blButton);
        Button afterLunchButton = findViewById(R.id.alButton);
        Button beforeDinnerButton = findViewById(R.id.bdButton);
        Button afterDinnerButton = findViewById(R.id.adButton);
        Button beforeWorkoutButton = findViewById(R.id.bwButton);
        Button afterWorkoutButton = findViewById(R.id.awButton);


        // start new activity to view settings activity
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // start new activity to view blood sugar input
        /*sugarInputbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });*/


        // Setting on click listeners for all buttons on main page

        // FUNCTION
        // onClick of button, set parameters for database call
        // call addToDataBase

        beforeBreakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView bstext = findViewById(R.id.bbBS);
                String bs = bstext.getText().toString();
                String moment = beforeBreakfast.getText().toString();
                addToDataBase(bs, moment);
            }
        });

        afterBreakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView bstext = findViewById(R.id.abBS);
                String bs = bstext.getText().toString();
                String moment = afterBreakfast.getText().toString();
                addToDataBase(bs, moment);
            }
        });

        beforeLunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView bstext = findViewById(R.id.blBS);
                String bs = bstext.getText().toString();
                String moment = beforeLunch.getText().toString();
                addToDataBase(bs, moment);
            }
        });

        afterLunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView bstext = findViewById(R.id.alBS);
                String bs = bstext.getText().toString();
                String moment = afterLunch.getText().toString();
                addToDataBase(bs, moment);
            }
        });

        beforeDinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView bstext = findViewById(R.id.bdBS);
                String bs = bstext.getText().toString();
                String moment = beforeDinner.getText().toString();
                addToDataBase(bs, moment);
            }
        });

        afterDinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView bstext = findViewById(R.id.adBS);
                String bs = bstext.getText().toString();
                String moment = afterDinner.getText().toString();
                addToDataBase(bs, moment);
            }
        });

        beforeWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView bstext = findViewById(R.id.bwBS);
                String bs = bstext.getText().toString();
                String moment = beforeWorkout.getText().toString();
                addToDataBase(bs, moment);
            }
        });

        afterWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView bstext = findViewById(R.id.awBS);
                String bs = bstext.getText().toString();
                String moment = afterWorkout.getText().toString();
                addToDataBase(bs, moment);
            }
        });


    }
    // start new activity to view progress activity
    public void clickProgress(View v) {
        Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
        intent.setType("*/*");
        startActivity(intent);
    }

    // start new activity to view main activity
    public void clickHome(View v) {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setType("*/*");
        startActivity(intent);
    }

    public void clickBMI(View v) {
        Intent intent = new Intent(MainActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);
    }

    //calling EditModel
    /*public ArrayList<EditModel> populateList(){

        ArrayList<EditModel> list = new ArrayList<>();

        for(i = 0; i < 8; i++){
            EditModel editModel = new EditModel();
            if(i == 0) {
                // title at position 0
                editModel.setTitle("Before Breakfast");
            }
            else if (i == 1) {
                // title at position 1
                editModel.setTitle("After Breakfast");
            }
            else if(i == 2) {
                // title at position 2
                editModel.setTitle("Before Lunch");
            }
            else if(i == 3) {
                // title at position 3
                editModel.setTitle("After Lunch");
            }
            else if (i == 4) {
                // title at position 4
                editModel.setTitle("Before Dinner");
            }
            else if(i == 5) {
                // title at position 5
                editModel.setTitle("After Dinner");
            }
            else if (i == 6) {
                // title at position 6
                editModel.setTitle("Before Workout");
            }
            else if(i == 7) {
                // title at position 7
                editModel.setTitle("After Workout");
            }
            editModel.setEditTextValue(String.valueOf(i));
            list.add(editModel);
        }
        return list;
    }*/

    public void addToDataBase(String bs, String moment){

        SharedPreferences myPreferences = getSharedPreferences("com.example.sugaranalysis_preferences", 0);
        String date;
        String time;

        String height = myPreferences.getString("userHeight","");
        String weight = myPreferences.getString("userWeight", "");
        date = "11/21/2019";
        time = "6:00pm";

        log.addEntry(bs,moment,date,time,height,weight);
    }

}
