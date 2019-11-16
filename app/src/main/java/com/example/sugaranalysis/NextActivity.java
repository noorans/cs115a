package com.example.sugaranalysis;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

//prints the text values of all the edittexts
public class NextActivity extends AppCompatActivity {

    private TextView bloodSugartv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        bloodSugartv = (TextView) findViewById(R.id.bloodSugartv);

        for (int i = 0; i < CustomeAdapter.editModelArrayList.size(); i++){

            bloodSugartv.setText(bloodSugartv.getText() + " " + CustomeAdapter.editModelArrayList.get(i).getEditTextValue() +System.getProperty("line.separator"));

        }


    }
}
