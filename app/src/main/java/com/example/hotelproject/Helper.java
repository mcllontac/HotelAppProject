package com.example.hotelproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Helper extends SQLiteOpenHelper {

    public Helper(Context context) {
        super(context, "Details.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Reservationdetails(name TEXT primary key, contact TEXT, doi TEXT, doo TEXT, pax TEXT, rtype TEXT, rnum TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Reservationdetails");

    }

    public Boolean insertReservationdata(String name, String contact, String doi, String doo, String pax, String rtype, String rnum) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("doi", doi);
        contentValues.put("doo", doo);
        contentValues.put("pax", pax);
        contentValues.put("rtype", rtype);
        contentValues.put("rnum", rnum);
        long result=DB.insert("Reservationdetails", null, contentValues);
        if(result==-1){
            return false;
        } else
            return true;

    }
    public Boolean checkName(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Reservationdetails where name = ?", new String[] {name});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;

    }
    public Boolean checkNameRnum(String name, String rnum) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Reservationdetails where name = ? and rnum =?", new String[] {name, rnum});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Cursor viewData(String name, String rnum){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Reservationdetails where name =? and rnum =?",new String[] {name, rnum} );
        return cursor;
    }
}
