package com.example.firebase_1_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    // Declaration of Related xml Components
    EditText edit_email, edit_password;
    Button button_login;

    // Declaring Firebase Components
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialization of EditText Component
        edit_email = findViewById(R.id.email);
        edit_password = findViewById(R.id.password);

        // Initialization of Button Components
        button_login = findViewById(R.id.button);


        // Initialization of Firebase Auth
        mFirebaseAuth = FirebaseAuth.getInstance();



    }


    @Override
    protected  void onStart(){
        super.onStart();
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email  = edit_email.getText().toString();
                String password = edit_password.getText().toString();
                Toast.makeText(MainActivity.this, password, Toast.LENGTH_SHORT).show();
                mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Auth Completed Successfully with Email and Password", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Something Went Wrong, Please Check Your Email Address And Password and Try Again !!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

    }
}