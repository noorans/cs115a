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


public class MainActivity extends AppCompatActivity {

    ImageView progressButton, bmiButton, alertsButton, contactsButton, settingsButton;
    private Button sugarInputbtn;
    private ListView sugarInputlv;
    private CustomeAdapter customeAdapter;
    public ArrayList<EditModel> editModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sugarInputlv = (ListView) findViewById(R.id.listView);
        sugarInputbtn = (Button) findViewById(R.id.sugarInputbtn);

        editModelArrayList = populateList();
        customeAdapter = new CustomeAdapter(this,editModelArrayList);
        sugarInputlv.setAdapter(customeAdapter);


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
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
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

<<<<<<< HEAD
    //calling EditModel
    private ArrayList<EditModel> populateList(){

        ArrayList<EditModel> list = new ArrayList<>();

        //giving inital values to EditModel
        for(int i = 0; i < 8; i++){
            EditModel editModel = new EditModel();
            editModel.setEditTextValue(String.valueOf(i));
            list.add(editModel);
        }

        return list;
=======
    // start new activity to view BMI acitvity
    public void clickBMI(View v) {
        Intent intent = new Intent(MainActivity.this, BMIActivity.class);
        intent.setType("*/*");
        startActivity(intent);
>>>>>>> 6dc78536325df8b30fa4da75fcd3eda4ba10ff89
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
