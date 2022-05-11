package com.example.chatroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Friend extends AppCompatActivity {
    public EditText fireadder;
    public Button add, show, dash;
    public FirebaseAuth mAuth;
    public FirebaseDatabase database;
    public DatabaseReference reference;
    public String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        fireadder = findViewById(R.id.e1);
        add = findViewById(R.id.but1);
        show = findViewById(R.id.but2);
        dash = findViewById(R.id.but3);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        id = mAuth.getCurrentUser().getUid();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = fireadder.getText().toString().trim();
                reference = database.getReference().child(id).child("FriendList").push();
                reference.setValue(data);
                Toast.makeText(Friend.this, "New Friend Added", Toast.LENGTH_LONG).show();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Friend.this, show_friends.class));
            }
        });

        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Friend.this, Dashboard.class));
            }
        });
    }
}
