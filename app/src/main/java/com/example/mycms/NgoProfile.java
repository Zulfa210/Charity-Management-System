package com.example.mycms;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NgoProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NgoProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    String address;
    String email;
    String name;
    String person;
    String phone;
    String reg;
    String status;
    String upi;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NgoProfile() {
        // Required empty public constructor
    }

    public NgoProfile( String name,String person,String phone,String email, String address,
            String reg, String upi,
            String status
            ) {

        this.name = name;
        this.person = person;
        this.address= address;
        this.email = email;
        this.phone=phone;
        this.reg = reg;
        this.upi=upi;
        this.status=status;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NgoProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static NgoProfile newInstance(String param1, String param2) {
        NgoProfile fragment = new NgoProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ngo_profile, container, false);

        ImageView imageHolder = view.findViewById(R.id.imageView);
        TextView Pname = view.findViewById(R.id.ProfileName);
        TextView Pperson = view.findViewById(R.id.ProfilePerson);
        TextView Pemail = view.findViewById(R.id.ProfileEmail_);
        TextView Pphone = view.findViewById(R.id.ProfilePhoneno);
        TextView Paddress = view.findViewById(R.id.ProfileAddress);
        TextView Preg = view.findViewById(R.id.ProfileReg);
        TextView Pupi = view.findViewById(R.id.ProfileUpi);
        TextView Pstatus = view.findViewById(R.id.ProfileStatus);

        Pname.setText(name);
        Pperson.setText(person);
        Pemail.setText(email);
        Pphone.setText(phone);
        Paddress.setText(address);
        Preg.setText(reg);
        Pupi.setText(upi);
        Pstatus.setText(status);

        Button Appoint = (Button) view.findViewById(R.id.Appointmentbutton);
        Appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), DonorAppointment.class);
                in.putExtra("NgoName", name);
                in.putExtra("NgoAddress",address);
                startActivity(in);
            }
        });
        return view;
    }
    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity) getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.profile, new Dtab1()).addToBackStack(null).commit();

    }
}