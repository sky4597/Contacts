package com.example.android.contacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class DisplayFavouritesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_favourites);
        FavouritesDatabaseHandler favouritesDatabaseHandler = new FavouritesDatabaseHandler(this);
        TextView contact_count = (TextView) findViewById(R.id.favourites_count);
        contact_count.setText("You have " + favouritesDatabaseHandler.getContactsCount() + " favourite contact(s)");
        ArrayList<Contact> contacts = favouritesDatabaseHandler.getAllContacts();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Contact cn : contacts) {
            arrayList.add("ID: " + cn.getID() + ", Name: " + cn.getName() + ", Phone: " + cn.getPhoneNumber());
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.contacts, R.id.contact_textview, arrayList);
            ListView listView = (ListView) findViewById(R.id.listview_favourites);
            listView.setAdapter(arrayAdapter);
        }
    }
}
