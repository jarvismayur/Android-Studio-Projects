package com.example.messagepassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        String data = intent.getStringExtra("Name").toString();
        textView.setText(data);
    }
}