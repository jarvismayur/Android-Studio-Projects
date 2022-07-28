package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayList<Person> arrayList= new ArrayList<Person>();
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));
        arrayList.add(new Person(R.drawable.apple, " Apple", "This is apple"));


        PersonAdapter personAdapter = new PersonAdapter(this, R.layout.row_data, arrayList);
        listView.setAdapter(personAdapter);

}