package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReservationsActivity extends AppCompatActivity {

    Button next;
    String name, contact, persons, checkIn, checkOut, room, rnum;
    TextView name1, contact1, persons1, checkIn1, checkOut1, room1, refnum;
    Helper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        contact = i.getStringExtra("contact");
        persons = i.getStringExtra("pax");
        checkIn = i.getStringExtra("doi");
        checkOut = i.getStringExtra("doo");
        room = i.getStringExtra("room");
        rnum =  i.getStringExtra("rnum");

        name1 = findViewById(R.id.textName);
        contact1 = findViewById(R.id.textContact);
        persons1 = findViewById(R.id.textPax);
        checkIn1 = findViewById(R.id.textCheckIn);
        checkOut1 = findViewById(R.id.textCheckOut);
        room1 = findViewById(R.id.textRoom);
        next = findViewById(R.id.btnNext);
        refnum =findViewById(R.id.textRefnum);
        DB = new Helper(this);


        name1.setText(name);
        contact1.setText(contact);
        persons1.setText(persons);
        checkIn1.setText(checkIn);
        checkOut1.setText(checkOut);
        room1.setText(room);
        refnum.setText(rnum);


        next.setOnClickListener(view -> {
            DB.insertReservationdata(name, contact, checkIn, checkOut, persons, room, rnum);
            Intent intent = new Intent(getApplicationContext(), ReferenceNumActivity.class);
            startActivity(intent);
        });

    }
}