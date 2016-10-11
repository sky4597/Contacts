package com.example.android.contacts;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
        final String name = name_editText.getText().toString();
        final long number = Long.parseLong(phone_editText.getText().toString());
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        databaseHandler.addContact(new Contact(name, number));
        Toast.makeText(this, "New Contact Added", Toast.LENGTH_SHORT).show();
        final Context context = this;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Also add to favourites?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        FavouritesDatabaseHandler favouritesDatabaseHandler = new FavouritesDatabaseHandler(context);
                        favouritesDatabaseHandler.addContact(new Contact(name, number));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });


        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
        /*List<Contact> contacts = databaseHandler.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Contact: ", log);
        }*/
    }
}
