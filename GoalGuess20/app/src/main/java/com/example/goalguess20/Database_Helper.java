package com.example.goalguess20;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Helper extends SQLiteOpenHelper {
    public static final String PLAYER_TABLE = "PLAYER_TABLE";
    public static final String COLUMN_PLAYER_NAME = "COLUMN_PLAYER_NAME";
    public static final String GLS = "COLUMN_GLS";
    public static final String COLUMN_MV = "COLUMN_MV";
    public static final String ID = "ID";

    public Database_Helper(@Nullable Context context) {

        super(context, "player.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + PLAYER_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PLAYER_NAME + "TEXT, " + GLS + "INT, " + COLUMN_MV + " FLOAT)";
        sqLiteDatabase.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addOne(databaseModel customerModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(GLS, customerModel.getGls());
        cv.put(COLUMN_MV, customerModel.getMkt_val());
        cv.put(COLUMN_PLAYER_NAME, customerModel.getPlayer_name());
        long insert = sqLiteDatabase.insert(PLAYER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }else {
        return true;
        }
    }
}
