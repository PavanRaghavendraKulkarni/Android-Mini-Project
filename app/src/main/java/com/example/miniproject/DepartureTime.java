package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import javax.xml.transform.Source;

public class DepartureTime extends AppCompatActivity {
    EditText departuret;
    int hour,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departure_time);
        Button next=findViewById(R.id.Next_4);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                departuret=findViewById(R.id.departuretime);
                String departuretime=departuret.getText().toString();
                Intent in=getIntent();
                String departuredate=in.getStringExtra("departuredate");

                Intent i = new Intent(DepartureTime.this, DepartureDate.class);
                i.putExtra("departuredate",departuredate);
                i.putExtra("departuretime",departuretime);
                //System.out.println(departuredate);
                //System.out.println(departuretime);

                startActivity(i);
            }
        });
    }
    public   void  popTimePicker(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int selectedhour, int selectedMinute) {
                hour=selectedhour;
                minute=selectedMinute;
                departuret=findViewById(R.id.departuretime);
                departuret.setText(hour+":"+minute);

            }
        };
        TimePickerDialog timePickerDialog=new TimePickerDialog(this,onTimeSetListener,hour,minute,false);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}