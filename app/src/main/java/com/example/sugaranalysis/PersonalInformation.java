package com.example.sugaranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PersonalInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
    }

    public void saveInformation(View view)
    {
        Intent switcher = new Intent(this,MainActivity.class);
        startActivity(switcher);

    }

}