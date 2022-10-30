package com.example.hotelproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReferenceNumActivity extends AppCompatActivity {

    Button check, view, home;
    EditText reservee, rNum;
    Helper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_num);

        home = findViewById(R.id.btnHome);
        view = findViewById(R.id.btnView);
        check = findViewById(R.id.btnCheck);
        reservee = findViewById(R.id.nameRes);
        rNum = findViewById(R.id.refNum);
        DB = new Helper(this);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = reservee.getText().toString();
                String refNum = rNum.getText().toString();

                if (name.equals("") || refNum.equals(""))
                    Toast.makeText(ReferenceNumActivity.this, "Please answer all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkNameRef = DB.checkNameRnum(name, refNum);
                    if (checkNameRef == true) {
                        Toast.makeText(ReferenceNumActivity.this, "Reservation Confirmed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ReferenceNumActivity.this, "No reservations detected", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = reservee.getText().toString();
                String refNum = rNum.getText().toString();

                Cursor data = DB.viewData(name, refNum);
                if (data.getCount() == 0) {
                    Toast.makeText(ReferenceNumActivity.this, "No Reservations Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext()) {
                    buffer.append("Name :" + data.getString(0) + "\n");
                    buffer.append("Contact :" + data.getString(1) + "\n");
                    buffer.append("Check In :" + data.getString(2) + "\n");
                    buffer.append("Check Out :" + data.getString(3) + "\n");
                    buffer.append("Pax :" + data.getString(4) + "\n");
                    buffer.append("Room :" + data.getString(5) + "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder((ReferenceNumActivity.this));
                builder.setCancelable(true);
                builder.setTitle("Reservation Details :");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


    }
}