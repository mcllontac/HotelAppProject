package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {
    Button proceed;
    Button back;
    String name,contact,numberofpersons,checkIn,checkOut,roomType;
    TextView nView, cView, pView, iView, oView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        proceed = findViewById(R.id.btnProceed);
        back = findViewById(R.id.btnBack);
        nView = findViewById(R.id.nameView);
        cView = findViewById(R.id.contactView);
        pView = findViewById(R.id.paxView);
        iView = findViewById(R.id.inView);
        oView = findViewById(R.id.outView);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        contact = i.getStringExtra("contact");
        numberofpersons = i.getStringExtra("numberofpersons");
        checkIn = i.getStringExtra("checkin");
        checkOut = i.getStringExtra("checkout");
        roomType = i.getStringExtra("roomType");


        nView.setText(name);
        cView.setText(contact);
        pView.setText(numberofpersons);
        iView.setText(checkIn);
        oView.setText(checkOut);









        proceed.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),PaymentActivity.class);
            startActivity(intent);
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),RoomsActivity.class);
            startActivity(intent);
        });
    }
}