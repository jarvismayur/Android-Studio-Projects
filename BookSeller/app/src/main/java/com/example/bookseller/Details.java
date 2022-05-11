package com.example.bookseller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class Details extends AppCompatActivity {
    TextView bookname, publisher, price;
    Button whatsapp_button;
    ImageView imageView;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    DatabaseReference databaseReference;
    StorageReference storageReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        bookname = findViewById(R.id.text_book_name);
        publisher = findViewById(R.id.text_publisher_name);
        price = findViewById(R.id.text_price);
        whatsapp_button = findViewById(R.id.button_whatsapp);
        imageView = findViewById(R.id.imageViewDetails);









        bookname.setText(getIntent().getStringExtra("Name"));
        publisher.setText(getIntent().getStringExtra("publisher"));
        price.setText(getIntent().getStringExtra("price"));

        whatsapp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + getIntent().getStringExtra("whatsapp") + "&text=" + "I wanna Buy This Book " + getIntent().getStringExtra("Name")));
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {

        super.onStart();
        firebaseStorage = FirebaseStorage.getInstance();

            String Link = "/" + getIntent().getStringExtra("link");

            storageReference = firebaseStorage.getReference(Link);
        Toast.makeText(this, String.valueOf(storageReference.getDownloadUrl()), Toast.LENGTH_SHORT).show();

        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Got the download URL for 'users/me/profile.png'
                // Pass it to Picasso to download, show in ImageView and caching
                Picasso.get().load(uri.toString()).into(imageView);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });



    }
}
