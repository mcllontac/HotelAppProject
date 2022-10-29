package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReservationsActivity extends AppCompatActivity {

    Button home;
    String name, contact, persons, checkIn, checkOut, room;
    TextView name1,contact1,persons1,checkIn1, checkOut1, room1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        name1 = findViewById(R.id.textName);
        contact1 = findViewById(R.id.textContact);
        persons1 = findViewById(R.id.textPax);
        checkIn1 = findViewById(R.id.textCheckIn);
        checkOut1 = findViewById(R.id.textCheckOut);
        room1 = findViewById(R.id.textRoom);




        home = findViewById(R.id.btnHome);


        home.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        });

    }
}