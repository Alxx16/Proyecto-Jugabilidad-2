package com.example.jugabilidad2.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jugabilidad2.R;

public class DbHelper extends SQLiteOpenHelper {

    private String pregunta = "CREATE TABLE pregunta (id INTEGER PRIMARY KEY AUTOINCREMENT, tematica_id INTEGER, modo_id INTEGER, pregunta TEXT)";
    private String respuesta = "CREATE TABLE respuesta (id INTEGER PRIMARY KEY AUTOINCREMENT, pregunta_id INTEGER, opcion_resp TEXT, retroalimentacion TEXT, respuesta TEXT)";

    public DbHelper(Context context, String dbName){
        super(context,dbName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(pregunta);
        sqLiteDatabase.execSQL(respuesta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

}
