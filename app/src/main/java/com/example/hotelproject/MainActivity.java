package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;



public class MainActivity extends AppCompatActivity {

    private BottomSheetBehavior bottomSheetBehavior;

    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout dragsheets = findViewById(R.id.sheet);

        bottomSheetBehavior = BottomSheetBehavior.from(dragsheets);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),TermsActivity.class);
            startActivity(i);
        });

        btn2.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(),ReferenceNumActivity.class);
            startActivity(i);
        });




    }
}