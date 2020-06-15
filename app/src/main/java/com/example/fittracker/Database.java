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

public static final String DATABASE_NAME = "ProgramData1";
public static final String TABLE_NAME = "TABLE_NAME";
public static final String COLUMN_ID = "ID";
public static final String COLUMN_NAME = "COLUMN_NAME";
public static final String COLUMN_PROGRAM = "COLUMN_PROGRAM";


    public Database(@Nullable Context context) {
        super(context, "Program.db",null, 3);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + TABLE_NAME  + "(" + COLUMN_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT," + COLUMN_PROGRAM + " TEXT ) ";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Program program) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, program.getName());
        cv.put(COLUMN_PROGRAM, program.getProgramName());


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
                String plan = cursor.getString(2);

                Program newProgram = new Program(programName, programId, plan);
                listProgram.add(newProgram);

            }while(cursor.moveToNext());
        }
        else
        {
            cursor.close();
            db.close();
            return listProgram;
        }

        return listProgram;
    }
}
