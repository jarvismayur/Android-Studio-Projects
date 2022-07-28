package com.example.messagepassing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun();
            }


        });
    }

    public void fun(){
        // Here intent is used for Messages Passing or Data Passing !!
        Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
        String data = name.getText().toString();
        intent.putExtra("Name", data);
        startActivity(intent);
    }
}