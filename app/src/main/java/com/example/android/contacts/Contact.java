package com.example.android.contacts;


import android.media.Image;

public class Contact {
    Image image;
    //private variables
    private int _id;
    private String _name;
    private long _phone_number;

    // Empty constructor
    public Contact() {

    }

    // constructor
    public Contact(int id, String name, long _phone_number) {
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }

    // constructor
    public Contact(String name, long _phone_number) {
        this._name = name;
        this._phone_number = _phone_number;
    }

    // getting ID
    int getID() {
        return this._id;
    }

    // setting id
    void setID(int id) {
        this._id = id;
    }

    // getting name
    public String getName() {
        return this._name;
    }

    // setting name
    public void setName(String name) {
        this._name = name;
    }

    // getting phone number
    long getPhoneNumber() {
        return this._phone_number;
    }

    // setting phone number
    void setPhoneNumber(long phone_number) {
        this._phone_number = phone_number;
    }
}
