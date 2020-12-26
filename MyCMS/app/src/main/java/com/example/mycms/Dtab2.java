package com.example.mycms;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Dtab2 extends Fragment {

//    private SearchView searchView = null;
//    private SearchView.OnQueryTextListener queryTextListener;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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

        Toolbar toolbar = (Toolbar) listView.findViewById(R.id.search);

        setHasOptionsMenu(true);

//        mauth = FirebaseAuth.getInstance();
//        currentId = mauth.getCurrentUser().getUid();
//        ngoListRef = FirebaseDatabase.getInstance().getReference().child("NGOs").child(currentId);
        return listView;
    }




    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

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

}