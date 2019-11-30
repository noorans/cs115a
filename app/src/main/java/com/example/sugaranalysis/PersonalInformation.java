package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PersonalInformation extends AppCompatActivity {

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
        TextView nameText = findViewById(R.id.PI_name);
        String myName = nameText.getText().toString();
        TextView ageText = findViewById(R.id.PI_age);
        String myAge = nameText.getText().toString();
        TextView heightText = findViewById(R.id.PI_height);
        String myHeight = nameText.getText().toString();
        TextView weightText = findViewById(R.id.PI_weight);
        String myWeight = nameText.getText().toString();
        TextView docnameText = findViewById(R.id.PI_DoctName);
        String myDocName = nameText.getText().toString();
        TextView docnumText = findViewById(R.id.PI_DoctNum);
        String myDocNum = nameText.getText().toString();



        Intent switcher = new Intent(this,MainActivity.class);
        startActivity(switcher);
        finish();

    }

}