package com.example.jugabilidad2.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.jugabilidad2.Helpers.DbHelper;

public class Preguntas {
    private int id;
    private int tematica_id;
    private int modo_id;
    private String pregunta;

    public Preguntas(int id, int tematica_id, int modo_id, String pregunta) {
        this.id = id;
        this.tematica_id = tematica_id;
        this.modo_id = modo_id;
        this.pregunta = pregunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTematica_id() {
        return tematica_id;
    }

    public void setTematica_id(int tematica_id) {
        this.tematica_id = tematica_id;
    }

    public int getModo_id() {
        return modo_id;
    }

    public void setModo_id(int modo_id) {
        this.modo_id = modo_id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }


    //INSERTAR UN ESTUDIANTE
    public boolean preguntasInsert(Context context){
        try{
            //Validacion de que campos en nullo o vacio
            DbHelper dbHelper = new DbHelper(context,"frograming");
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if(db!= null) {
                if (DatabaseUtils.queryNumEntries(db, "pregunta") == 0) {
                ContentValues content = new ContentValues();
                content.put("id",this.getId());
                content.put("tematica_id",this.getTematica_id());
                content.put("modo_id",this.getModo_id());
                content.put("pregunta", this.getPregunta());

                db.insert("pregunta", null, content);
                return true;
            }
            }
        }catch (Exception e){
            Toast.makeText(context,"Errocito en insercion de pregunta =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return false;
    }




}
