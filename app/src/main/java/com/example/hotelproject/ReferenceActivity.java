package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReferenceActivity extends AppCompatActivity {

    Button agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);

        agree = findViewById(R.id.btnAgree);

        agree.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),ReferenceNumActivity.class);
            startActivity(i);
        });


    }
}