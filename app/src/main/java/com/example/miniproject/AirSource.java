package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AirSource extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_source);
        String city[] = {"Delhi","Mumbai","Kolkata","Chennai"};

// Selection of the spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, city);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);
        Button next=findViewById(R.id.Next_5);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner source1=findViewById(R.id.spinner);
                int pos=source1.getSelectedItemPosition();
                //System.out.println(source);

                String source=city[pos];
                Intent in=getIntent();
                String departuredate=in.getStringExtra("departuredate");
                String departuretime=in.getStringExtra("departurtime");
                String arrivaldate=in.getStringExtra("arrivaldate");
                String arrivaltime=in.getStringExtra("arrivaltime");

                Intent i = new Intent(AirSource.this,AirDestination.class);
                i.putExtra("departuredate",departuredate);
                i.putExtra("departurtime",departuretime);
                i.putExtra("arrivaldate",arrivaldate);
                i.putExtra("arrivaltime",arrivaltime);
                i.putExtra("source",source);
                startActivity(i);
                //System.out.println(departuredate);
                //System.out.println(departuretime);
                //System.out.println(arrivaldate);
                //System.out.println(arrivaltime);
                //System.out.println(source);
            }
        });
    }
}