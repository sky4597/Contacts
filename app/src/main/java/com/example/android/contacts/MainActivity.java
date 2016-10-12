package com.example.android.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        Intent displayFavouritesActivity = new Intent(this, DisplayFavourites.class);
        startActivity(displayFavouritesActivity);
    }
}
