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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Dtab1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private View listView;
    private RecyclerView mylist;
    FirebaseAuth mauth;
    String currentId;
    private DatabaseReference ngoListRef;

    public Dtab1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listView =inflater.inflate(R.layout.fragment_dtab1, container, false);
        mylist = (RecyclerView) listView.findViewById(R.id.rv_d1);
        mylist.setLayoutManager(new LinearLayoutManager(getContext()));


        mauth = FirebaseAuth.getInstance();
        currentId = mauth.getCurrentUser().getUid();
        ngoListRef = FirebaseDatabase.getInstance().getReference().child("NGOs").child(currentId);

        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();




    }
}