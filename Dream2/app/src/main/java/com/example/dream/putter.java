package com.example.dream;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class putter extends AppCompatActivity {

    public EditText data;
    public Button add, show;
    public FirebaseAuth mAtuh;
    public FirebaseDatabase database;
    public DatabaseReference reference;
    String id, Data,date;
    private Calendar calendar;
    public SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_putter);
        data  = findViewById(R.id.e1);
        add = findViewById(R.id.but1);
        show = findViewById(R.id.but2);
        mAtuh = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        id = mAtuh.getCurrentUser().getUid();

        calendar = Calendar.getInstance();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateFormat = new SimpleDateFormat("h:mm a");
                date = dateFormat.format(calendar.getTime());
                Toast.makeText(putter.this, date, Toast.LENGTH_SHORT).show();
                Data = data.getText().toString().trim();
                reference = database.getReference().child(id).child("Data").push();
                reference.setValue(Data);
                reference.setValue(date);
                Toast.makeText(putter.this, "DAta Inserted Successfully", Toast.LENGTH_SHORT).show();
                data.setText("");
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(putter.this, shower.class));
            }
        });

    }
}
