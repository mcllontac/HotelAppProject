package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormActivity extends AppCompatActivity {

    Button next;
    Button prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btnPrev);

        next.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),RoomsActivity.class);
            startActivity(i);
        });

        prev.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),RoomsActivity.class);
            startActivity(i);
        });
    }
}