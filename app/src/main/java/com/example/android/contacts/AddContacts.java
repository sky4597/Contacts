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
        final String name = name_editText.getText().toString();
        final long number = Long.parseLong(phone_editText.getText().toString());
        final String email = email_editText.getText().toString();
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        databaseHandler.addContact(new Contact(name, number, email));
        Toast.makeText(this, "New Contact Added", Toast.LENGTH_SHORT).show();
        /*List<Contact> contacts = databaseHandler.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Contact: ", log);
        }*/
    }
}
