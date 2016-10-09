package com.example.android.contacts;


public class Contact {
    //private variables
    private int _id;
    private String _name;
    private String _phone_number;

    // Empty constructor
    public Contact() {

    }

    // constructor
    public Contact(int id, String name, String _phone_number) {
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }

    // constructor
    public Contact(String name, String _phone_number) {
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
    String getPhoneNumber() {
        return this._phone_number;
    }

    // setting phone number
    void setPhoneNumber(String phone_number) {
        this._phone_number = phone_number;
    }
}
