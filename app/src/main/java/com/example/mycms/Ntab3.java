package com.example.mycms;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Ntab3 extends Fragment {

    Button nlogOut, nAppoint;
    TextView Nname, NfullName, Nemail, Nphone, Naddress, Nregno, NupiId;
    String name;

    public Ntab3() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.fragment_ntab3, container, false);

        Nname = (TextView) myview.findViewById(R.id.NNamedis);
        NfullName= (TextView) myview.findViewById(R.id.NPersonNamedis);
        Nemail = (TextView) myview.findViewById(R.id.NEmaildis);
        Nphone = (TextView) myview.findViewById(R.id.NPhonedis);
        Naddress = (TextView) myview.findViewById(R.id.NAddressdis);
        Nregno = (TextView) myview.findViewById(R.id.NRefdis);
        NupiId = (TextView) myview.findViewById(R.id.Nupidis);
        nAppoint =(Button) myview.findViewById(R.id.ngoAppoint);

        FirebaseUser NAuth;
        FirebaseFirestore NStore;
        String ngoId;
        NAuth = FirebaseAuth.getInstance().getCurrentUser();
        NStore = FirebaseFirestore.getInstance();

        ngoId = NAuth.getUid();
        DocumentReference Ndf = NStore.collection("NGOs").document(ngoId);

        Ndf.get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.getResult().exists()) {


                            name = task.getResult().getString("NGO_name");
                            String person = task.getResult().getString("FullName");
                            String email = task.getResult().getString("EmailId");
                            String phone = task.getResult().getString("PhoneNo");
                            String address = task.getResult().getString("Address");
                            String regno = task.getResult().getString("RegNo");
                            String upi = task.getResult().getString("Upi_Id");

                            Nname.setText(name);
                            NfullName.setText(person);
                            Nemail.setText(email);
                            Nphone.setText(phone);
                            Naddress.setText(address);
                            Nregno.setText(regno);
                            NupiId.setText(upi);

                        }else {
                            Toast.makeText(getActivity(), "No Data Found",Toast.LENGTH_LONG).show();
                        }

                    }
                });
        nAppoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(getActivity(), ngoAppointments.class);
                i2.putExtra("NgoName",name);
                startActivity(i2);
            }
        });
//
//        NAuth = FirebaseAuth.getInstance().getCurrentUser();
//        NStore = FirebaseFirestore.getInstance();
//
//        ngoId = NAuth.getUid();
//        DocumentReference Ndf = NStore.collection("NGOs").document(ngoId);
//
//        Ndf.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//
//                Nname.setText(value.getString("NGO_name"));
//                NfullName.setText(value.getString("FullName"));
//                Nphone.setText(value.getString("PhoneNo"));
//                Naddress.setText(value.getString("Address"));
//                Nregno.setText(value.getString("RegNo"));
//                NupiId.setText(value.getString("Upi_Id"));
//
//            }
//        });


        nlogOut = (Button) myview.findViewById(R.id.NLogOut);
        nlogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), MainActivity.class));

            }
        });
        // Inflate the layout for this fragment
        return myview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Nname = getActivity().findViewById(R.id.NNamedis);
//        NfullName=  getActivity().findViewById(R.id.NPersonNamedis);
//        Nemail = getActivity().findViewById(R.id.NEmaildis);
//        Nphone =  getActivity().findViewById(R.id.NPhonedis);
//        Naddress =  getActivity().findViewById(R.id.NAddressdis);
//        Nregno =  getActivity().findViewById(R.id.NRefdis);
//        NupiId =  getActivity().findViewById(R.id.Nupidis);
    }

    @Override
    public void onStart() {
        super.onStart();




    }
}