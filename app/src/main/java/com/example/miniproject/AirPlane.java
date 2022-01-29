package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AirPlane extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_plane);

        String planes[] = {"Jet_Airways","IndiGo","Air_India","Multiple_carriers","SpiceJet","Vistara","GoAir","Multiple_carriers Premium_economy","Jet_Airways_Business","Vistara_Premium_economy","Trujet"};

// Selection of the spinner
        Spinner spinner = (Spinner) findViewById(R.id.planes);

// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, planes);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);
        Button next=findViewById(R.id.Predict);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner airplane1=findViewById(R.id.planes);
                int pos=airplane1.getSelectedItemPosition();
                String airplane=planes[pos];
                Intent in=getIntent();
                String departuredate=in.getStringExtra("departuredate");
                String departuretime=in.getStringExtra("departurtime");
                String arrivaldate=in.getStringExtra("arrivaldate");
                String arrivaltime=in.getStringExtra("arrivaltime");
                String source=in.getStringExtra("source");
                String destination=in.getStringExtra("destination");
                String noofstops= in.getStringExtra("noofstops");

                Intent i = new Intent(AirPlane.this,Predict.class);
                i.putExtra("departuredate",departuredate);
                i.putExtra("departurtime",departuretime);
                i.putExtra("arrivaldate",arrivaldate);
                i.putExtra("arrivaltime",arrivaltime);
                i.putExtra("source",source);
                i.putExtra("destination",destination);
                i.putExtra("noofstops",noofstops);
                i.putExtra("airplane",airplane);
                //System.out.println(departuredate);
                //System.out.println(departuretime);
                //System.out.println(arrivaldate);
                //System.out.println(arrivaltime);
                //System.out.println(source);
                //System.out.println(destination);
                //System.out.println(noofstops);
                //System.out.println(airplane);
                startActivity(i);
            }
        });
    }
}