package com.example.vineeth.airpc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vinee_000 on 30-05-2017.
 */

public class MyDBhandler extends SQLiteOpenHelper {
     // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "AirContent";
    // Places table
    private static final String TABLE_PLACES_INFO = "PlacesInfo";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AMOUNT_OF_CO = "amountOfCo";
    private static final String KEY_AMOUNT_OF_NO = "amountOfNo";
    private static final String KEY_AMOUNT_OF_NO2 = "amountOfNo2";
    private static final String KEY_AMOUNT_OF_O3 = "amountOfO3";
    private static final String KEY_AMOUNT_OF_FINE_PARTICLES = "amountOfFineParticles";
    private static final String KEY_AMOUNT_OF_COARSE_PARTICLES = "amountOfCoarseParticles";

    public MyDBhandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLACES_INFO_TABLE = "CREATE TABLE " + TABLE_PLACES_INFO + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," +
                KEY_AMOUNT_OF_CO + " INTEGER," + KEY_AMOUNT_OF_NO + " INTEGER," +  KEY_AMOUNT_OF_NO2 + " INTEGER," +
                KEY_AMOUNT_OF_O3 + " INTEGER," + KEY_AMOUNT_OF_FINE_PARTICLES + " INTEGER," +
                KEY_AMOUNT_OF_COARSE_PARTICLES + " INTEGER" + ")";
        db.execSQL(CREATE_PLACES_INFO_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACES_INFO);

        // Create tables again
        onCreate(db);
    }

    public void addPlace(Place place) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, place.getName());
        values.put(KEY_AMOUNT_OF_CO, place.getAmountOfCo());
        values.put(KEY_AMOUNT_OF_NO, place.getAmountOfNo());
        values.put(KEY_AMOUNT_OF_NO2, place.getAmountOfNo2());
        values.put(KEY_AMOUNT_OF_O3, place.getAmountOfO3());
        values.put(KEY_AMOUNT_OF_FINE_PARTICLES, place.getAmountOfFineParticles());
        values.put(KEY_AMOUNT_OF_COARSE_PARTICLES, place.getAmountOfCoarseParticles());

        // Inserting Row
        db.insert(TABLE_PLACES_INFO, null, values);
        db.close(); // Closing database connection
    }

    public Place getPlace(String placeName) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT  * FROM " + TABLE_PLACES_INFO + "WHERE " + KEY_NAME + "=" + placeName;

        Cursor cursor = db.rawQuery(query,null);
        if (cursor != null)
            cursor.moveToFirst();

        Place place = new Place();
        return place;
    }

}
