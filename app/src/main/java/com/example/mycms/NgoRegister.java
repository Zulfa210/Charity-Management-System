package com.example.mycms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NgoRegister extends AppCompatActivity  {

    private TextView register_ngo, NloginBanner;
    private EditText editTextNgoName, editTextNgoEmail, editTextNgoPhone,editTextNgoPassword, editTextNgoPersonName, editTextNgoAddress, editTextNgoNo, editTextNgoUpi;

    FirebaseAuth nAuth;
    FirebaseFirestore nStore;
    FirebaseDatabase rDatabase = FirebaseDatabase.getInstance();
    NgoUser member;
    String currentId;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_register);

        editTextNgoName = (EditText) findViewById(R.id.NgoName);
        editTextNgoPersonName = (EditText) findViewById(R.id.NPersonName);
        editTextNgoEmail = (EditText) findViewById(R.id.NEmailAddress);
        editTextNgoPhone = (EditText) findViewById(R.id.NPhone);
        editTextNgoAddress = (EditText) findViewById(R.id.NPostalAddress);
        editTextNgoPassword = (EditText) findViewById(R.id.NPassword);
        editTextNgoNo = (EditText) findViewById(R.id.NRefNo);
        editTextNgoUpi = (EditText) findViewById(R.id.NupiId);

        register_ngo = (Button) findViewById(R.id.Nregister);
        register_ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNgo();
            }
        });

        NloginBanner = (TextView) findViewById(R.id.NgoBanner);
        NloginBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NgoRegister.this, NgoLogin.class));

            }
        });

        member = new NgoUser();
        nAuth = FirebaseAuth.getInstance();
        nStore = FirebaseFirestore.getInstance();


    }


    private void registerNgo() {

        String Nemail= editTextNgoEmail.getText().toString().trim();
        String NfullName= editTextNgoPersonName.getText().toString().trim();
        String Nphone= editTextNgoPhone.getText().toString().trim();
        String Npassword= editTextNgoPassword.getText().toString().trim();
        String Nname = editTextNgoName.getText().toString().trim();
        String Nref = editTextNgoNo.getText().toString().trim();
        String Nupi = editTextNgoUpi.getText().toString().trim();
        String Naddress = editTextNgoAddress.getText().toString().trim();

        if(Nname.isEmpty()){
            editTextNgoName.setError("NGO Name is Required");
            editTextNgoName.requestFocus();
            return;
        }

        if(NfullName.isEmpty()){
            editTextNgoPersonName.setError("Full Name is Required");
            editTextNgoPersonName.requestFocus();
            return;
        }

        if(Nemail.isEmpty()){
            editTextNgoEmail.setError("Email is Required");
            editTextNgoEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Nemail).matches()){
            editTextNgoEmail.setError("Email is Invalid");
            editTextNgoEmail.requestFocus();
            return;
        }
        if(Nphone.isEmpty()){
            editTextNgoPhone.setError("Phone no. is Required");
            editTextNgoPhone.requestFocus();
            return;
        }

        if(Naddress.isEmpty()){
            editTextNgoAddress.setError("Address is Required");
            editTextNgoAddress.requestFocus();
            return;
        }

        if(Nref.isEmpty()){
            editTextNgoNo.setError("Government Reg no. is Required");
            editTextNgoNo.requestFocus();
            return;
        }

//        if(Nupi.isEmpty()){
//            editTextNgoUpi.setError("Government Reg no. is Required");
//            editTextNgoUpi.requestFocus();
//            return;
//        }

        if(Npassword.isEmpty()){
            editTextNgoPassword.setError("Password is Required");
            editTextNgoPassword.requestFocus();
            return;
        }

        if(Npassword.length() < 6) {
            editTextNgoPassword.setError("Enter Password >=6");
            editTextNgoPassword.requestFocus();
            return;

        }

        nAuth.createUserWithEmailAndPassword(Nemail, Npassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    FirebaseUser nUser = FirebaseAuth.getInstance().getCurrentUser();
                    currentId = nUser.getUid();

                    databaseReference = rDatabase.getReference("NGOs");

                    DocumentReference df = nStore.collection("NGOs").document(currentId);
                    Map<String, Object> ngoInfo = new HashMap<>();
                    ngoInfo.put("NGO_name", Nname);
                    ngoInfo.put("FullName", NfullName);
                    ngoInfo.put("EmailId", Nemail);
                    ngoInfo.put("PhoneNo", Nphone);
                    ngoInfo.put("Address", Naddress);
                    ngoInfo.put("RegNo", Nref);
                    ngoInfo.put("Upi_Id", Nupi);

                    ngoInfo.put("Role", "NGO");
                    ngoInfo.put("Status", "Not Verified");


                    member.setName(Nname);
                    member.setPerson(NfullName);
                    member.setEmail(Nemail);
                    member.setPhone(Nphone);
                    member.setAddress(Naddress);
                    member.setReg(Nref);
                    member.setUpi(Nupi);
                    member.setStatus("Not Verified");

                    databaseReference.child(currentId).setValue(member);
                    df.set(ngoInfo)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                    Toast.makeText(NgoRegister.this, "Account Created", Toast.LENGTH_LONG).show();
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Intent intent = new Intent(NgoRegister.this, NgoLogin.class);
                                            startActivity(intent);
                                        }
                                    }, 2000);
                                }
                            });

                    startActivity(new Intent(getApplicationContext(), DonorLogin.class));
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(NgoRegister.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
}