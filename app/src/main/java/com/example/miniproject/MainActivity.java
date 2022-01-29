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
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    EditText departuredate;
    int year_x,month_x,day_x;
    static final int dialogid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Calendar cal=Calendar.getInstance();
        year_x=cal.get(Calendar.YEAR);
        day_x=cal.get(Calendar.DAY_OF_MONTH);
        month_x=cal.get(Calendar.MONTH);
        showDialogOnButtonClick();
        Button next=findViewById(R.id.Next_1);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText departured=findViewById(R.id.departuredate);
                String departuredate=departured.getText().toString();

                Intent i = new Intent(MainActivity.this,DepartureTime.class);
                i.putExtra("departuredate",departuredate);
                startActivity(i);
            }
        });
    }
    public void showDialogOnButtonClick(){
        departuredate=findViewById(R.id.departuredate);
        departuredate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   showDialog(dialogid);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id==dialogid)
            return new DatePickerDialog(this,dpickerLisner,year_x,month_x,day_x);
        return null;
    }
   private DatePickerDialog.OnDateSetListener dpickerLisner=new DatePickerDialog.OnDateSetListener() {
       @Override
       public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
           day_x=dayOfMonth;
           month_x=month+1;
           year_x=year;
           departuredate=findViewById(R.id.departuredate);
           departuredate.setText(day_x+"-"+month_x+"-"+year);
       }
   };
}