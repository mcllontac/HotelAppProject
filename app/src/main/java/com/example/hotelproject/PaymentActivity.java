package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends AppCompatActivity {

    Button confirm;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        confirm = findViewById(R.id.btnConfirm);
        back = findViewById(R.id.btnBack);

        confirm.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),ReferenceActivity.class);
            startActivity(i);
        });

        back.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),ConfirmActivity.class);
            startActivity(i);
        });
    }
}