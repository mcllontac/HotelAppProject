package com.example.hotelproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;


public class RoomsActivity extends AppCompatActivity {

    ImageView room1;
    ImageView room2;
    ImageView room3;

    Button next;
    Button prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        room1 = findViewById(R.id.room1);
        room2 = findViewById(R.id.room2);
        room3 = findViewById(R.id.room3);

        prev = findViewById(R.id.btnPrev);
        next = findViewById(R.id.btnNext);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nIntent = new Intent(RoomsActivity.this, FormActivity.class);
                startActivity(nIntent);
            }
        });




        prev.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TermsActivity.class);
            startActivity(intent);
        });
    }


}