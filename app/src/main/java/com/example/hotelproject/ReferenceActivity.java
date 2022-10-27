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

    Button confirm, gen, next;
    String name1, contact1, persons1, checkIn1, checkOut1, roomType1;
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
        next = findViewById(R.id.btnNext);

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                Random random = new Random();
                int val = random.nextInt(999999-100000)+100000;
                numRef.setText((Integer.toString(val)));
            }
        });


        Intent i = getIntent();
        name1 = i.getStringExtra("name");
        contact1 = i.getStringExtra("contact");
        persons1 = i.getStringExtra("numberofpersons");
        checkIn1 = i.getStringExtra("checkin");
        checkOut1 = i.getStringExtra("checkout");
        roomType1 = i.getStringExtra("roomtype");




        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Reservations");

                String name = name1;
                String contact = contact1;
                String persons = persons1;
                String checkIn = checkIn1;
                String checkOut = checkOut1;
                String room = roomType1;
                String rnum = numRef.getText().toString();

                Helper helper = new Helper(name, contact, persons, checkIn, checkOut, room, rnum);

                reference.child(name).setValue(helper);

            }
        });


        next.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ReferenceNumActivity.class);
            startActivity(intent);
        });


    }
}