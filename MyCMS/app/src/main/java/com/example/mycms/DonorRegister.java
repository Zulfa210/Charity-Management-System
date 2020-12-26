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
import android.widget.ProgressBar;
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

public class DonorRegister extends AppCompatActivity implements View.OnClickListener {


    private TextView register_donor, dloginBanner;
    private EditText editTextDonorName, editTextDonorEmail, editTextDonorPhone,editTextDonorPassword;
    //private ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseDatabase RDatabase = FirebaseDatabase.getInstance();
    DonorUser member;
    String currentDonorId;
    DatabaseReference databasereference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_register);

        editTextDonorName= (EditText) findViewById(R.id.DName);
        editTextDonorEmail = (EditText) findViewById(R.id.DEmailAddress);
        editTextDonorPhone = (EditText) findViewById(R.id.DPhone);
        editTextDonorPassword = (EditText) findViewById(R.id.DPassword);


        dloginBanner = (TextView) findViewById(R.id.Donorbanner);
        dloginBanner.setOnClickListener(this);

        register_donor = (Button) findViewById(R.id.Dregister);
        register_donor.setOnClickListener(this);
        //progressBar = (ProgressBar) findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        member = new DonorUser();


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.Donorbanner:
                startActivity(new Intent(this, DonorLogin.class));
                break;
            case R.id.Dregister:
                registerDonor();
                break;
        }

    }

    private void registerDonor() {

        String Demail= editTextDonorEmail.getText().toString().trim();
        String DfullName= editTextDonorName.getText().toString().trim();
        String Dphone= editTextDonorPhone.getText().toString().trim();
        String Dpassword= editTextDonorPassword.getText().toString().trim();

        if(DfullName.isEmpty()){
            editTextDonorName.setError("Full Name is Required");
            editTextDonorName.requestFocus();
            return;
        }

        if(Demail.isEmpty()){
            editTextDonorEmail.setError("Email is Required");
            editTextDonorEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Demail).matches()){
            editTextDonorEmail.setError("Email is Invalid");
            editTextDonorEmail.requestFocus();
            return;
        }
        if(Dphone.isEmpty()){
            editTextDonorPhone.setError("Phone no. is Required");
            editTextDonorPhone.requestFocus();
            return;
        }

        if(Dpassword.isEmpty()){
            editTextDonorPassword.setError("Password is Required");
            editTextDonorPassword.requestFocus();
            return;
        }

        if(Dpassword.length() < 6) {
            editTextDonorPassword.setError("Enter Password >=6");
            editTextDonorPassword.requestFocus();
            return;

        }
            fAuth.createUserWithEmailAndPassword(Demail, Dpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {


                        FirebaseUser dUser = FirebaseAuth.getInstance().getCurrentUser();
                        currentDonorId = dUser.getUid();

                        databasereference = RDatabase.getReference("Donors");

                        Toast.makeText(DonorRegister.this, "Account Created", Toast.LENGTH_LONG).show();
                        DocumentReference df = fStore.collection("Donors").document();
                        Map<String, Object> donorInfo = new HashMap<>();
                        donorInfo.put("FullName", DfullName);
                        donorInfo.put("EmailId", Demail);
                        donorInfo.put("PhoneNo", Dphone);

                        donorInfo.put("Role", "Donor");

                        member.setName(DfullName);
                        member.setEmail(Demail);
                        member.setPhone(Dphone);

                        databasereference.child(currentDonorId).setValue(member);

                        df.set(donorInfo)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(DonorRegister.this, "Account Created", Toast.LENGTH_LONG).show();
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                Intent intent = new Intent(DonorRegister.this, DonorLogin.class);
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
                    Toast.makeText(DonorRegister.this, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            });

        }

    }
