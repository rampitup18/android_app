package com.example.goalguess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Helper extends SQLiteOpenHelper {
    public static final String PLAYER_TABLE = "PLAYER_TABLE";
    public static final String Column_Player_name = "Player_name";
    public static final String Column_Gls = "GLS";
    public static final String Column_MKT_val = "MKT_val";
    public static final String Column_ID = "ID";

    public Database_Helper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createSQLstatement = " CREATE TABLE " + PLAYER_TABLE + "(" + Column_ID + " INTEGER PRIMARY KEY, " + Column_Player_name + " TEXT, " + Column_Gls + " INTEGER, " + Column_MKT_val + " DOUBLE)";
        sqLiteDatabase.execSQL(createSQLstatement);
//        Cursor cursor = sqLiteDatabase.rawQuery("select * from PLAYER_TABLE",null);
//        if(cursor.getCount() == 0) {
        User user1 = new User(1, "Messi", 11, 55.00);
        User user2 = new User(2, "Ronaldo", 24, 33.00);
        User user3 = new User(3, "Lewandowski", 50, 49.50);
        onInsert(user1, sqLiteDatabase);
        onInsert(user2, sqLiteDatabase);
        onInsert(user3, sqLiteDatabase);
//        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int getRowCount() {
        Cursor cursor1 = getWritableDatabase().rawQuery("select * from PLAYER_TABLE",null);
        System.out.println("Database Row Count" + cursor1.getCount());
        return cursor1.getCount();
    }

    public boolean onInsert(User database, SQLiteDatabase sqLiteDatabase) {
//      SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues gls = new ContentValues();
        gls.put(Column_ID, database.getId());
        gls.put(Column_Player_name, database.getPlayer_name());
        gls.put(Column_MKT_val, database.getMkt_val());
        gls.put(Column_Gls, database.getGls());

        long result = sqLiteDatabase.insert(PLAYER_TABLE, null, gls);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
