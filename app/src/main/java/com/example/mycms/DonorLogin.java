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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class DonorLogin extends AppCompatActivity {


    EditText DeditTextEmail, DeditTextPassword;
    Button DloginBtn;
    TextView DgotoRegister, DgotoForgot;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_login);

        DgotoRegister = (TextView) findViewById(R.id.DonorRegisterBanner);
        DgotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DonorLogin.this, DonorRegister.class));
            }
        });

        DgotoForgot = (TextView) findViewById(R.id.DonorForgot);
        DgotoForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DonorLogin.this, DonorForgot.class));
            }
        });

        DeditTextEmail = (EditText) findViewById(R.id.DonorEmailAddress);
        DeditTextPassword = (EditText) findViewById(R.id.DonorPassword);

        DloginBtn = (Button) findViewById(R.id.DonorSignIn);
        DloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDonor();
            }
        });

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

    }



    private void loginDonor() {
        String emailD = DeditTextEmail.getText().toString().trim();
        String passwordD = DeditTextPassword.getText().toString().trim();

        if (emailD.isEmpty()) {
            DeditTextEmail.setError("Email is Required");
            DeditTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailD).matches()) {
            DeditTextEmail.setError("Email is Invalid");
            DeditTextEmail.requestFocus();
            return;
        }
        if (passwordD.isEmpty()) {
            DeditTextPassword.setError("Password is Required");
            DeditTextPassword.requestFocus();
            return;
        }

        fAuth.signInWithEmailAndPassword(emailD,passwordD).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(DonorLogin.this, "LoggedIn Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(DonorLogin.this, DonorDashboard.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(DonorLogin.this, "Invalid Credentials",Toast.LENGTH_LONG).show();

            }
        });
    }

}