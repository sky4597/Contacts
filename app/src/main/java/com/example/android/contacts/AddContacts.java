package com.example.android.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
    }

    public void addContact(View view) throws NumberFormatException {
        EditText name_editText = (EditText) findViewById(R.id.add_contact_name);
        EditText phone_editText = (EditText) findViewById(R.id.add_contact_number);
        EditText email_editText = (EditText) findViewById(R.id.add_contact_email);
        final String name = name_editText.getText().toString().trim();
        try {
            if (name.equals("")) {
                name_editText.setError("Add Name");
            } else {
                // Remove all whitespaces; guess I really shouldn't be using long but whatever
                final long number = Long.parseLong(phone_editText.getText().toString().replaceAll("\\s+", ""));
                final String email = email_editText.getText().toString().trim();
                DatabaseHandler databaseHandler = new DatabaseHandler(this);
                databaseHandler.addContact(new Contact(name, number, email));
                Toast.makeText(this, "New Contact Added", Toast.LENGTH_SHORT).show();
            }
        }
        // Lest an invalid number is entered
        catch (NumberFormatException npe) {
            phone_editText.setError("Add a number");
        }
    }
}