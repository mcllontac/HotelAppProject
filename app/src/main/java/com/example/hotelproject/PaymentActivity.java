package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {

    Button confirm;
    Button back;
    String name,contact,persons,checkIn,checkOut,roomType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        confirm = findViewById(R.id.btnConfirm);
        back = findViewById(R.id.btnBack);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        contact = i.getStringExtra("contact");
        persons = i.getStringExtra("numberofpersons");
        checkIn = i.getStringExtra("checkin");
        checkOut = i.getStringExtra("checkout");
        roomType = i.getStringExtra("roomtype");

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this,ReferenceActivity.class);
                intent.putExtra("roomtype",roomType);
                intent.putExtra("name",name);
                intent.putExtra("contact",contact);
                intent.putExtra("numberofpersons",persons);
                intent.putExtra("checkin",checkIn);
                intent.putExtra("checkout",checkOut);
                startActivity(intent);
            }
        });





        back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),ConfirmActivity.class);
            startActivity(intent);
        });
    }
}