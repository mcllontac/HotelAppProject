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




        next.setOnClickListener(view -> {
            Intent nintent = new Intent(ReferenceNumActivity.this,ReservationsActivity.class);
            startActivity(nintent);
        });


    }
}