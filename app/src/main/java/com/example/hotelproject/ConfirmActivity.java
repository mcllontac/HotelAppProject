package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmActivity extends AppCompatActivity {
    Button proceed;
    Button back;
    String name,contact,numberofpersons,checkIn,checkOut;
    TextView nView, cView, pView, iView, oView;
    Spinner spinner;



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
        spinner = findViewById(R.id.selection);



        Intent i = getIntent();
        name = i.getStringExtra("name");
        contact = i.getStringExtra("contact");
        numberofpersons = i.getStringExtra("numberofpersons");
        checkIn = i.getStringExtra("checkin");
        checkOut = i.getStringExtra("checkout");



        nView.setText(name);
        cView.setText(contact);
        pView.setText(numberofpersons);
        iView.setText(checkIn);
        oView.setText(checkOut);

        String text = spinner.getSelectedItem().toString();


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmActivity.this,PaymentActivity.class);
                intent.putExtra("roomtype",text);
                intent.putExtra("name",name);
                intent.putExtra("contact",contact);
                intent.putExtra("numberofpersons",numberofpersons);
                intent.putExtra("checkin",checkIn);
                intent.putExtra("checkout",checkOut);
                startActivity(intent);
            }
        });



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