package com.example.jugabilidad2.Controllers;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jugabilidad2.Helpers.DbHelper;
import com.example.jugabilidad2.Modelos.Preguntas;
import com.example.jugabilidad2.Service.ApiInterface;
import com.example.jugabilidad2.Service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Jugabilidad {
    private ApiInterface api;
    private Context context;
    SharedPreferencesController sp = new SharedPreferencesController();


    public Jugabilidad (Context context) {
        this.context = context;
    }

    public void obtenerDatosJugabilidad(int id) {
        api = ApiService.getApiService();

        Call<List<Preguntas>> call = api.getPreguntas(id);
        call.enqueue(new Callback<List<Preguntas>>() {

            @Override
            public void onResponse(Call<List<Preguntas>> call, Response<List<Preguntas>> response) {
                if(response.isSuccessful()) {
                    Preguntas.actualizarPreguntas(context);
                    List<Preguntas> preguntas = Preguntas.reordenarPreguntas(response.body());
                    for(Preguntas preg : preguntas) {
                        preg.guardarPreguntas(context, preg);
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Preguntas>> call, Throwable t) {
            }
        });
    }

    public Intent cambiarModo() {
        Intent modo = null;
        int id = obtenerSiguientePreguntaId();
        int id_modo = obtenerIdModo(id);
        switch (id_modo) {
            case 0:
                //modo = new Intent(context, PuntosTotalesActivity.class);
                break;
            case 1:
                //modo = new Intent(context, Modo1_Activity.class);
                break;
            case 2:
                //modo = new Intent(context, Modo2_Activity.class);
                break;
            case 3:
                //modo = new Intent(context, Modo3_Activity.class);
                break;
            case 4:
                //modo = new Intent(context, Modo4_Activity.class);
                break;
        }

        return modo;
    }

    public int validarCantidadModos(int id) {
        int id_preg = 0;

        return id_preg;
    }

    public int obtenerSiguientePreguntaId() {   //preguntas_id = 5,8,2,
        int id_preg = -1;
        int cantidad_preguntas = 0;

        String ids = sp.leer(context,"preguntas_id");

        if(!ids.equals("")) {
            String []aux = ids.split(",");
            cantidad_preguntas = aux.length;

            if(cantidad_preguntas == Preguntas.CANTIDAD_PREGUNTAS ) {
                sp.guardar(context, "preguntas_id", "");
                return 0;
            }

            if(cantidad_preguntas > 0 ) {
                id_preg = obtenerPreguntaId(true);
            }
        } else {
            id_preg = obtenerPreguntaId(false);
        }

        return id_preg;
    }

    public List<Preguntas> getPregunta(int id_preg) {
        List<Preguntas> preguntas = new ArrayList<>();
        String query = "SELECT pregunta_id, tematica_id, modo, pregunta, respuesta, retroalimentacion, opc FROM preguntas_respuestas WHERE pregunta_id = "+id_preg;
        try {
            DbHelper dbHelper = new DbHelper(context, "proyecto_ds6");
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            if(db != null) {

                Cursor c = db.rawQuery(query, null);
                if(c.moveToFirst()) {
                    do {
                        Preguntas preg = new Preguntas();
                        preg.setId(c.getInt(0));
                        preg.setTematica_id(c.getInt(1));
                        preg.setModo_id(c.getInt(2));
                        preg.setPregunta(c.getString(3));
                        preg.setOpcion_resp(c.getString(4));
                        preg.setRetroalimentacion(c.getString(5));
                        preg.setRespuesta(c.getInt(6));
                        preguntas.add(preg);
                    } while (c.moveToNext());
                }
            }
        } catch (Exception e) {
        }

        return preguntas;
    }

    public int obtenerIdModo(int id_preg) {
        int modo = 0;
        String query = "";
        if(id_preg == 0) return 0;

        try {
            query = "SELECT modo FROM preguntas_respuestas WHERE pregunta_id = "+id_preg;
            DbHelper dbHelper = new DbHelper(context, "proyecto_ds6");
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            if(db != null) {

                Cursor c = db.rawQuery(query, null);
                if(c.moveToFirst()) {
                    modo = c.getInt(0);
                }
            }
        } catch (Exception e) {
        }

        return modo;
    }


    public int obtenerPreguntaId(boolean cant_preg) {
        int id = 0;
        String query = "";

        if(cant_preg){
            String ids = sp.leer(context,"preguntas_id"); //
            ids = ids.substring(0, ids.length()-1);

            query = "SELECT pregunta_id FROM preguntas_respuestas WHERE pregunta_id NOT IN ("+ids+") LIMIT 1";
        } else {
            query = "SELECT pregunta_id FROM preguntas_respuestas LIMIT 1";
        }

        try {
            DbHelper dbHelper = new DbHelper(context, "proyecto_ds6");
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            if(db != null) {

                Cursor c = db.rawQuery(query, null);

                if(c.moveToFirst()) {
                    id = c.getInt(0);
                }
            }
        } catch (Exception e) {
            int x = 0;
        }

        if(cant_preg){
            String ids = sp.leer(context,"preguntas_id");
            String nuevoIds = ids+id;
            sp.guardar(context, "preguntas_id", nuevoIds+",");
        } else {
            sp.guardar(context, "preguntas_id", id+",");
        }

        return id;
    }

}
