package com.example.jugabilidad2;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.jugabilidad2.Controllers.Jugabilidad;
import com.example.jugabilidad2.Modelos.Preguntas;
import com.example.jugabilidad2.Controllers.SharedPreferencesController;
import com.nex3z.flowlayout.FlowLayout;

import java.util.List;

public class Jugabilidad2Modo3_Activity extends AppCompatActivity {

    TextView jugabilidad2_txtPregunta;
    GridView jugabilidad2_grdPalabras;
    FlowLayout sentenceLine;

    SharedPreferencesController spp = new SharedPreferencesController();

    //Jugabilidad2_Palabras preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugabilidad2_modo3);
       // InicializarControles();
        this.obtenerInfoPregunta();

      //  inicicializarDatos();
    }
    
    private void InicializarControles() {
        jugabilidad2_txtPregunta = (TextView)findViewById(R.id.jugabilidad2_txtPregunta);
        sentenceLine = (FlowLayout)findViewById(R.id.jugabilidad2_sentence_line);
        jugabilidad2_grdPalabras = (GridView)findViewById(R.id.jugabilidad2_grdPalabras);
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


    private void obtenerInfoPregunta() {
        Jugabilidad jugabildad = new Jugabilidad(this);
        String ids = spp.leer(this,"preguntas_id");
        String [] aux = ids.split(",");
        int id = Integer.parseInt(aux[aux.length-1]);


        //ARRAYLIST CON LOS DATOS DE LA PREGUNTA
        List<Preguntas> preguntas = jugabildad.getPregunta(id);





    }

}