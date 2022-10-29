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







        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nintent = new Intent(PaymentActivity.this,ReservationsActivity.class);
                startActivity(nintent);
            }
        });





        back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),FormActivity.class);
            startActivity(intent);
        });
    }
}