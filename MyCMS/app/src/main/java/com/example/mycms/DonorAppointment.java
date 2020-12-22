package com.example.mycms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class DonorAppointment extends AppCompatActivity {

    String Ngoname;
    TextView Donorname, date, time, Donorphone;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_appointment);



        Ngoname = getIntent().getExtras().get("NgoName").toString();

        Donorname= (EditText)findViewById(R.id.ApppointName);
        Donorphone = (EditText) findViewById(R.id.AppointPhone);
        date  = (EditText) findViewById(R.id.AppointDate);
        time = (EditText) findViewById(R.id.AppointTime);
        submit = (Button) findViewById(R.id.SaveAppoint);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAppointment();
            }
        });

    }

    private void addAppointment() {

        FirebaseDatabase db;

        Map<String,Object> map = new HashMap<>();

        map.put("Ngo_Name", Ngoname);
        map.put("Name", Donorname.getText().toString());
        map.put("PhoneNo", Donorphone.getText().toString());
        map.put("Date", date.getText().toString());
        map.put("Time", time.getText().toString());
        map.put("Type", "Donor_Appointment");

        FirebaseDatabase.getInstance().getReference().child(Ngoname).push()
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
    }
}