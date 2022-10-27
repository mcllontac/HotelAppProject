package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReferenceNumActivity extends AppCompatActivity {

    Button next;
    String name1, contact1, persons1, checkIn1, checkOut1, roomType1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_num);

        next = findViewById(R.id.btnNext);

        Intent i = getIntent();
        name1 = i.getStringExtra("name");
        contact1 = i.getStringExtra("contact");
        persons1 = i.getStringExtra("numberofpersons");
        checkIn1 = i.getStringExtra("checkin");
        checkOut1 = i.getStringExtra("checkout");
        roomType1 = i.getStringExtra("roomtype");


        next.setOnClickListener(view -> {
            Intent nintent = new Intent(ReferenceNumActivity.this,ReservationsActivity.class);
            nintent.putExtra("roomtype",roomType1);
            nintent.putExtra("name",name1);
            nintent.putExtra("contact",contact1);
            nintent.putExtra("numberofpersons",persons1);
            nintent.putExtra("checkin",checkIn1);
            nintent.putExtra("checkout",checkOut1);
            startActivity(nintent);
        });


    }
}