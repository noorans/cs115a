package com.example.sugaranalysis;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ImageView progressButton, bmiButton, alertsButton, contactsButton, settingsButton;
    int i;
    private Button sugarInputbtn;
    private ListView sugarInputlv;
    private ListView tInput;
    private CustomeAdapter customeAdapter;
    private AdapterTime adapterTime;
    public ArrayList<EditModel> editModelArrayList;
    public ArrayList<TimeItemCmp> timeItemCmpArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sugarInputlv = (ListView) findViewById(R.id.listView);
        sugarInputbtn = (Button) findViewById(R.id.sugarInputbtn);
        tInput = (ListView) findViewById(R.id.timeList);

        editModelArrayList = populateList();
        customeAdapter = new CustomeAdapter(this,editModelArrayList);
        sugarInputlv.setAdapter(customeAdapter);

        timeItemCmpArrayList = timeListPopulate();
        adapterTime = new AdapterTime(MainActivity.this, timeItemCmpArrayList);
        tInput.setAdapter(adapterTime);


        // buttons/icons
        progressButton = (ImageView) findViewById(R.id.progressIcon);
        bmiButton = findViewById(R.id.bmiIcon);
        alertsButton = findViewById(R.id.bellIcon);
        contactsButton = findViewById(R.id.contactIcon);
        settingsButton = findViewById(R.id.settingsIcon);

        // start new activity to view settings activity
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // start new activity to view blood sugar input
        sugarInputbtn.setOnClickListener(new View.OnClickListener() {
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

    public void clickAlerts(View v) {
        Intent intent = new Intent(MainActivity.this, Alerts.class);
        intent.setType("*/*");
        startActivity(intent);
    }

    //calling EditModel
    private ArrayList<EditModel> populateList(){

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
    }

    private ArrayList<TimeItemCmp> timeListPopulate(){

        ArrayList<TimeItemCmp> lst = new ArrayList<>();

        for(i = 0; i < 8; i++){
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

    /*
    private ArrayList<TimeItemCmp> timeListPopulate(){

        ArrayList<TimeItemCmp> lst = new ArrayList<>();
        String[] array = {"Before Breakfast Time","After Breakfast Time",
                            "Before Lunch Time","After Lunch Time",
                            "Before Dinner Time","After Dinner Time",
                            "Before Workout Time","After Workout Time"};

        for(i = 0; i < 8; i++) {
            TimeItemCmp tic = new TimeItemCmp();
            tic.setTitle(array[i]);
            tic.setEditTextValue(String.valueOf(i));
            lst.add(tic);
        }
        return lst;
    }
    */



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
