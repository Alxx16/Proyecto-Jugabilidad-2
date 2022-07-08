package com.example.jugabilidad2.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.jugabilidad2.Helpers.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class Pareo {

    public Pareo(int pregunta_id, int tematica_id, int orden_pareo, String texto) {
        this.pregunta_id = pregunta_id;
        this.tematica_id = tematica_id;
        this.orden_pareo = orden_pareo;
        this.texto = texto;
    }

    public Pareo(String texto) {
        this.texto = texto;
    }

    public Pareo() {

    }

    private int pregunta_id;
    private int tematica_id;
    private int orden_pareo;
    private String texto;

    public int getPregunta_id() {
        return pregunta_id;
    }

    public void setPregunta_id(int pregunta_id) {
        this.pregunta_id = pregunta_id;
    }

    public int getTematica_id() {
        return tematica_id;
    }

    public void setTematica_id(int tematica_id) {
        this.tematica_id = tematica_id;
    }

    public int getOrden_pareo() {
        return orden_pareo;
    }

    public void setOrden_pareo(int orden_pareo) {
        this.orden_pareo = orden_pareo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean pareoInsert(Context context){
        try{
            DbHelper dbHelper = new DbHelper(context,"frograming");
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            //Cursor cursor = db.rawQuery("Select * FROM pareo",null);
            if(db!= null){
                if(DatabaseUtils.queryNumEntries(db,"pareo")==0){
                ContentValues contentValues = new ContentValues();
                contentValues.put("pregunta_id",this.getPregunta_id());
                contentValues.put("tematica_id",this.getTematica_id());
                contentValues.put("orden_pareo",this.getOrden_pareo());
                contentValues.put("texto",this.getTexto());
                //System.out.println("ENTROOOOOOOOOOOOOOOOOOOOOOO");
                db.insert("pareo",null,contentValues);
                return true;
                }
            }
        }catch (Exception e){
            Toast.makeText(context,"Error en insercion =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public List<Pareo> obtenerPareo(int pregunta,Context context){
        List<Pareo> pareo = new ArrayList<>();
        try{
            DbHelper dbHelper = new DbHelper(context,"frograming");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db!=null){
                String[] campos = new String[]{"texto"};
                Cursor cursor = db.query("pareo",campos,"pregunta_id= "+pregunta,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        Pareo pareoE = new Pareo(
                                cursor.getString(0)
                        );
                        pareo.add(pareoE);
                    }while (cursor.moveToNext());
                }
            }
        }catch (Exception e){
            Toast.makeText(context,"Error en obtener datos de pareo =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return pareo;
    }

    public int compararPareo(String texto,Context context){
        int id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context,"frograming");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db!=null){
                String[] campos = new String[]{"orden_pareo"};
                Cursor cursor = db.query("pareo",campos,"texto = " +"'"+texto+"'",null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        id = cursor.getInt(0);
                    }while (cursor.moveToNext());
                }
            }
            return id;
        } catch (SQLiteException e){
            Toast.makeText(context,"Error en obtener datos de pareo SQLiteException =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(context,"Error en obtener datos de pareo =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return 0;
    }
}
