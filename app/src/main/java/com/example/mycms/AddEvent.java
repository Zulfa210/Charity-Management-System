package com.example.mycms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddEvent extends AppCompatActivity {

    String enName;
    EditText eName, eDesc, eDate, eTime, eAddress;
    Button saveEvent;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        db = FirebaseDatabase.getInstance();
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
                String ename=eName.getText().toString();
                String edesc= eDesc.getText().toString();
                String edate= eDate.getText().toString();
                String etime= eTime.getText().toString();
                String eaddress= eAddress.getText().toString();
                addEvent( ename, edesc,edate, etime, eaddress);
            }
        });



    }

    public boolean addEvent( String ename,String edesc, String edate, String etime, String eaddress) {

        checkEvent(ename, edesc,edate, etime, eaddress);

        if(ename.isEmpty()){
            eName.setError("Event Name is Required");
            eName.requestFocus();
            return false;
        }

        if(edate.isEmpty()){
            eDate.setError("Date is Required");
            eDate.requestFocus();
            return false;
        }

        if(etime.isEmpty()){
            eTime.setError("Time is Required");
            eTime.requestFocus();
            return false;
        }

        if(eaddress.isEmpty()){
            eAddress.setError("Address is Required");
            eAddress.requestFocus();
            return false;
        }

        if(edate.length() != 10){
            eDate.setError("Enter Date in dd-mm-yyyy format");
            eDate.requestFocus();
            return false;
        }




        Map<String,Object> map1 = new HashMap<>();

        map1.put("NgoName", enName);
        map1.put("EventName", ename);
        map1.put("EventDescription", edesc);
        map1.put("Date", edate);
        map1.put("Time", etime);
        map1.put("Address",eaddress);

        db.getReference().child("Events").push()
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

        return true;
    }

    public boolean checkEvent( String ename,String edesc, String edate, String etime, String eaddress) {


        if(ename.isEmpty()){

            return false;
        }

        if(edate.isEmpty()){

            return false;
        }

        if(etime.isEmpty()){

            return false;
        }

        if(eaddress.isEmpty()){

            return false;
        }

        if(edate.length() != 10){

            return false;
        }



        return true;
    }
}