package com.example.mycms;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ntab2 extends Fragment {

    private View listView;
    private RecyclerView mylist;
    FirebaseAuth mauth;
    String currentId;
    private DatabaseReference ngoListRef;
    NgoViewAdapter adapter;

    public Ntab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        listView =inflater.inflate(R.layout.fragment_ntab2, container, false);
        mylist = (RecyclerView) listView.findViewById(R.id.NngoView);

        mylist.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<NgoUser>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("NGOs"), NgoUser.class)
                .build();


        adapter = new NgoViewAdapter(options);
        mylist.setAdapter(adapter);
        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
//
        adapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
