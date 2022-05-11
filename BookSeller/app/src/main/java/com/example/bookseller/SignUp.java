package com.example.bookseller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    public EditText username, password, user;
    public Button login,create;
    private FirebaseAuth mAuth;
    public String id, email, pass;
    public FirebaseDatabase database;
    public DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = (EditText) findViewById(R.id.e1);
        password = (EditText) findViewById(R.id.e2);
        user = (EditText) findViewById(R.id.e3);
        login = findViewById(R.id.but2);
        create = findViewById(R.id.but1);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Login.class));
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = username.getText().toString().trim();
                pass = password.getText().toString().trim();
                Log.w("E_Value", "Data : ===   "+email  +"   "+ pass);
                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener((Activity) getBaseContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getBaseContext(), "Account Created", Toast.LENGTH_LONG).show();
                            String id = mAuth.getCurrentUser().getUid();
                            reference =  database.getReference().child("Users").child(id);
                            reference.setValue(email);
                            reference =  database.getReference().child("UsersName").push();
                            reference.setValue(user.getText().toString().trim());
                            reference = database.getReference().child(id).child("username");
                            reference.setValue(user.getText().toString().trim());
                            startActivity(new Intent(getBaseContext(), Login.class));

                        }else{
                            Toast.makeText(getBaseContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
