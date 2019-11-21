package com.example.sugaranalysis;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ImageView progressButton, bmiButton, alertsButton, contactsButton,
            settingsButton, logsButton, homeButton;
    int i;
    private ListView sugarInputlv;
    private CustomeAdapter customeAdapter;
    public ArrayList<EditModel> editModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sugarInputlv = findViewById(R.id.listView);
        editModelArrayList = populateList();
        customeAdapter = new CustomeAdapter(this,editModelArrayList);
        sugarInputlv.setAdapter(customeAdapter);


        // buttons/icons
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
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // start new activity to view blood sugar input
        logsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
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
    private ArrayList<EditModel> populateList(){

        ArrayList<EditModel> list = new ArrayList<>();

        for(i = 0; i < 8; i++){
            // manually added space for allignment reasons
            // trim when you input to sql database
            EditModel editModel = new EditModel();
            if(i == 0) {
                // title at position 0
                editModel.setTitle("Before Breakfast");
            }
            else if (i == 1) {
                // title at position 1
                editModel.setTitle("After Breakfast   ");
            }
            else if(i == 2) {
                // title at position 2
                editModel.setTitle("Before Lunch      ");
            }
            else if(i == 3) {
                // title at position 3
                editModel.setTitle("After Lunch         ");
            }
            else if (i == 4) {
                // title at position 4
                editModel.setTitle("Before Dinner     ");
            }
            else if(i == 5) {
                // title at position 5
                editModel.setTitle("After Dinner        ");
            }
            else if (i == 6) {
                // title at position 6
                editModel.setTitle("Before Workout  ");
            }
            else if(i == 7) {
                // title at position 7
                editModel.setTitle("After Workout     ");
            }
            editModel.setEditTextValue(String.valueOf(i));
            list.add(editModel);
        }
        return list;
    }

    // THE FOLLOWING OBSOLETE CODE FOR THE MENU INFLATOR

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.subject_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}
