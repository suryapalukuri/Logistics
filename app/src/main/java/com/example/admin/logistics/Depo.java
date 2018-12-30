package com.example.admin.logistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Depo extends AppCompatActivity {
Button scan;
    String[] vehicletype={"Bike","Cars","Buses","Trucks"};
    int[] vehicleImages={R.drawable.scooter,R.drawable.car,R.drawable.bus,R.drawable.deliverytruck};
    Spinner depovehicletype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depo);
        scan=findViewById(R.id.startscan2);
        depovehicletype=findViewById(R.id.depovehicletypespinner);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Depo.this,BreakageActivity.class);
                startActivity(i);
            }
        });
        CustomAdapter adapter=new CustomAdapter(Depo.this,vehicleImages,vehicletype);
        depovehicletype.setAdapter(adapter);
        depovehicletype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
