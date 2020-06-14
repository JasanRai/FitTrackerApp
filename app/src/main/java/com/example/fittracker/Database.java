package com.example.fittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

public static final String DATABASE_NAME = "Program.db";
public static final String TABLE_NAME = "TABLE_NAME";
public static final String Program_ID = "ID";
public static final String Program_NAME = "NAME";


    public Database(@Nullable Context context) {
        super(context, "program.db",null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME  + "(" + Program_ID + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "+ Program_NAME + "TEXT) ";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Program program) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Program_NAME, program.getName());


        long insert = db.insert(TABLE_NAME, null, cv);
        if(insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public List<Program> getAllProgram()
    {
        List<Program> listProgram = new ArrayList<>();

        String queryString = "Select * FROM " + TABLE_NAME ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst())
        {
            do{
                int programId = cursor.getInt(0);
                String programName = cursor.getString(1);

                Program newProgram = new Program(programName, programId);
                listProgram.add(newProgram);

            }while(cursor.moveToNext());
        }
        else
        {

        }

        return listProgram;
    }
}
