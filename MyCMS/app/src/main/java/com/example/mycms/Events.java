package com.example.mycms;

public class Events {

    String  Address;
    String Date;
    String EventDescription;
    String EventName;
    String NgoName;
    String Time;

    public Events(String address, String date, String eventdescription, String eventname, String ngoName, String time) {
        Address = address;
        Date = date;
        EventDescription = eventdescription;
        EventName = eventname;
        NgoName = ngoName;
        Time = time;
    }


    public Events() {
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEventdescription() {
        return EventDescription;
    }

    public void setEventdescription(String eventdescription) {
        EventDescription = eventdescription;
    }

    public String getEventname() {
        return EventName;
    }

    public void setEventname(String eventname) {
        EventName = eventname;
    }

    public String getNgoName() {
        return NgoName;
    }

    public void setNgoName(String ngoName) {
        NgoName = ngoName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }











}
