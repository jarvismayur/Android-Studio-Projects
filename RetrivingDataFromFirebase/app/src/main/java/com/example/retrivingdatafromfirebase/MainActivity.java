package com.example.retrivingdatafromfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView text_string;
    Button button_read_data;

    FirebaseDatabase mfirebasedatabase;
    DatabaseReference mdatabaseref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_string = findViewById(R.id.string_hello);
        button_read_data = findViewById(R.id.button_read_data);

        mfirebasedatabase = FirebaseDatabase.getInstance();



    }

    @Override
    protected void onStart(){
        super.onStart();

        button_read_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mdatabaseref = mfirebasedatabase.getReference("Name");
                ValueEventListener fetch_data = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String data = snapshot.getValue(String.class);
                        text_string.setText(data);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                };
                mdatabaseref.addValueEventListener(fetch_data);
            }
        });


    }
}