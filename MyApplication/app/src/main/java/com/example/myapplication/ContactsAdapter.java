package com.example.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<com.example.myapplication.ContactsAdapter.ViewHolder>  {
    private List<com.example.myapplication.Contact>contacts;

    public ContactsAdapter(ArrayList<Contact> contact) {
        this.contacts = contact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        com.example.myapplication.Contact ld=contacts.get(position);
        holder.txtid.setText(ld.getBookName());
        holder.txtname.setText(ld.getPrice());
        holder.txtmovie.setText(ld.getPublisher());
        holder.button.setText("Details");
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Details.class);
                intent.putExtra("Name", ld.getBookName());
                intent.putExtra("price", ld.getPrice());
                intent.putExtra("publisher", ld.getPublisher());
                intent.putExtra("whatsapp", ld.getwhatsapp());
                intent.putExtra("link", ld.getAa());

                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }





    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtid,txtname,txtmovie;
        private Button button;
        public ViewHolder(View itemView) {
            super(itemView);
            txtid=(TextView)itemView.findViewById(R.id.name);
            txtname=(TextView)itemView.findViewById(R.id.price);
            txtmovie=(TextView)itemView.findViewById(R.id.publisher);
            button=itemView.findViewById(R.id.message_button);
        }
    }


}


