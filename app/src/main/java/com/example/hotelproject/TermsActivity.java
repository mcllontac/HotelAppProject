package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TermsActivity extends AppCompatActivity {

    Button agree;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        agree = findViewById(R.id.btnAgree);
        back = findViewById(R.id.btnBack);

        agree.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),RoomsActivity.class);
            startActivity(i);
        });

        back.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });
    }
}