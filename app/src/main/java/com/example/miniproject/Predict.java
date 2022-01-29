package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URLEncoder;

public class Predict extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);
        Intent in=getIntent();
        String departuredate=in.getStringExtra("departuredate");
        String departuretime=in.getStringExtra("departurtime");
        String arrivaldate=in.getStringExtra("arrivaldate");
        String arrivaltime=in.getStringExtra("arrivaltime");
        String source=in.getStringExtra("source");
        String destination=in.getStringExtra("destination");
        String noofstops= in.getStringExtra("noofstops");
        String airplane=in.getStringExtra("airplane");
        String finalvalue= URLEncoder.encode(departuretime);
        String time_dep=finalvalue;
        String finalvalue2=URLEncoder.encode(arrivaltime);
        String Arrival_time=finalvalue2;
        String postUrl = "https://flightfair-api.herokuapp.com/get?Arrival_date="+arrivaldate+"&Arrival_time="+Arrival_time+"&date_dep="+departuredate+"&time_dep="+time_dep+"&Source="+source+"&Destination="+destination+"&stops="+noofstops+"&Airline="+airplane+"&source="+source+"&destination="+destination;
        RequestQueue requestQueue = Volley.newRequestQueue(Predict.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,postUrl,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(Predict.this, StringOf(response), Toast.LENGTH_SHORT).show();
                TextView result=findViewById(R.id.result);
                result.setText(response.toString());
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);







}
}