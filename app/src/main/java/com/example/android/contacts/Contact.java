package com.example.android.contacts;


class Contact {

    // Private variables
    private int _id;
    private String _name;
    private long _phone_number;
    private String _email;

    // Empty constructor
    Contact() {

    }

    // Constructor
    Contact(int id, String name, long _phone_number, String email) {
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
        this._email = email;
    }

    // Constructor
    Contact(String name, long _phone_number, String _email) {
        this._name = name;
        this._phone_number = _phone_number;
        this._email = _email;
    }

    // Getting ID
    int getID() {
        return this._id;
    }

    // Setting ID
    void setID(int id) {
        this._id = id;
    }

    // Getting name
    public String getName() {
        return this._name;
    }

    // Setting name
    public void setName(String name) {
        this._name = name;
    }

    // Getting phone number
    long getPhoneNumber() {
        return this._phone_number;
    }

    // Setting phone number
    void setPhoneNumber(long phone_number) {
        this._phone_number = phone_number;
    }

    // Getting email
    String getEmail() {
        return this._email;
    }

    // Setting email
    void setEmail(String email) {
        this._email = email;
    }
}