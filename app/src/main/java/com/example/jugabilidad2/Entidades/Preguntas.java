package com.example.jugabilidad2.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.jugabilidad2.Helpers.DbHelper;
//import com.example.jugablidad_1.Helper.DbHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preguntas {
    private int id;
    private int modo_id;
    private int tematica_id;
    private String pregunta;
    private String opcion_resp;
    private String retroalimentacion;
    private int respuesta;

    public static final int CANTIDAD_PREGUNTAS = 10;


    public static void actualizarPreguntas(Context context) {
        DbHelper dbHelper = new DbHelper(context, "proyecto_ds6");
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String tabla = "preguntas_respuestas";
        try {
            db.delete(tabla, null, null);
        } catch (Exception e) {}
    }

    public void guardarPreguntas(Context context, Preguntas preguntas) {
        try {
            DbHelper dbHelper = new DbHelper(context, "proyecto_ds6");
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            int x = 0;
            if(db != null) {
                ContentValues content = new ContentValues();
                content.put("pregunta_id",preguntas.getId());
                content.put("tematica_id",preguntas.getTematica_id());
                content.put("modo",preguntas.getModo_id());
                content.put("pregunta",preguntas.getPregunta());
                content.put("respuesta",preguntas.getOpcion_resp());
                content.put("retroalimentacion",preguntas.getRetroalimentacion());
                content.put("opc",preguntas.getRespuesta());

                db.insert("Preguntas_respuestas",null,content);
            }
        } catch (Exception e) {
            Toast.makeText(context, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static List<Preguntas> reordenarPreguntas(List<Preguntas> preguntas) {
        Collections.shuffle(preguntas);
        return preguntas;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModo_id() {
        return modo_id;
    }

    public void setModo_id(int modo_id) {
        this.modo_id = modo_id;
    }

    public int getTematica_id() {
        return tematica_id;
    }

    public void setTematica_id(int tematica_id) {
        this.tematica_id = tematica_id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion_resp() {
        return opcion_resp;
    }

    public void setOpcion_resp(String opcion_resp) {
        this.opcion_resp = opcion_resp;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
}
