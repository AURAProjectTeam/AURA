package com.example.suraj.ambulanceaura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchHospital extends AppCompatActivity {

    Button search;
    EditText e1,e2;
    Spinner s1;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hospital);
        search=(Button)findViewById(R.id.searchhosp);
        e1=(EditText)findViewById(R.id.PatientName);
        s1=(Spinner)findViewById(R.id.hospitalSpec);
        e2=(EditText)findViewById(R.id.PatientDetail);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("Hospital/Database");

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = e1.getText().toString();
                final String Criteria1=s1.getSelectedItem().toString();
                final String PatientDet=e2.getText().toString();
                if (!isValidName(name)) {
                    e1.setError("Invalid Password");
                }
                PatientCriteria p1=new PatientCriteria(name,Criteria1,PatientDet);
                reference.child("user").setValue(p1);
                Intent searchhospital1=new Intent(getApplicationContext(),HospitalMap.class);
                startActivity(searchhospital1);
            }
        });

    }
    private boolean isValidName(String name) {
        if (name != null && name.length() > 4) {
            return true;
        }
        return false;
    }
}
