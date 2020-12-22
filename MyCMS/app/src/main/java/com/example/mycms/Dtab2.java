package com.example.mycms;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Dtab2 extends Fragment {


    private View listView;
    private RecyclerView mylist;
    FirebaseAuth mauth;
    String currentId;
    private DatabaseReference ngoListRef;
    NgoViewAdapter adapter;
    public Dtab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        listView =inflater.inflate(R.layout.fragment_dtab2, container, false);
        mylist = (RecyclerView) listView.findViewById(R.id.ngoView);

        mylist.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<NgoUser>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("NGOs"), NgoUser.class)
                .build();


        adapter = new NgoViewAdapter(options);
        mylist.setAdapter(adapter);
//        mauth = FirebaseAuth.getInstance();
//        currentId = mauth.getCurrentUser().getUid();
//        ngoListRef = FirebaseDatabase.getInstance().getReference().child("NGOs").child(currentId);
        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
//        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<NgoUser>()
//                .setQuery(ngoListRef, NgoUser.class)
//                .build();
//
//        FirebaseRecyclerAdapter<NgoUser, Viewholder_Ngo> adapter
//                = new FirebaseRecyclerAdapter<NgoUser, Viewholder_Ngo>() {
//            @Override
//            protected void onBindViewHolder(@NonNull Viewholder_Ngo holder, int position, @NonNull NgoUser model) {
//
//            }
//
//            @NonNull
//            @Override
//            public Viewholder_Ngo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ngo_item, parent, false);
//                Viewholder_Ngo viewHold = new Viewholder_Ngo(view);
//
//                return viewHold;
//
//            }
//        };
        adapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}