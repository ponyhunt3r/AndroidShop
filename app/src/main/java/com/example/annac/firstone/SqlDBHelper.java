package com.example.annac.firstone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SqlDBHelper extends SQLiteOpenHelper {

    public static final String TAG = "ANDROID LOG";

    private static final String TABLE_NAME = "productttss";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "Company";
    private static final String COL_3 = "Model";
    private static final String COL_4 = "Price";

    public SqlDBHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    public boolean addData (String company, int price, String model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Log.d(TAG, "addData: Adding " + model + " to " + TABLE_NAME);
        contentValues.put(COL_2, company);
        contentValues.put(COL_3, price);
        contentValues.put(COL_4, model);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 + " TEXT,"
                + COL_3 + " INTEGER," + COL_4 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public Cursor getData(){
        Log.d(TAG, "get data called");
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
