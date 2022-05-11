package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Landing extends AppCompatActivity {

    Button login , signUp;


    FirebaseAuth mAtuh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        login = findViewById(R.id.loginBut);
        signUp = findViewById(R.id.signBut);
        mAtuh = FirebaseAuth.getInstance();


        if(mAtuh.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Landing.this, Login.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Landing.this, SignUp.class));
            }
        });

    }
}