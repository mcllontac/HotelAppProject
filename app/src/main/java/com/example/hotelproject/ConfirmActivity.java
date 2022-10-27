package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ConfirmActivity extends AppCompatActivity {
    Button proceed;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        proceed = findViewById(R.id.btnProceed);
        back = findViewById(R.id.btnBack);


        proceed.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),PaymentActivity.class);
            startActivity(i);
        });

        back.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),RoomsActivity.class);
            startActivity(i);
        });
    }
}