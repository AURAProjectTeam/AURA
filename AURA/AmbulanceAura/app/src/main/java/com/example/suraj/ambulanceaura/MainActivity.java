package com.example.suraj.ambulanceaura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addAmbulance,searchHospital,removeAmbulance,ecgreports,login;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAmbulance=(Button)findViewById(R.id.AddAmbulance);
        searchHospital=(Button)findViewById(R.id.SearchHospital);
        removeAmbulance=(Button)findViewById(R.id.RemoveAmbulance);
        ecgreports=(Button)findViewById(R.id.send_ecg_reports);

        addAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addAmb=new Intent(getApplicationContext(),AddAmbulance.class);
                startActivity(addAmb);
            }
        });
        searchHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchHosp=new Intent(getApplicationContext(),SearchHospital.class);
                startActivity(searchHosp);
            }
        });
        removeAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent remAmb=new Intent(getApplicationContext(),RemoveAmbulance.class);
                startActivity(remAmb);
            }
        });
        ecgreports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ecgrep=new Intent(getApplicationContext(),FirebaseLogin.class);
                startActivity(ecgrep);
            }
        });

    }
}
