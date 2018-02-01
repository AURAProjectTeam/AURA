package com.example.suraj.ambulanceauth;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddHospital extends Activity implements LocationListener {
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    String lat;
    String provider;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;
    FirebaseDatabase database;
    DatabaseReference reference;
    GeoFire geoFire;
    CheckBox c1,c2,c3,c4,c5,c6;
    HospitalLocation hosloc;
    Button submit;
    EditText id,name;
    HospitalDatabase hd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hospital);
        c1=(CheckBox)findViewById(R.id.Accident);
        c2=(CheckBox)findViewById(R.id.Poisining);
        c3=(CheckBox)findViewById(R.id.DrugOverdose);
        c4=(CheckBox)findViewById(R.id.Cardiac_Arrrest);
        c5=(CheckBox)findViewById(R.id.Shock);
        c6=(CheckBox)findViewById(R.id.Asthma);
        submit=(Button)findViewById(R.id.Submit);
        id=(EditText)findViewById(R.id.HospitalID);
        name=(EditText)findViewById(R.id.HospitalName);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("path/to/ALLHospital");
        geoFire = new GeoFire(reference);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 1, this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    reference = database.getReference("path/to/ALLHospital/Accident");
                    geoFire = new GeoFire(reference);
                    geoFire.setLocation("firebase-accident", new GeoLocation(hosloc.lat, hosloc.lang));
                }
                if(c2.isChecked()){
                    reference = database.getReference("path/to/ALLHospital/Poisoning");
                    geoFire = new GeoFire(reference);
                    geoFire.setLocation("firebase-poision", new GeoLocation(hosloc.lat, hosloc.lang));
                }
                if(c3.isChecked()){
                    reference = database.getReference("path/to/ALLHospital/Drug_overdose");
                    geoFire = new GeoFire(reference);
                    geoFire.setLocation("firebase-Drug", new GeoLocation(hosloc.lat, hosloc.lang));
                }
                if(c4.isChecked()){
                    reference = database.getReference("path/to/ALLHospital/Cardiac_Arrest");
                    geoFire = new GeoFire(reference);
                    geoFire.setLocation("firebase-Cardiac", new GeoLocation(hosloc.lat, hosloc.lang));
                }
                if(c5.isChecked()){
                    reference = database.getReference("path/to/ALLHospital/Shock");
                    geoFire = new GeoFire(reference);
                    geoFire.setLocation("firebase-Shock", new GeoLocation(hosloc.lat, hosloc.lang));
                }
                if(c6.isChecked()){
                    reference = database.getReference("path/to/ALLHospital/Asthma");
                    geoFire = new GeoFire(reference);
                    geoFire.setLocation("firebase-Asthma", new GeoLocation(hosloc.lat, hosloc.lang));
                }
                hd=new HospitalDatabase(id.getText().toString(),name.getText().toString());
                reference = database.getReference("path/to/ALLHospital");
                geoFire = new GeoFire(reference);
                reference.child("hospitals").setValue(hd);

            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        txtLat = (TextView) findViewById(R.id.innitloc);
        txtLat.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
        hosloc = new HospitalLocation("001",location.getLatitude(), location.getLongitude());
        geoFire.setLocation("firebase-hq", new GeoLocation(hosloc.lat, hosloc.lang));
        //Toast.makeText(AddHospital.this, "GPS Provider update", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude", "disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude", "enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude", "status");
    }
}
