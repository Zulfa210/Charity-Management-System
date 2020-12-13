package com.example.authapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private TextView register_user, banner;
    private EditText editTextPersonName, editTextEmailAddress, editTextPhone,editTextPassword;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        mAuth = FirebaseAuth.getInstance();

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        register_user = (Button) findViewById(R.id.register);
        register_user.setOnClickListener(this);

        editTextPersonName = (EditText) findViewById(R.id.Name);
        editTextEmailAddress = (EditText) findViewById(R.id.EmailAddress);
        editTextPhone = (EditText) findViewById(R.id.Phone);
        editTextPassword= (EditText) findViewById(R.id.Password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.register:
                registerUser();
                break;
        }
    }

    private void registerUser() {

        String email= editTextEmailAddress.getText().toString().trim();
        String fullName= editTextPersonName.getText().toString().trim();
        String phone= editTextPhone.getText().toString().trim();
        String password= editTextPassword.getText().toString().trim();

        if(fullName.isEmpty()){
            editTextPersonName.setError("Full Name is Required");
            editTextPersonName.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editTextEmailAddress.setError("Email is Required");
            editTextEmailAddress.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmailAddress.setError("Email is Invalid");
            editTextEmailAddress.requestFocus();
            return;
        }
        if(phone.isEmpty()){
            editTextPhone.setError("Phone no. is Required");
            editTextPhone.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Password is Required");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Enter Password >=6");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user= new User(fullName, email, phone);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterUser.this,"User has been registered successfully", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                        //redirect to login layout
                                    }else{
                                        Toast.makeText(RegisterUser.this,"Failed to Register", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }
                        else{
                            Toast.makeText(RegisterUser.this,"Failed to Register", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });
    }
}