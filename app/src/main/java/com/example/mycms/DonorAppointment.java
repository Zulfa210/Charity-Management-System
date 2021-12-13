package com.example.mycms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DonorAppointment extends AppCompatActivity {

    String Ngoname, NgoAdd;
    TextView Donorname, date, time, Donorphone;
    Button submit;

    FirebaseDatabase db1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_appointment);


        db1 = FirebaseDatabase.getInstance();
        Ngoname = getIntent().getExtras().get("NgoName").toString();
        NgoAdd = getIntent().getExtras().get("NgoAddress").toString();

        Donorname= (EditText)findViewById(R.id.ApppointName);
        Donorphone = (EditText) findViewById(R.id.AppointPhone);
        date  = (EditText) findViewById(R.id.AppointDate);
        time = (EditText) findViewById(R.id.AppointTime);
        submit = (Button) findViewById(R.id.SaveAppoint);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String donorname= Donorname.getText().toString();
                String donorphone= Donorphone.getText().toString();
                String ddate= date.getText().toString();
                String dtime=time.getText().toString();
                addAppointment( donorname,  donorphone,  ddate,  dtime);
            }
        });

    }

    protected boolean addAppointment(String donorname, String donorphone, String ddate, String dtime) {


        checkAppointment( donorname,  donorphone,  ddate,  dtime);
        if(donorname.isEmpty()){
            Donorname.setError("Name is Required");
            Donorname.requestFocus();
            return false;
        }

        if(donorphone.isEmpty()){
            Donorphone.setError("Phone no. is Required");
            Donorphone.requestFocus();
            return false;
        }

        if(ddate.isEmpty()){
            date.setError("Date is Required");
            date.requestFocus();
            return false;
        }

        if(dtime.isEmpty()){
            time.setError("Time is Required");
            time.requestFocus();
            return false;
        }

        if(donorphone.length() != 10){
            Donorphone.setError("Phone no. is invalid");
            Donorphone.requestFocus();
            return false;
        }



        Map<String,Object> map = new HashMap<>();

        map.put("Ngo_Name", Ngoname);
        map.put("Name", donorname);
        map.put("PhoneNo", donorphone);
        map.put("Date", ddate);
        map.put("Time", dtime);
        map.put("Type", "Donor_Appointment");

        db1.getReference().child(Ngoname).push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Donorname.setText("");
                        Donorphone.setText("");
                        date.setText("");
                        time.setText("");
                        Toast.makeText(getApplicationContext(), "Appointment Added",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(DonorAppointment.this, DonorDashboard.class));

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Appointment Added",Toast.LENGTH_LONG).show();
                    }
                });

        Map<String,Object> map2 = new HashMap<>();

        map2.put("Ngo_Name", Ngoname);
        map2.put("Name", Donorname.getText().toString());
        map2.put("PhoneNo", Donorphone.getText().toString());
        map2.put("Date", date.getText().toString());
        map2.put("Time", time.getText().toString());
        map2.put("Type", "Donor_Appointment");
      //  map2.put("Address", NgoAdd);
        FirebaseDatabase.getInstance().getReference().child(Donorname.getText().toString()).push()
                .setValue(map2);

        return true;
    }

    public boolean checkAppointment(String donorname, String donorphone, String ddate, String dtime) {


        if(donorname.isEmpty()){
            return false;
        }

        if(donorphone.isEmpty()){
            return false;
        }

        if(ddate.isEmpty()){
            return false;
        }

        if(dtime.isEmpty()){
            return false;
        }

        if(donorphone.length() != 10){
            return false;
        }

        return true;
    }
}