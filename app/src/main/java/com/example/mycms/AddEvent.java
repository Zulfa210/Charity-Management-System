package com.example.mycms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddEvent extends AppCompatActivity {

    String enName;
    EditText eName, eDesc, eDate, eTime, eAddress;
    Button saveEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        enName = getIntent().getExtras().get("Ngo_name").toString();
        eName = (EditText)findViewById(R.id.EventName);
        eDesc = (EditText)findViewById(R.id.EventDesc);
        eDate = (EditText)findViewById(R.id.EventDate);
        eTime = (EditText)findViewById(R.id.EventTime);
        eAddress = (EditText)findViewById(R.id.EventAddress);

        saveEvent = (Button) findViewById(R.id.SaveEvent);
        saveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });



    }

    private void addEvent() {

        FirebaseDatabase db;

        Map<String,Object> map1 = new HashMap<>();

        map1.put("NgoName", enName);
        map1.put("EventName", eName.getText().toString());
        map1.put("EventDescription", eDesc.getText().toString());
        map1.put("Date", eDate.getText().toString());
        map1.put("Time", eTime.getText().toString());
        map1.put("Address",eAddress.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Events").push()
                .setValue(map1)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        eName.setText("");
                        eDesc.setText("");
                        eDate.setText("");
                        eTime.setText("");
                        eAddress.setText("");
                        Toast.makeText(getApplicationContext(), "Event Added",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(AddEvent.this, NgoDashboard.class));

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Failed",Toast.LENGTH_LONG).show();
                    }
                });
    }
}