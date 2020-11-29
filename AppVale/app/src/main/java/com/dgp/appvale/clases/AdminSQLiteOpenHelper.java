package com.dgp.appvale.clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*
    Class: AdminSQLiteOpenHelper.
    Description: Representa el SGBD de la app.
    Author: Miguel Ángel Campos Cubillas
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE SOCIOS (nombre text primary key, apellidos text, fechaNacimiento text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
