package com.example.mycms;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.DragStartHelper;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;

import java.util.concurrent.Executor;

public class Dtab3 extends Fragment {


    Button dlogOut;
    TextView DfullName, Demail, Dphone;

    String FullName;
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userId;

    private Button logout, dAppoint;

    public Dtab3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_dtab3, container, false);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Donors");
        userId = user.getUid();


        dAppoint = (Button) myView.findViewById(R.id.donorAppoint);
        final TextView fullNameTextView = (TextView) myView.findViewById(R.id.DNamedis);
        final TextView emailTextView = (TextView) myView.findViewById(R.id.DEmaildis);
        final TextView phoneTextView = (TextView) myView.findViewById(R.id.DPhonedis);

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DonorUser userProfile = snapshot.getValue(DonorUser.class);

                if(userProfile!= null){
                    FullName = userProfile.name;
                    String Email = userProfile.email;
                    String Phone = userProfile.Phone;

                    fullNameTextView.setText(FullName);
                    emailTextView.setText(Email);
                    phoneTextView.setText(Phone);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something Wrong Happened!", Toast.LENGTH_LONG).show();
            }
        });


        dAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(getActivity(), donorAppointments.class);
                i2.putExtra("DonorName",FullName);
                startActivity(i2);
            }
        });


                dlogOut = (Button) myView.findViewById(R.id.DLogOut);
        dlogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), MainActivity.class));

            }
        });
        return myView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onStart() {
        super.onStart();

//        FirebaseUser DAuth;
//        FirebaseFirestore DStore;
//        String donorId;
//        DAuth = FirebaseAuth.getInstance().getCurrentUser();
//        DStore = FirebaseFirestore.getInstance();
//
//        donorId = DAuth.getUid();
//        DocumentReference Ddf = DStore.collection("Donors").document(donorId);
//
//        Ddf.get()
//                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        if(task.getResult().exists()) {
//
//                            String person = task.getResult().getString("FullName");
//                            String email = task.getResult().getString("EmailId");
//                            String phone = task.getResult().getString("PhoneNo");
//
//
//                            DfullName.setText(person);
//                            Demail.setText(email);
//                            Dphone.setText(phone);
//                        }else{
//                            Toast.makeText(getActivity(),"NoDataFound",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
    }
}