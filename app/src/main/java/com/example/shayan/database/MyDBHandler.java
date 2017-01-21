package com.example.shayan.database;

/**
 * Created by shayan on 1/21/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="inventory.db";
    private String TABLE_PRODUCTS ="products";
    private String COLUMN_ID="_id";
    private String COLUMN_Pname="PName";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_Pname + " TEXT" +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query ="DROP TABLE IF EXISTS " + TABLE_PRODUCTS ;
        db.execSQL(query);
        onCreate(db);

    }

    public void addProduct(Products products){
        ContentValues values = new ContentValues();
        values.put(COLUMN_Pname,products.getPName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,values);
       // db.close();
    }

    public void delProduct(String pname){
        String query ="DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_Pname + "=\"" + pname +"\";";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }

    public String DatabaseToString(){
        String dbstring="";
        SQLiteDatabase db = getWritableDatabase();
        String query ="SELECT * FROM " + TABLE_PRODUCTS;
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        while (c.moveToNext()){
            dbstring += c.getString(c.getColumnIndex("PName"));
            dbstring += "\n";


        }
    db.close();
    return dbstring;
    }
}
