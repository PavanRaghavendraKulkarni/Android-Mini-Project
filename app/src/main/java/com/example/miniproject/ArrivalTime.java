package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class ArrivalTime extends AppCompatActivity {
    EditText arrivalt;
    int hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival_time);
        Button next=findViewById(R.id.Next_2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrivalt=findViewById(R.id.arrivaltime);
                String arrivaltime=arrivalt.getText().toString();
                Intent in=getIntent();
                String departuredate=in.getStringExtra("departuredate");
                String departuretime=in.getStringExtra("departurtime");
                String arrivaldate=in.getStringExtra("arrivaldate");
                Intent i = new Intent(ArrivalTime.this,AirSource.class);
                i.putExtra("departuredate",departuredate);
                i.putExtra("departurtime",departuretime);
                i.putExtra("arrivaldate",arrivaldate);
                i.putExtra("arrivaltime",arrivaltime);
                startActivity(i);
                //System.out.println(departuredate);
                //System.out.println(departuretime);
                //System.out.println(arrivaldate);
                //System.out.println(arrivaltime);

            }
        });
    }
    public   void  popTimePicker(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedhour, int selectedMinute) {
                hour=selectedhour;
                minute=selectedMinute;
                arrivalt=findViewById(R.id.arrivaltime);
                arrivalt.setText(hour+":"+minute);

            }
        };
        TimePickerDialog timePickerDialog=new TimePickerDialog(this,onTimeSetListener,hour,minute,false);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}