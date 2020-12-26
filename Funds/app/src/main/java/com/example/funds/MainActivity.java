package com.example.funds;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(5000,1000){
            @Override
            public void onTick(long millisUntilFinished){}

            @Override
            public void onFinish(){
                MainActivity.this.setContentView(R.layout.activity_main);
            }
        }.start();
    }
    public void donate(View view) {
        Intent intent= new Intent(this,DonorSignIn.class);
        startActivity(intent);
    }
    public void receive(View view) {
        Intent intent= new Intent(this,receiverSignIn.class);
        startActivity(intent);
    }
}