package com.example.sugaranalysis;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ImageView progressButton, bmiButton, alertsButton, contactsButton, settingsButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView
        listView = (ListView) findViewById(R.id.listview);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Before Breakfast");
        arrayList.add("After Breakfast");
        arrayList.add("Before Lunch");
        arrayList.add("After Lunch");
        arrayList.add("Before Dinner");
        arrayList.add("After Dinner");
        arrayList.add("Before Bedtime Snack");
        arrayList.add("Before Workout");
        arrayList.add("After Workout");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

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


