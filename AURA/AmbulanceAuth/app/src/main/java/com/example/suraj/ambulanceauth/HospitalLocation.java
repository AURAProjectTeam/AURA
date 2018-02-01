package com.example.suraj.ambulanceauth;

/**
 * Created by Suraj on 18-12-2017.
 */

public class HospitalLocation {
    double lat,lang;
    String id;
    HospitalLocation(){}
    HospitalLocation(String id,double l1,double l2){
        this.lat=l1;
        this.lang=l2;
    }

    public double getLang() {
        return lang;
    }

    public double getLat() {
        return lat;
    }

    public String getId() {
        return id;
    }
}
