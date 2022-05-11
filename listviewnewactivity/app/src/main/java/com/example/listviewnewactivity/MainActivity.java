package com.example.listviewnewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayList<Person>  arrayList= new ArrayList<Person>();
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));


        PersonAdapter personAdapter = new PersonAdapter(this, R.layout.row_data, arrayList);
        listView.setAdapter(personAdapter);


    }
}
