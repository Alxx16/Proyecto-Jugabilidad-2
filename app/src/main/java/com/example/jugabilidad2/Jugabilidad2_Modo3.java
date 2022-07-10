package com.example.jugabilidad2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jugabilidad2.Entidades.J2_PreguntasRespuestas;
import com.example.jugabilidad2.Modelos.Jugabilidad2_PregResResponse;
import com.example.jugabilidad2.Service.ApiService;
import com.nex3z.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Jugabilidad2_Modo3 extends AppCompatActivity {

    TextView jugabilidad2_txtPregunta;

    FlowLayout sentenceLine;
    Jugabilidad2_PregResResponse pregResResponse;

    //Jugabilidad2_Palabras preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugabilidad2_modo3);
       // InicializarControles();
        cargarDbTablaPregunta();
        cargarPreguntasRespuestas();

      //  inicicializarDatos();
    }
    //Cargar BD de la tabla que tendra todos los datos de la preguntas y respuestas.
    private void cargarDbTablaPregunta(){
        Call<List<Jugabilidad2_PregResResponse>> llamadaPregunta = ApiService.getApiService().getJ2_PreguntasRespuestas(1);
        llamadaPregunta.enqueue(new Callback<List<Jugabilidad2_PregResResponse>>() {
            @Override
            public void onResponse(Call<List<Jugabilidad2_PregResResponse>> call, Response<List<Jugabilidad2_PregResResponse>> response) {
                List<Jugabilidad2_PregResResponse> listaPreguntas = response.body();

                for(Jugabilidad2_PregResResponse Preguntas : listaPreguntas){
                    J2_PreguntasRespuestas preguntas = new J2_PreguntasRespuestas(
                            Preguntas.getModo_id(),
                            Preguntas.getTematica_id(),
                            Preguntas.getPregunta(),
                            Preguntas.getOpcion_resp(),
                            Preguntas.getRetroalimentacion(),
                            Preguntas.getRespuesta()
                    );
                    preguntas.preguntastInsert(getApplicationContext());
                }

            }
            @Override
            public void onFailure(Call<List<Jugabilidad2_PregResResponse>> call, Throwable t) {
                int x=1;
            }
        });
    }


    private void InicializarControles() {
        jugabilidad2_txtPregunta = (TextView)findViewById(R.id.jugabilidad2_txtPregunta);
        sentenceLine = (FlowLayout)findViewById(R.id.jugabilidad2_sentence_line);
    }


    private void inicicializarDatos(){
        String oracionC= "Oracion de prueba con al menos 10 palabras para completar";

        String[] palabrasOracion = oracionC.split(" ");

        for(String palabra : palabrasOracion){
            //Juagbilidad2_Palabras palabras = new Juagbilidad2_Palabras(getApplicationContext(), palabra);
            //HACER QUE APAREZCAN LAS PALABRAS EN LA PANTALLA activity_main
            //RELLENAR GRID VIEW

        }
    }


    public void cargarPreguntasRespuestas(){
        List<String> PreguntaOpcionCorrecta = new ArrayList<>();
        List<String> PreguntaOpcionIncorrecta = new ArrayList<>();

        J2_PreguntasRespuestas pregResp = new J2_PreguntasRespuestas();
        int idAleatorio = pregResp.obtenerIdPreguntas(getApplicationContext());


        PreguntaOpcionCorrecta= pregResp.obtenerDatosPregunta1(getApplicationContext(), idAleatorio);
        PreguntaOpcionIncorrecta= pregResp.obtenerDatosPregunta2(getApplicationContext(), idAleatorio);

        for (String model : PreguntaOpcionCorrecta) {
            System.out.println(model);
        }
        for (String model : PreguntaOpcionIncorrecta) {
            System.out.println(model);
        }


    }

}