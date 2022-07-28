package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView simpleListView;

    String courseList[] = {"Rose", "SunFlower", "Lily", "Lotus", "Tulip", "Marigold"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleListView = findViewById(R.id.simpleListView);

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.listitem, R.id.itemTextView, courseList);
        simpleListView.setAdapter(arrayAdapter);


        // From Where the MEssage Is Passed
        Intent intent = new Intent(MainActivity.this, SecondaryActivity.this);
        intent.putExtra("Name","Mayur");
        startActivity(intent);

        // Where the Message Is Received
        Intent intent1 = getIntent();
        String Name = intent.getStringExtra("Name");
    }
}