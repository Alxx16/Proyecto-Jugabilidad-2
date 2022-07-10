package com.example.jugabilidad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class jugabilidad2_retroalimentacion extends AppCompatActivity {

    Button jugabilidad2_retro_correcta_btn;
    TextView r_felicidades_correcta;
    ImageButton r_sonido_correcto;
    ImageView imgcheck, imglogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugabilidad2_retroalimentacion);

        InicializarControles();
        Validar();
    }

    private void InicializarControles() {
        jugabilidad2_retro_correcta_btn = (Button) findViewById(R.id.jugabilidad2_retro_correcta_btn);
        r_felicidades_correcta = (TextView) findViewById(R.id.txtFelicidades_correcta);
        r_sonido_correcto = (ImageButton) findViewById(R.id.imgSonido_correcto);

        imgcheck = (ImageView) findViewById(R.id.imgcheck);
        imglogo = (ImageView) findViewById(R.id.imgLogo);
    }

    private void Validar(){
        //Intent intent = getIntent();
        //int validar = intent.getIntExtra("validarrespuesta", 0);
        //String retro =  intent.getStringExtra("retroalimentacion");
        int validar = 0;

        if(validar == 1){
            r_felicidades_correcta.setText("Felicidades");
            imgcheck.setImageResource(R.drawable.aceptar);
            imglogo.setImageResource(R.drawable.luna_mascota);
        }else if(validar == 0){
            r_felicidades_correcta.setText("Respuesta incorrecta");
            imgcheck.setImageResource(R.drawable.cancelar);
            imglogo.setImageResource(R.drawable.respuesta_incorrecta);
        }
    }
}