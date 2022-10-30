package com.example.hotelproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class FormActivity extends AppCompatActivity {


    final Calendar myCalendar = Calendar.getInstance();
    EditText checkIn, checkOut, name, contact, persons;
    Button next;
    Button prev;
    Helper DB;
    Spinner spinner;
    TextView refNo;
    Date day1, day2;
    public static int stay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        checkIn = findViewById(R.id.editIn);
        checkOut = findViewById(R.id.editOut);
        name = findViewById(R.id.editName);
        contact = findViewById(R.id.editContact);
        persons = findViewById(R.id.numPeople);
        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btnPrev);
        spinner = findViewById(R.id.selection);
        refNo = findViewById(R.id.refNum);
        day1 = myCalendar.getTime();
        day2 = myCalendar.getTime();

        DB = new Helper(this);

        DatePickerDialog.OnDateSetListener InDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateIn();
            }
        };

        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog inDate = new DatePickerDialog(FormActivity.this, InDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
                inDate.getDatePicker().setMinDate((System.currentTimeMillis()));
                inDate.show();
            }
        });

        DatePickerDialog.OnDateSetListener OutDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateOut();
            }
        };



        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog outDate = new DatePickerDialog(FormActivity.this, OutDate, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
                outDate.getDatePicker().setMinDate(day2.getTime()+(1000*60*60*24));
                outDate.show();
            }
        });

        refNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int val = random.nextInt(999999999 - 100000000) + 100000000;
                refNo.setText((Integer.toString(val)));
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String doiTXT = checkIn.getText().toString();
                String dooTXT = checkOut.getText().toString();
                String paxTXT = persons.getText().toString();
                String rtypeTXT = spinner.getSelectedItem().toString();
                String rnumTXT = refNo.getText().toString();


                if (nameTXT.equals("") || contactTXT.equals("") || doiTXT.equals("") || dooTXT.equals("") || paxTXT.equals("") || rtypeTXT.equals("") || rnumTXT.equals(""))
                    Toast.makeText(FormActivity.this, "Please make sure all fields are answered.", Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(FormActivity.this, PaymentActivity.class);
                    intent.putExtra("name", nameTXT);
                    intent.putExtra("contact", contactTXT);
                    intent.putExtra("doi", doiTXT);
                    intent.putExtra("doo", dooTXT);
                    intent.putExtra("pax", paxTXT);
                    intent.putExtra("room", rtypeTXT);
                    intent.putExtra("rnum", rnumTXT);
                    startActivity(intent);
                }
            }
        });

        prev.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), TermsActivity.class);
            startActivity(i);
        });


    }

    private void updateOut() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        checkOut.setText(dateFormat.format(myCalendar.getTime()));
    }

    private void updateIn() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        checkIn.setText(dateFormat.format(myCalendar.getTime()));
    }
}