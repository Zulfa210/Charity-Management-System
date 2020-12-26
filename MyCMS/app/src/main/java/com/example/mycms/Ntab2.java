package com.example.mycms;

import android.os.Bundle;

<<<<<<< HEAD
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
=======
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
<<<<<<< HEAD
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class Ntab2 extends Fragment {



//    private View appView;
//    private RecyclerView appointlist;
//    FirebaseAuth mauth;
//    FirebaseUser ngoApp;
//    String currentId;
//    DatabaseReference ngoListRef;
//    AppointViewAdapter Aadapter;
//    String ngoName;
//    FirebaseFirestore nStore;
//    NgoUser ngo;

=======
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ntab2 extends Fragment {

>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
    private View listView;
    private RecyclerView mylist;
    FirebaseAuth mauth;
    String currentId;
    private DatabaseReference ngoListRef;
    NgoViewAdapter adapter;
<<<<<<< HEAD
=======

>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
    public Ntab2() {
        // Required empty public constructor
    }

<<<<<<< HEAD
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

=======
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

<<<<<<< HEAD


//        appView =inflater.inflate(R.layout.fragment_ntab2, container, false);
//
//
//        appointlist = (RecyclerView) appView.findViewById(R.id.NngoView);
//        appointlist.setLayoutManager(new LinearLayoutManager(getContext()));
//
//
//        ngoApp = FirebaseAuth.getInstance().getCurrentUser();
//        currentId = ngoApp.getUid();

//
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


       // ngoName = ngo.getName();
        //ngoListRef = FirebaseDatabase.getInstance().getReference().child("Appointments").orderByChild("Ngo_name").startAt();
//        return appView;
=======
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
        listView =inflater.inflate(R.layout.fragment_ntab2, container, false);
        mylist = (RecyclerView) listView.findViewById(R.id.NngoView);

        mylist.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<NgoUser>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("NGOs"), NgoUser.class)
                .build();


        adapter = new NgoViewAdapter(options);
        mylist.setAdapter(adapter);
<<<<<<< HEAD

        Toolbar toolbar = (Toolbar) listView.findViewById(R.id.search);

        setHasOptionsMenu(true);

=======
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
<<<<<<< HEAD

//        FirebaseRecyclerOptions Options = new FirebaseRecyclerOptions.Builder<Appointment>()
//                .setQuery(ngoListRef, Appointment.class)
//                .build();
//
//        Aadapter = new AppointViewAdapter(Options);
//        appointlist.setAdapter(Aadapter);
        adapter.startListening();


=======
//
        adapter.startListening();

>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
<<<<<<< HEAD

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.searchmenu,menu);

        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView= (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                processSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                processSearch(newText);
                return false;
            }
        });
    }

    private void processSearch(String s) {

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<NgoUser>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("NGOs").orderByChild("name").startAt(s).endAt(s+"\uf8ff"), NgoUser.class)
                .build();

        adapter = new NgoViewAdapter(options);
        adapter.startListening();
        mylist.setAdapter(adapter);
    }

=======
>>>>>>> bdada2eb2555330876dcfa4b3202e3970179b0ac
}
