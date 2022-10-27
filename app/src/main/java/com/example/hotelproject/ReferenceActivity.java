package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class ReferenceActivity extends AppCompatActivity {

    Button confirm, gen;
    String name, contact, persons, checkIn, checkOut, roomType;
    TextView numRef;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);
        confirm = findViewById(R.id.btnConfirm);
        numRef = findViewById(R.id.refText);
        gen = findViewById(R.id.btnGenerate);

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int val = random.nextInt(999999-100000)+100000;
                numRef.setText((Integer.toString(val)));
            }
        });


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
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference();
            }
        });


        confirm.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ReferenceNumActivity.class);
            startActivity(intent);
        });


    }
}