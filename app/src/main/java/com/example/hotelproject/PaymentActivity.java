package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    Button confirm;
    Button back, btnpay;
    TextView total, change;
    EditText pay;
    String name1, contact, persons, checkIn, checkOut, room, rnum;
    public int cash, totalChange, stay, totalPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        confirm = findViewById(R.id.btnConfirm);
        back = findViewById(R.id.btnBack);
        total = findViewById(R.id.toPay);
        change = findViewById(R.id.Change);
        pay = findViewById(R.id.payment);
        btnpay = findViewById(R.id.btnPay);

        Intent i = getIntent();
        name1 = i.getStringExtra("name");
        contact = i.getStringExtra("contact");
        persons = i.getStringExtra("pax");
        checkIn = i.getStringExtra("doi");
        checkOut = i.getStringExtra("doo");
        room = i.getStringExtra("room");
        rnum = i.getStringExtra("rnum");

        if (persons.equals("1")) {
            total.setText("1595 a night");
        } else if (persons.equals("2")) {
            total.setText("3000 a night");
        }


        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pay.equals("")) {
                    Toast.makeText(PaymentActivity.this, "Enter Payment", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PaymentActivity.this, "Transaction Complete", Toast.LENGTH_SHORT).show();
                }
            }
        });


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nintent = new Intent(PaymentActivity.this, ReservationsActivity.class);
                nintent.putExtra("name", name1);
                nintent.putExtra("contact", contact);
                nintent.putExtra("doi", checkIn);
                nintent.putExtra("doo", checkOut);
                nintent.putExtra("pax", persons);
                nintent.putExtra("room", room);
                nintent.putExtra("rnum", rnum);
                startActivity(nintent);
            }
        });


        back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), FormActivity.class);
            startActivity(intent);
        });
    }
}