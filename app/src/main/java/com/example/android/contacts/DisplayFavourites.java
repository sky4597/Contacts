package com.example.android.contacts;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayFavourites extends AppCompatActivity {

    static int permission = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);
        final Context context = this;
        final FavouritesDatabaseHandler favouritesDatabaseHandler = new FavouritesDatabaseHandler(this);
        TextView contact_count = (TextView) findViewById(R.id.contact_count);
        contact_count.setText("You have " + favouritesDatabaseHandler.getContactsCount() + " favourites(s)");

        // Create an array list of contacts
        ArrayList<Contact> contacts = favouritesDatabaseHandler.getAllContacts();
        //Create a string array list to store
        ArrayList<String> arrayList = new ArrayList<>();

        ListView listView = (ListView) findViewById(R.id.listview_contact);
        for (final Contact cn : contacts) {
            arrayList.add("ID: " + cn.getID() + ", Name: " + cn.getName() +
                    ", Phone: " + cn.getPhoneNumber() + ", Email: " + cn.getEmail());
            //String log = "Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber();
            //Writing Contacts to log
            //Log.d("Contact: ", log);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.contacts, R.id.contact_textview, arrayList);
        //Attach arrayAdapter to the listview
        listView.setAdapter(arrayAdapter);

        //If a list item has been clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String options[] = {"Call", "Message", "Send email"};
                //Positions start from 1, IDs from 0
                final Contact contact = favouritesDatabaseHandler.getContact(position + 1);
                //Get phone number! This is a contacts app, of course
                final String no = Long.toString(contact.getPhoneNumber());
                //Get email
                final String email = contact.getEmail();
                //create a dialog
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                //Request for calling permissions
                ActivityCompat.requestPermissions(DisplayFavourites.this, new String[]{Manifest.permission.CALL_PHONE},
                        permission = 0);
                alertDialogBuilder.setTitle("Options")
                        .setItems(options, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                if (which == 0) {
                                    //Check if the CALL_PHONE permission has been granted
                                    if (ContextCompat.checkSelfPermission(context,
                                            Manifest.permission.CALL_PHONE)
                                            == PackageManager.PERMISSION_GRANTED) {
                                        Intent call_intent = new Intent(Intent.ACTION_CALL);
                                        call_intent.setData(Uri.parse("tel:" + no));
                                        //Verify if there is a phone app
                                        if (call_intent.resolveActivity(getPackageManager()) != null) {
                                            startActivity(call_intent);
                                        } else {
                                            Toast.makeText(context,
                                                    "You do not have an app that can call", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(context, "You do not have permissions", Toast.LENGTH_SHORT).show();
                                    }
                                } else if (which == 1) {
                                    Intent message_intent = new Intent(Intent.ACTION_SENDTO);
                                    message_intent.setData(Uri.parse("smsto:" + no));

                                    //Verify if there is a messaging app
                                    if (message_intent.resolveActivity(getPackageManager()) != null) {
                                        startActivity(message_intent);
                                    } else {
                                        Toast.makeText(context,
                                                "You do not have an app that can send messages",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                } else if (which == 2) {
                                    Intent email_intent = new Intent(Intent.ACTION_SENDTO);
                                    email_intent.setData(Uri.parse("mailto:" + email));

                                    //Verify if there is an email app
                                    if (email_intent.resolveActivity(getPackageManager()) != null) {
                                        startActivity(email_intent);
                                    } else {
                                        Toast.makeText(context,
                                                "You do not have an app that can send emails",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();

            }



                /*Contact contact = databaseHandler.getContact(position+1);
                String no = Long.toString(contact.getPhoneNumber());
                Toast.makeText(getBaseContext(), no , Toast.LENGTH_LONG).show();*/
        });
    }
    //long phone_number = contact.getPhoneNumber();
    //String array = new String(contacts.toString());
    // ListView listView = (ListView) findViewById(R.id.listview_contact);
        /*TextView stringTextView = (TextView) findViewById(R.id.final_tv);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (this, R.layout.contacts, R.id.contact_textview, contacts.toString());
        ListView listView = (ListView) findViewById(R.id.listview_contact);
        listView.setAdapter(arrayAdapter);
        for(Contact contact: contacts){
            stringTextView.setText("Name: " + contact.getName() + " Phone: " + contact.getPhoneNumber());
        }*/
        /*ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.contacts, R.id.contact_textview, contacts);
        ListView listView = (ListView) findViewById(R.id.listview_contact);
        listView.setAdapter(arrayAdapter);*/

        /*for (Contact cn : contacts) {
            String log = "Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Contact: ", log);
        }*/
}