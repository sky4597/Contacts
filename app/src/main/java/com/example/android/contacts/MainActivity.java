package com.example.android.contacts;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        //Log.d("Insert: ", "Inserting ..");
        /*databaseHandler.addContact(new Contact("Ravi", "9100000000"));
        databaseHandler.addContact(new Contact("Srinivas", "9199999999"));
        databaseHandler.addContact(new Contact("Tommy", "9522222222"));
        databaseHandler.addContact(new Contact("Karthik", "9533333333"));*/

        // Reading all contacts
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        AlertDialog alertDialog = alertDialogBuilder.create();
        //alertDialog.setTitle("Test");
        // show it
        //alertDialog.show();
        Log.d("Reading: ", "Reading all contacts..");
        ArrayList<Contact> contacts = databaseHandler.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Contact: ", log);
        }
    }

    public void addContact(View view) {
        Intent addContactActivity = new Intent(this, AddContacts.class);
        startActivity(addContactActivity);

    }

    public void displayContacts(View view) {
        Intent displayContactActivity = new Intent(this, DisplayContacts.class);
        startActivity(displayContactActivity);
    }

    public void displayFavourites(View view) {
        Intent displayFavouritesActivity = new Intent(this, DisplayFavouritesActivity.class);
        startActivity(displayFavouritesActivity);
    }
}
