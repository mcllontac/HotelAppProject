package com.example.hotelproject;


import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Intent;

import android.os.Bundle;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class RoomsActivity extends AppCompatActivity {

    ImageView room1;
    ImageView room2;
    ImageView room3;

    Button next;
    Button prev;

    LinearLayout details1Text;
    LinearLayout details2Text;
    LinearLayout details3Text;
    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        room1 = findViewById(R.id.room1);
        room2 = findViewById(R.id.room2);
        room3 = findViewById(R.id.room3);

        prev = findViewById(R.id.btnPrev);
        next = findViewById(R.id.btnNext);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nIntent = new Intent(RoomsActivity.this, FormActivity.class);
                startActivity(nIntent);
            }
        });




        prev.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TermsActivity.class);
            startActivity(intent);
        });

        details1Text = findViewById(R.id.details1);
        layout1 = findViewById(R.id.layout1);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        details2Text = findViewById(R.id.details2);
        layout2 = findViewById(R.id.layout2);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        details3Text = findViewById(R.id.details3);
        layout3 = findViewById(R.id.layout3);
        layout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }

    public void expand1(View view) {
        int v = (details1Text.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout1, new AutoTransition());
        details1Text.setVisibility(v);
    }

    public void expand2(View view) {
        int x = (details2Text.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
        details2Text.setVisibility(x);
    }

    public void expand3(View view) {
        int c = (details3Text.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout3, new AutoTransition());
        details3Text.setVisibility(c);
    }

}