package com.example.mycms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button donate, recieve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donate = (Button) findViewById(R.id.Donatebutton);
        recieve = (Button) findViewById(R.id.Recievebutton);

        donate.setOnClickListener(this);
        recieve.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Donatebutton:
                startActivity(new Intent(this, DonorLogin.class));
                break;
            case R.id.Recievebutton:
                startActivity(new Intent(this, NgoLogin.class));
                break;
        }
    }
}