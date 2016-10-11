package com.example.android.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contacts);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        TextView contact_count = (TextView) findViewById(R.id.contact_count);
        contact_count.setText("You have " + databaseHandler.getContactsCount() + " contact(s)");
        ArrayList<Contact> contacts = databaseHandler.getAllContacts();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Contact cn : contacts) {
            arrayList.add("Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber());
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.contacts, R.id.contact_textview, arrayList);
            ListView listView = (ListView) findViewById(R.id.listview_contact);
            listView.setAdapter(arrayAdapter);
            String log = "Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber();
            //Writing Contacts to log
            //Log.d("Contact: ", log);
        }
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
}
