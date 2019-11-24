package com.example.sugaranalysis;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sugaranalysis.Objects.LogObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.sugaranalysis.MainActivity.log;

public class LogActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<LogObject> logObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown);
        logObjects = new ArrayList<>();
        recyclerView = findViewById((R.id.rvContacts));
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        LogAdapter logAdapter = new LogAdapter(logObjects);
        recyclerView.setAdapter(logAdapter);
    }
}
