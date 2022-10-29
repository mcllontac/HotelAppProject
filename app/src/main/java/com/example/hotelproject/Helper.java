package com.example.hotelproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    public Helper(Context context) {
        super(context, "Reservation.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Reservationdetails(name TEXT primary key, contact TEXT, doi TEXT, doo TEXT, pax TEXT, rtype TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Reservationdetails");

    }

    public Boolean insertReservationdata(String name, String contact, String doi, String doo, String pax, String rtype) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("doi", doi);
        contentValues.put("doo", doo);
        contentValues.put("pax", pax);
        contentValues.put("rtype", rtype);
        long result=DB.insert("Reservationdetails", null, contentValues);
        if(result==-1){
            return false;
        } else{
            return true;
        }
    }
    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from Reservationdetails", null);
        return cursor;

    }
}
