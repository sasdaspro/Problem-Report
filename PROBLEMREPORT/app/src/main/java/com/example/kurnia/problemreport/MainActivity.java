package com.example.kurnia.problemreport;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    Button btnCal, btnSave;
    int years,months, days;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner SPsalpen = (Spinner) findViewById(R.id.SPsalpen);
        Spinner SPketerangan = (Spinner) findViewById(R.id.SPketerangan);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Salpen));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SPsalpen.setAdapter(myAdapter);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Keterangan));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SPketerangan.setAdapter(myAdapter2);

        final Calendar cal = Calendar.getInstance();
        years = cal.get(Calendar.YEAR);
        months = cal.get(Calendar.MONTH);
        days = cal.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonClick();
    }

    public void showDialogOnButtonClick(){
        btnCal = (Button)findViewById(R.id.calendar);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dplistener, years, months, days);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dplistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            years = year;
            months = month + 1;
            days = dayOfMonth;

            TextView d = (TextView) findViewById(R.id.TVdate);
            TextView m = (TextView) findViewById(R.id.TVmonth);
            TextView y = (TextView) findViewById(R.id.TVyears);
            d.setText(new StringBuilder().append(days));
            m.setText(new StringBuilder().append(months));
            y.setText(new StringBuilder().append(years));
        }
    };

    public void onClickSave(View v){
        final EditText etNamaTempat = (EditText) findViewById(R.id.ETnama_tempat);
        String nmTempat = etNamaTempat.getText().toString();

        final EditText etAlamat = (EditText) findViewById(R.id.ETalamat);
        String alamat = etAlamat.getText().toString();

        final EditText etNamaTeknisi = (EditText) findViewById(R.id.ETnama_teknisi);
        String nmTeknisi = etNamaTeknisi.getText().toString();

        final EditText etCP = (EditText) findViewById(R.id.ETcp);
        String cp = etCP.getText().toString();

        final EditText etODP = (EditText) findViewById(R.id.ETodp_ondesk);
        String odp = etODP.getText().toString();

        String tglLaporan = String.valueOf(new StringBuilder().append(days).append(" / ")
                .append(months).append(" / ").append(years));

        final Spinner etSalpen = (Spinner) findViewById(R.id.SPsalpen);
        String salpen = etSalpen.getSelectedItem().toString();

        final Spinner etKeterangan = (Spinner) findViewById(R.id.SPketerangan);
        String keterangan = etKeterangan.getSelectedItem().toString();

        final EditText etDetail = (EditText) findViewById(R.id.ETdetails);
        String detail = etDetail.getText().toString();

        System.out.println(nmTempat + " " + alamat + " " + nmTeknisi + " " + cp + " " + odp + " " + tglLaporan + " " + salpen + " " + keterangan + " " + detail);
    }

}