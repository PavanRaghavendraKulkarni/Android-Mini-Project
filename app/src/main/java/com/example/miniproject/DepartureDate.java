package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class DepartureDate extends AppCompatActivity {
    EditText arrivald;
    int year_x,month_x,day_x;
    static final int dialogid1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departure_date);
        final Calendar cal=Calendar.getInstance();
        year_x=cal.get(Calendar.YEAR);
        day_x=cal.get(Calendar.DAY_OF_MONTH);
        month_x=cal.get(Calendar.MONTH);
        showDialogOnButtonClick();
        Button next=findViewById(R.id.Next_3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrivald=findViewById(R.id.arrivaldate);
                String arrivaldate=arrivald.getText().toString();
                Intent in=getIntent();
                String departuredate=in.getStringExtra("departuredate");
                String departuretime=in.getStringExtra("departuretime");
                Intent i = new Intent(DepartureDate.this,ArrivalTime.class);
                i.putExtra("departuredate",departuredate);
                i.putExtra("departurtime",departuretime);
                i.putExtra("arrivaldate",arrivaldate);
                //System.out.println(departuredate);
                //System.out.println(departuretime);
                //System.out.println(arrivaldate);

                startActivity(i);
            }
        });
    }
    public void showDialogOnButtonClick(){
        arrivald=findViewById(R.id.arrivaldate);
        arrivald.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(dialogid1);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id==dialogid1)
            return new DatePickerDialog(this,dpickerLisner,year_x,month_x,day_x);
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerLisner=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            day_x=dayOfMonth;
            month_x=month+1;
            year_x=year;
            arrivald=findViewById(R.id.arrivaldate);
            arrivald.setText(day_x+"-"+month_x+"-"+year);
        }
    };
}