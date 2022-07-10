/*package com.example.jugabilidad2.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.jugabilidad2.Helpers.DbHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class J2_PreguntasRespuestas {
    private int modo_id;
    private int tematica_id;
    private String pregunta;
    private String opcion_resp;
    private String retroalimentacion;
    private int respuesta;

    public J2_PreguntasRespuestas(){

    }

    public J2_PreguntasRespuestas(int modo_id, int tematica_id, String pregunta, String opcion_resp, String retroalimentacion, int respuesta) {
        this.modo_id = modo_id;
        this.tematica_id = tematica_id;
        this.pregunta = pregunta;
        this.opcion_resp = opcion_resp;
        this.retroalimentacion = retroalimentacion;
        this.respuesta = respuesta;
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
    public void setRetroalimentacion(String retroalimentacion) {this.retroalimentacion = retroalimentacion;}

    public int getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }


    public boolean preguntastInsert(Context context){
        try{
            //Validacion de que campos en nullo o vacio
            DbHelper dbHelper = new DbHelper(context,"frograming");
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            if(db!= null){
                ContentValues content = new ContentValues();
                content.put("modo_id",this.getModo_id());
                content.put("tematica_id",this.getTematica_id());
                content.put("pregunta",this.getPregunta());
                content.put("opcion_resp",this.getOpcion_resp());
                content.put("retroalimentacion",this.getRetroalimentacion());
                content.put("respuesta",this.getRespuesta());

                db.insert("preguntaRespuesta",null,content);
                return true;
            }
        }catch (Exception e){
            Toast.makeText(context,"Errocito en insercion de las preguntas y respuestas =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return false;
    }

    //Obtener IDs de las preguntas para guardarlas en un List y hacer un Random de ese list y sacar el idAleatorio y enviarlo al main para usarlo en otro metodo
    public int obtenerIdPreguntas(Context context){
        List<Integer> idPreguntas = new ArrayList<>();
        int idAleatorio;
        try{
            //Validacion de que campos en nullo o vacio
            DbHelper dbHelper = new DbHelper(context,"frograming");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db!= null){
                String[] campos = new String[]{"id"};

                //where modo_id=3
                                                                         //Where       el id          agrupar por              ordenar
                Cursor cursor = db.query("preguntaRespuesta",campos,"modo_id= "+ 3,null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        idPreguntas.add(cursor.getInt(0));
                    }while (cursor.moveToNext());
                }
            }
        }catch (Exception e){
            Toast.makeText(context,"Errocito en select de ID PREGUNTAS =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        //RANDOMIZEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEER
        //Random rand = new Random();
        idAleatorio=idPreguntas.get(new Random().nextInt(idPreguntas.size()));
        return idAleatorio;
    }

    //Este metodo va ser para sacar los datos de las preguntas CORRECTAS.
    // Solamente el texto de la pregunta, el texto de la opcion (los datos correctos) y si es correcta (osea 1)
    public List<String> obtenerDatosPregunta1 (Context context, int idAleatorio){
        List<String> PreguntaOpcionCorrecta = new ArrayList<>();
        try{
            //Validacion de que campos en nullo o vacio
            DbHelper dbHelper = new DbHelper(context,"frograming");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db!= null){
                String[] campos = new String[]{"pregunta","opcion_resp","respuesta"};
                //where id = idAleatorio
                                                                        //Where       el id          agrupar por              ordenar
                Cursor cursor = db.query("preguntaRespuesta",campos,"id= "+ idAleatorio+ " AND respuesta = 1",null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        PreguntaOpcionCorrecta.add(cursor.getString(0));
                        PreguntaOpcionCorrecta.add(cursor.getString(1));
                        PreguntaOpcionCorrecta.add(String.valueOf(cursor.getInt(2)));
                    }while (cursor.moveToNext());
                }
            }
        }catch (Exception e){
            Toast.makeText(context,"Errocito en select de traer los datos de correcta. =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return PreguntaOpcionCorrecta;
    }

    //Este metodo va ser para sacar los datos de las preguntas INCORRECTAS.
    // Solamente el texto de las palabras incorrectas, y lo que indica que es incorrecta (0).
    public List<String> obtenerDatosPregunta2 (Context context, int idAleatorio){
        List<String> PreguntaOpcionIncorrecta = new ArrayList<>();
        try{
            //Validacion de que campos en nullo o vacio
            DbHelper dbHelper = new DbHelper(context,"frograming");
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            if(db!= null){
                String[] campos = new String[]{"opcion_resp","respuesta"};
                //where id = idAleatorio
                //Where       el id          agrupar por              ordenar
                Cursor cursor = db.query("preguntaRespuesta",campos,"id= "+ idAleatorio+ " AND respuesta = 0",null,null,null,null);
                if(cursor.moveToFirst()){
                    do {
                        PreguntaOpcionIncorrecta.add(cursor.getString(0));
                        PreguntaOpcionIncorrecta.add(String.valueOf(cursor.getInt(1)));
                    }while (cursor.moveToNext());
                }
            }
        }catch (Exception e){
            Toast.makeText(context,"Errocito en select de traer los datos de correcta. =>"+e.getMessage(),Toast.LENGTH_LONG).show();
        }
        return PreguntaOpcionIncorrecta;
    }

}*/
