package com.example.kurnia.problemreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v4.app.DialogFragment;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    static EditText DateEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateEdit = (EditText) findViewById(R.id.ETtanggal);
        Spinner SPsalpen = (Spinner) findViewById(R.id.SPsalpen);
        Spinner SPketerangan = (Spinner) findViewById(R.id.SPketerangan);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Salpen));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SPsalpen.setAdapter(myAdapter);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Keterangan));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SPketerangan.setAdapter(myAdapter2);

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}

