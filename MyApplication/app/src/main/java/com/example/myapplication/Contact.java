package com.example.myapplication;

public class Contact {

    private String BookName;
    private String Price;
    private String Publisher;
    private String whatsapp;
    private String aa;


    public  Contact(){


    }



    public Contact(String id, String name, String movie, String app, String aa) {
        this.BookName = id;
        this.Price = name;
        this.Publisher = movie;
        this.whatsapp = app;
        this.aa = aa;


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

    public String getwhatsapp(){
        return whatsapp;
    }

    public String getAa(){
        return aa;
    }


}
