package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {

    Button confirm;
    Button back;
    TextView total, change;
    EditText pay;

    String name, contact, persons, checkIn, checkOut, room;
    int pax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        confirm = findViewById(R.id.btnConfirm);
        back = findViewById(R.id.btnBack);
        total = findViewById(R.id.toPay);
        change = findViewById(R.id.Change);
        pay = findViewById(R.id.payment);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        contact = i.getStringExtra("contact");
        persons = i.getStringExtra("numberofpersons");
        checkIn = i.getStringExtra("checkin");
        checkOut = i.getStringExtra("checkout");
        room = i.getStringExtra("roomtype");





        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nintent = new Intent(PaymentActivity.this,ReferenceActivity.class);
                nintent.putExtra("roomtype",room);
                nintent.putExtra("name",name);
                nintent.putExtra("contact",contact);
                nintent.putExtra("numberofpersons",persons);
                nintent.putExtra("checkin",checkIn);
                nintent.putExtra("checkout",checkOut);
                startActivity(nintent);
            }
        });





        back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),ConfirmActivity.class);
            startActivity(intent);
        });
    }
}