package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ConfirmActivity extends AppCompatActivity {
    Button proceed;
    Button back;
    String name,contact,numberofpersons,checkIn,checkOut;
    TextView nView, cView, pView, iView, oView;
    Spinner spinner;
    List<String> items;



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

        items = new ArrayList<>();

        items.add("--Select--");
        items.add("Azalea");
        items.add("Japanese");
        items.add("Deluxe");

        spinner.setAdapter(new ArrayAdapter<>(ConfirmActivity.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, items
        ));

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                items = items.get(position);
            }
        });



        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nintent = new Intent(ConfirmActivity.this,PaymentActivity.class);
                nintent.putExtra("roomtype",room);
                nintent.putExtra("name",name);
                nintent.putExtra("contact",contact);
                nintent.putExtra("numberofpersons",numberofpersons);
                nintent.putExtra("checkin",checkIn);
                nintent.putExtra("checkout",checkOut);
                startActivity(nintent);
            }
        });




        back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),RoomsActivity.class);
            startActivity(intent);
        });
    }
}