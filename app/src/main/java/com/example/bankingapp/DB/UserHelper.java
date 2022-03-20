package com.example.bankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bankingapp.DB.UserContract.UserEntry;
import com.example.bankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7667,'Mayuri Narkhede', 'mayuri5401@gmail.com','7358','9985214636', 60000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8526,'sachin chopade', 'sachin@gmail.com','2158','7997456324', 78000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9705,'Dipali chopade', 'dipali@gmail.com','9868','7541132567', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5241,'gaurang choapde', 'gaurang@gmail.com','5277','9995640038', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1474,'janhvi supekar', 'janhvi@gmail.com','6554','7896532451', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6782,'nikita gadhve', 'nikita@gmail.com','8876','8977451136', 9500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7685,'komal patil', 'komal@gmail.com','2178','7865478963', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8753,'yugal mali', 'yugalmali8@gmail.com','3255','7768884864', 56566)");
        db.execSQL("insert into " + TABLE_NAME + " values(5322,'saakshi khabale', 'saakshi khabale@gmail.com','7592','9307452108', 11500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6536,'anil thapa', 'saakshi@gmail.com','4755','876654988', 8900)");
        db.execSQL("insert into " + TABLE_NAME + " values(9851,'krutika pandit', 'kru@gmail.com','3233','9011675489', 9700)");
        db.execSQL("insert into " + TABLE_NAME + " values(6218,'Ganesh chopade', 'ganesh@gmail.com','7321','7756837521', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4223,'manu patil', 'manupatil@gmail.com','5589','6303527651', 4800)");
        db.execSQL("insert into " + TABLE_NAME + " values(5437,'vanita narkede', 'vanita@gmail.com','4487','6276554305', 43700)");
        db.execSQL("insert into " + TABLE_NAME + " values(3779,'kanchan s c.', 'kanchangmail.com','5597','7889547661', 32000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}