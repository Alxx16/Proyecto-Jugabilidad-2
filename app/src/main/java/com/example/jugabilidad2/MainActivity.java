package com.example.jugabilidad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;

import com.nex3z.flowlayout.FlowLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView jugabilidad2_txtPregunta;

    FlowLayout sentenceLine;
    Palabras palabras;
    VistaPalabras vistaPalabras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
        //initData();
        iniDatos();
    }

    private void InicializarControles() {
        jugabilidad2_txtPregunta = (TextView)findViewById(R.id.jugabilidad2_txtPregunta);
        sentenceLine = (FlowLayout)findViewById(R.id.jugabilidad2_sentence_line);


    }

    private class TouchListener implements View.OnTouchListener{
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent){
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN && !vistaPalabras.empty()){
                palabras = (Palabras) view;
                palabras.goToViewGroup(vistaPalabras,sentenceLine);

                return true;
            }
            return false;
        }
    }


    /*private void initData() {

        String oracionC= "Oracion de prueba con al menos 10 palabras para completar";

        String[] palabrasOracion = oracionC.split(" ");

        for(String palabra : palabrasOracion){
            //Empezar a setear las palabras en los iconos del view
            Palabras palabras = new Palabras(getApplicationContext(), palabra);
            //
            //palabras.setOnTouchListener(new TouchListener());
            //
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


}