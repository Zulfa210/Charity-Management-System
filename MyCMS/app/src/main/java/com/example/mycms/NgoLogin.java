package com.example.mycms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class NgoLogin extends AppCompatActivity {

    EditText NeditTextEmail,NeditTextPassword;
    Button NloginBtn;
    TextView NgotoRegister, NgotoForgot;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String currentId,ngoName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_login);

        NgotoRegister = (TextView) findViewById(R.id.NGOregisterBanner);
        NgotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NgoLogin.this, NgoRegister.class));

            }
        });

        NgotoForgot = (TextView) findViewById(R.id.NGOForgot);
        NgotoForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent());
            }
        });

        NeditTextEmail = (EditText) findViewById(R.id.NGOEmailAddress);
        NeditTextPassword = (EditText) findViewById(R.id.NGOPassword);

        NloginBtn = (Button) findViewById(R.id.NGOSignIn);
        NloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginNgo();
            }
        });

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


    }



    private void loginNgo() {
        String emailN = NeditTextEmail.getText().toString().trim();
        String passwordN = NeditTextPassword.getText().toString().trim();

        if (emailN.isEmpty()) {
            NeditTextEmail.setError("Email is Required");
            NeditTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailN).matches()) {
            NeditTextEmail.setError("Email is Invalid");
            NeditTextEmail.requestFocus();
            return;
        }
        if (passwordN.isEmpty()) {
            NeditTextPassword.setError("Password is Required");
            NeditTextPassword.requestFocus();
            return;
        }

        fAuth.signInWithEmailAndPassword(emailN,passwordN).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(NgoLogin.this, "LoggedIn Successfully", Toast.LENGTH_LONG).show();


//                FirebaseDatabase.getInstance().getReference("NGOs").child(currentId).addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        NgoUser ngoprofile = snapshot.getValue(NgoUser.class);
//                        if (ngoprofile!=null){
//                            ngoName = ngoprofile.name.toString();
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        Toast.makeText(NgoLogin.this, "Something Wrong Happened!", Toast.LENGTH_LONG).show();
//                    }
//                });
                Intent i1 =new Intent(NgoLogin.this, NgoDashboard.class);
               // i1.putExtra("Ngo_name",ngoName);
                startActivity(i1);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(NgoLogin.this, "Invalid Credentials",Toast.LENGTH_LONG).show();

            }
        });


            }
        }
