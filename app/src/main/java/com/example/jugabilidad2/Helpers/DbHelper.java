package com.example.jugabilidad2.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jugabilidad2.R;

public class DbHelper extends SQLiteOpenHelper {

    private String preguntaRespuesta = "CREATE TABLE preguntaRespuesta (id INTEGER PRIMARY KEY AUTOINCREMENT, modo_id INTEGER, tematica_id INTEGER, pregunta TEXT, opcion_resp TEXT, retroalimentacion TEXT, respuesta INTEGER)";

    public DbHelper(Context context, String dbName){
        super(context,dbName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       sqLiteDatabase.execSQL(preguntaRespuesta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

}
