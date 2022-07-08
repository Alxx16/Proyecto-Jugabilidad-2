package com.example.jugabilidad2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.jugabilidad2.Entidades.Preguntas;
import com.example.jugabilidad2.Entidades.Reponse.ResponsePreguntas;
import com.example.jugabilidad2.Entidades.Respuestas;
import com.example.jugabilidad2.Service.ApiService;
import com.nex3z.flowlayout.FlowLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView jugabilidad2_txtPregunta;

    FlowLayout sentenceLine;
    Palabras palabras;
    VistaPalabras vistaPalabras;

    Preguntas preguntas;
    Respuestas respuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
        //initData();
        iniDatos();
    }

    private void cargarDbTablaPregunta(){
        Call<List<ResponsePreguntas>> llamadaPregunta = ApiService.getApiService().getPreguntas(3);
        llamadaPregunta.enqueue(new Callback<List<ResponsePreguntas>>() {
            @Override
            public void onResponse(Call<List<ResponsePreguntas>> call, Response<List<ResponsePreguntas>> response) {
                List<ResponsePreguntas> listaPreguntas = response.body();

                for(ResponsePreguntas Preguntas : listaPreguntas){
                    Preguntas preguntas = new Preguntas(
                            Preguntas.getId(),
                            Preguntas.getTematica_id(),
                            Preguntas.getModo_id(),
                            Preguntas.getPregunta()
                    );
                    preguntas.preguntasInsert(getApplicationContext());
                }
            }
            @Override
            public void onFailure(Call<List<ResponsePreguntas>> call, Throwable t) {
                int x=1;
            }
        });
    }


    private void InicializarControles() {
        jugabilidad2_txtPregunta = (TextView)findViewById(R.id.jugabilidad2_txtPregunta);
        sentenceLine = (FlowLayout)findViewById(R.id.jugabilidad2_sentence_line);
    }

    /*private class TouchListener implements View.OnTouchListener{
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent){
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN && !vistaPalabras.empty()){
                palabras = (Palabras) view;
                palabras.goToViewGroup(vistaPalabras,sentenceLine);

                return true;
            }
            return false;
        }
    }*/


    /*private void initData() {

        String oracionC= "Oracion de prueba con al menos 10 palabras para completar";

        String[] palabrasOracion = oracionC.split(" ");

        for(String palabra : palabrasOracion){
            //Empezar a setear las palabras en los iconos del view
            Palabras palabras = new Palabras(getApplicationContext(), palabra);
            //
            //palabras.setOnTouchListener(new TouchListener());

            //vistaPalabras.push(palabras);

        }
    }*/

    private void iniDatos(){
        String oracionC= "Oracion de prueba con al menos 10 palabras para completar";

        String[] palabrasOracion = oracionC.split(" ");

        for(String palabra : palabrasOracion){
            Palabras palabras = new Palabras(getApplicationContext(), palabra);
            //HACER QUE APAREZCAN LAS PALABRAS EN LA PANTALLA activity_main

        }
    }


    public void traerPreguntaAleatoria(){
        //RECORDAR HACER EL SELECT JOIN DE LAS PREGUNTAS DE NUESTRO MODO
        //EXACTAMENTE COMO ESTA EL QUERY DE EN MYSQL
        //JOIN PARA FUNCIONALIDAD JUGABILIDAD 2
        //PARA TRAER ESA COMO TABLA Y ES USARLA COMO TABLA EN NUESTRA BD LOCAL DE ANDROID
        //CREARE UNA SOLA TABLA COMO ESE JOIN
        //LUEGO LLAMO AL ID DE LAS PREGUNTAS
        //LO METO A UN RANDOMIZER EL ID Y SEGUN EL ID QUE SALGA
        //TRAIGO SU PREGUNTA. SUS REPUESTAS Y SUS OPCIONES DE RESPUESTA(SI ES CORRECTO O INCORRECTO)


    }

}