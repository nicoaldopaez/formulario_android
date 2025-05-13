package com.examen.formulariopractica.Activitys;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSqlite extends SQLiteOpenHelper {

    private String sqlCreate = "CREATE TABLE personas(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT, edad INTEGER)";

    public AdminSqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase){

        sqLiteDatabase.execSQL(sqlCreate);

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS personas");
        sqLiteDatabase.execSQL(sqlCreate);
    }


}
