package com.example.mycms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class donorAppointments extends AppCompatActivity {

    String donorname;
    private View appView;
    RecyclerView appoints;
    FirebaseAuth mauth;
    String currentId;
    private DatabaseReference ngoListRef;
    DonorAppointAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_appointments);

        donorname = getIntent().getExtras().get("DonorName").toString();
        appoints =(RecyclerView) findViewById(R.id.donorAppView);
        appoints.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Appointment> option =
                new FirebaseRecyclerOptions.Builder<Appointment>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child(donorname), Appointment.class)
                        .build();

        adapter = new DonorAppointAdapter(option);
        appoints.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}