package com.example.admin.logistics;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CompanyToDepo extends AppCompatActivity {
    Spinner vehicletypespinner,fromspinner,tospinner;
    Button startscan;
    String[] vehicletype={"Bike","Cars","Buses","Trucks"};
    int[] vehicleImages={R.drawable.scooter,R.drawable.car,R.drawable.bus,R.drawable.deliverytruck};
    String[] from={"Tirupathi","Rajahmundry","Vijayawada","Vizag"};
    String[] to={"Tirupathi","Rajahmundry","Vijayawada","Vizag"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_to_depo);
        startscan=findViewById(R.id.startscan);
        vehicletypespinner=findViewById(R.id.vehicletypespinner);
        fromspinner=findViewById(R.id.fromspinner);
        tospinner=findViewById(R.id.tospinner);
        startscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CompanyToDepo.this,Depo.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> fromadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, from);//setting the country_array to spinner
        fromadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromspinner.setAdapter(fromadapter);
//if you want to set any action you can do in this listener
        fromspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                ((TextView) arg1).setTextColor(getResources().getColor(R.color.blue));
                try {

                    String select_item =arg0.getItemAtPosition(position).toString();
                }
                catch (Exception e) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        ArrayAdapter<String> toadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, to);//setting the country_array to spinner
        toadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tospinner.setAdapter(toadapter);
//if you want to set any action you can do in this listener
        tospinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                ((TextView) arg1).setTextColor(getResources().getColor(R.color.blue));
                try {

                    String select_item =arg0.getItemAtPosition(position).toString();
                }
                catch (Exception e) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
      CustomAdapter adapter=new CustomAdapter(CompanyToDepo.this,vehicleImages,vehicletype);
       vehicletypespinner.setAdapter(adapter);
//if you want to set any action you can do in this listener
        vehicletypespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                try {

                    String select_item =arg0.getItemAtPosition(position).toString();
                }
                catch (Exception e) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }
}
