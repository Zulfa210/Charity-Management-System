package com.example.mycms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ngoAppointments extends AppCompatActivity {

    String ngoname;
    private View appView;
    private RecyclerView appoints;
    FirebaseAuth mauth;
    String currentId;
    private DatabaseReference ngoListRef;
    AppointViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_appointments);

        ngoname = getIntent().getExtras().get("NgoName").toString();
        appoints =(RecyclerView) findViewById(R.id.appointView);
        appoints.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Appointment> opt =
                new FirebaseRecyclerOptions.Builder<Appointment>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child(ngoname), Appointment.class)
                .build();

        adapter = new AppointViewAdapter(opt);
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