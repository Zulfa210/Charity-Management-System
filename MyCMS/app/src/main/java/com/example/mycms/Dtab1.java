package com.example.mycms;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
=======

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac


public class Dtab1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

<<<<<<< HEAD

    View eventView;
    RecyclerView eventlist;
    FirebaseAuth Eauth;
    String currentId;
    FirebaseUser nevent;
    private DatabaseReference eventListRef;
    DonorEventsAdapter deventAdapter;
    FloatingActionButton addEvent;
    String ngoName;
=======
    private View listView;
    private RecyclerView mylist;
    FirebaseAuth mauth;
    String currentId;
    private DatabaseReference ngoListRef;
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac

    public Dtab1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        eventView =inflater.inflate(R.layout.fragment_dtab1, container, false);
        eventlist = (RecyclerView) eventView.findViewById(R.id.rv_d1);

        eventlist.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions events = new FirebaseRecyclerOptions.Builder<Events>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Events"),Events.class)
                .build();


        deventAdapter = new DonorEventsAdapter(events);
        eventlist.setAdapter(deventAdapter);


//        nevent = FirebaseAuth.getInstance().getCurrentUser();
//        currentId = nevent.getUid();
//        FirebaseDatabase.getInstance().getReference("NGOs").child(currentId).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                NgoUser ngoprofile = snapshot.getValue(NgoUser.class);
//                if (ngoprofile!=null){
//                    ngoName = ngoprofile.name;
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getActivity(), "Something Wrong Happened!", Toast.LENGTH_LONG).show();
//            }
//        });


        return eventView;
    }


=======
        listView =inflater.inflate(R.layout.fragment_dtab1, container, false);
        mylist = (RecyclerView) listView.findViewById(R.id.rv_d1);
        mylist.setLayoutManager(new LinearLayoutManager(getContext()));


        mauth = FirebaseAuth.getInstance();
        currentId = mauth.getCurrentUser().getUid();
        ngoListRef = FirebaseDatabase.getInstance().getReference().child("NGOs").child(currentId);

        return listView;
    }

>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
    @Override
    public void onStart() {
        super.onStart();

<<<<<<< HEAD
        deventAdapter.startListening();


    }

    @Override
    public void onStop() {
        super.onStop();
        deventAdapter.stopListening();
    }


=======



    }
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
}