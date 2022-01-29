package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AirNoOfStops extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_no_of_stops);
        String stops[] = {"0","1","2","3","4"};

// Selection of the spinner
        Spinner spinner = (Spinner) findViewById(R.id.noofstops);

// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, stops);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);
        Button next=findViewById(R.id.Next_7);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner noofstops1=findViewById(R.id.noofstops);
                int pos=noofstops1.getSelectedItemPosition();
                String noofstops=stops[pos];
                Intent in=getIntent();
                String departuredate=in.getStringExtra("departuredate");
                String departuretime=in.getStringExtra("departurtime");
                String arrivaldate=in.getStringExtra("arrivaldate");
                String arrivaltime=in.getStringExtra("arrivaltime");
                String source=in.getStringExtra("source");
                String destination=in.getStringExtra("destination");

                Intent i = new Intent(AirNoOfStops.this,AirPlane.class);
                i.putExtra("departuredate",departuredate);
                i.putExtra("departurtime",departuretime);
                i.putExtra("arrivaldate",arrivaldate);
                i.putExtra("arrivaltime",arrivaltime);
                i.putExtra("source",source);
                i.putExtra("destination",destination);
                i.putExtra("noofstops",noofstops);
                //System.out.println(departuredate);
                //System.out.println(departuretime);
                //System.out.println(arrivaldate);
                //System.out.println(arrivaltime);
                //System.out.println(source);
                //System.out.println(destination);
                //System.out.println(noofstops);
                startActivity(i);
            }
        });
    }
}