package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PersonalInformation extends AppCompatActivity {
    public static String myName = "";
    public static String myAge = "";
    public static String myHeight = "";
    public static String myWeight = "";
    public static String myDocName = "";
    public static String myDocNum = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);

        EditText name = findViewById(R.id.PI_name);
        EditText age = findViewById(R.id.PI_age);
        EditText height = findViewById(R.id.PI_height);
        EditText weight = findViewById(R.id.PI_weight);
        EditText doctname = findViewById(R.id.PI_DoctName);
        EditText doctnum = findViewById(R.id.PI_DoctNum);

    }



    public void saveInformation(View view)
    {
        //final String PERSONALINFORMATIONPREFS = "defaultPersonalInformation";
        //SharedPreferences sharedPI = getSharedPreferences(PERSONALINFORMATIONPREFS, 0);
        //SharedPreferences.Editor PIEditor = sharedPI.edit();

        TextView nameText = findViewById(R.id.PI_name);
        myName = nameText.getText().toString();
        //PIEditor.putString("NAME", myName);
        //PIEditor.apply();

        TextView ageText = findViewById(R.id.PI_age);
        myAge = ageText.getText().toString();
        //PIEditor.putString("AGE", myAge);
        //PIEditor.apply();

        TextView heightText = findViewById(R.id.PI_height);
        myHeight = heightText.getText().toString();
        //PIEditor.putString("HEIGHT", myHeight);
        //PIEditor.apply();

        TextView weightText = findViewById(R.id.PI_weight);
        myWeight = weightText.getText().toString();
        //PIEditor.putString("WEIGHT", myWeight);
        //PIEditor.apply();

        TextView docnameText = findViewById(R.id.PI_DoctName);
        myDocName = docnameText.getText().toString();
        //PIEditor.putString("DOCNAME", myDocName);
        //PIEditor.apply();

        TextView docnumText = findViewById(R.id.PI_DoctNum);
        myDocNum = docnumText.getText().toString();
        //PIEditor.putString("DOCNUM", myDocNum);
        //PIEditor.apply();

        Intent switcher = new Intent(this,MainActivity.class);
        startActivity(switcher);
        finish();

    }

}
