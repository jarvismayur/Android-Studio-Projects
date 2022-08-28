package com.example.tabletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button mbutton;
    EditText name_1, name_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbutton = findViewById(R.id.button);
        name_1 = findViewById(R.id.edit_name);
        name_2 = findViewById(R.id.edit_name_2);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f_name_1 = name_1.getText().toString();
                String f_name_2 = name_2.getText().toString();
                String res = "Name :- " + f_name_1 +"\n Surname :-  "+ f_name_2;
                Toast.makeText(MainActivity.this, res, Toast.LENGTH_LONG).show();
            }
        });

    }
}