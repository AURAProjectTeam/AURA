package com.example.suraj.ambulanceaura;

/**
 * Created by Suraj on 02-12-2017.
 */

public class AmbulanceLocation {
    double lat=000,lang=0000;
    String name,id,vehicleno,mobno;
    AmbulanceLocation(double l1,double l2)
    {
        this.lat=l1;
        this.lang=l2;
    }
    AmbulanceLocation(String n,String id,String v,String m,double l1,double l2){
        this.name=n;
        this.id=id;
        this.vehicleno=v;
        this.mobno=m;
    }
}
