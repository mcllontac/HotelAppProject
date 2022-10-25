package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RoomsActivity extends AppCompatActivity {

    ImageView room1;
    ImageView room2;
    ImageView room3;


    Button prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        room1 = findViewById(R.id.room1);
        room2 = findViewById(R.id.room2);
        room3 = findViewById(R.id.room3);

        prev = findViewById(R.id.btnPrev);


        room1.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),ConfirmActivity.class);
            startActivity(i);
        });

        room2.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),ConfirmActivity.class);
            startActivity(i);
        });

        room3.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),ConfirmActivity.class);
            startActivity(i);
        });



        prev.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),FormActivity.class);
            startActivity(i);
        });
    }
}