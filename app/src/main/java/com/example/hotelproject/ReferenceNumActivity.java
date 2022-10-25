package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReferenceNumActivity extends AppCompatActivity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_num);

        next = findViewById(R.id.btnNext);


        next.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),ReservationsActivity.class);
            startActivity(i);
        });


    }
}