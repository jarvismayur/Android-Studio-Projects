package com.example.recyclerview;

import android.content.Context;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Contact {
    private String BookName;
    private String Price;
    private String Publisher;

    public  Contact(){


    }



    public Contact(String id, String name, String movie) {
        this.BookName = id;
        this.Price = name;
        this.Publisher = movie;
    }

    public String getBookName() {
        return BookName;
    }


    public String getPrice() {
        return Price;
    }

    public String getPublisher() {
        return Publisher;
    }
}
