package com.example.mycms;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
=======
import android.os.Bundle;

import androidx.fragment.app.Fragment;
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
=======
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac

public class Ntab1 extends Fragment {



<<<<<<< HEAD
    View eventView;
    RecyclerView eventlist;
    FirebaseAuth Eauth;
    String currentId;
    FirebaseUser nevent;
    private DatabaseReference eventListRef;
    EventViewAdapter eventAdapter;
    FloatingActionButton addEvent;
    String ngoName;
=======
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
    public Ntab1() {
        // Required empty public constructor
    }



<<<<<<< HEAD

=======
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD

       eventView =inflater.inflate(R.layout.fragment_ntab1, container, false);

        eventlist = (RecyclerView) eventView.findViewById(R.id.ngoEventView);

        eventlist.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions events = new FirebaseRecyclerOptions.Builder<Events>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Events"),Events.class)
                .build();


        eventAdapter = new EventViewAdapter(events);
        eventlist.setAdapter(eventAdapter);


        nevent = FirebaseAuth.getInstance().getCurrentUser();
        currentId = nevent.getUid();
        FirebaseDatabase.getInstance().getReference("NGOs").child(currentId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                NgoUser ngoprofile = snapshot.getValue(NgoUser.class);
                if (ngoprofile!=null){
                    ngoName = ngoprofile.name;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something Wrong Happened!", Toast.LENGTH_LONG).show();
            }
        });
        addEvent = eventView.findViewById(R.id.AddEventButton);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(getActivity(),AddEvent.class);
                int1.putExtra("Ngo_name",ngoName);
                startActivity(int1);
            }
        });

        return eventView;
    }

    @Override
    public void onStart() {
        super.onStart();
        eventAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        eventAdapter.stopListening();
=======
        return inflater.inflate(R.layout.fragment_ntab1, container, false);
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
    }
}