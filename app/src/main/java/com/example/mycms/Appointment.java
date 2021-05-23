package com.example.mycms;

public class Appointment {

    String Date;
    String Name;
    String Ngo_Name;
    String PhoneNo;
    String Time;
    String Type;


    public Appointment() {
    }

    public Appointment(String date, String name, String ngoname, String phone,String time, String type) {
        this.Date = date;
        this.Name = name;
        this.Ngo_Name = ngoname;
        this.PhoneNo = phone;
        this.Time = time;
        this.Type = type;

    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNgo_Name() {
        return Ngo_Name;
    }

    public void setNgo_Name(String ngo_Name) {
        Ngo_Name = ngo_Name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }






}
