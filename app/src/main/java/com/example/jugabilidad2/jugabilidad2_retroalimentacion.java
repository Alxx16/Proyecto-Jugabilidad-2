package com.example.jugabilidad2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class jugabilidad2_retroalimentacion extends AppCompatActivity {

    Button jugabilidad2_retro_correcta_btn, jugabilidad2_retro_incorrecta_btn;
    View retro_correcta, retro_incorrecta;
    TextView r_correcta, r_incorrecta, r_felicidades_correcta, r_felicidades_incorrecta;
    ImageButton r_sonido_correcto, r_sonido_incorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugabilidad2_retroalimentacion);

        InicializarControles();
        cambiarpantalla();
    }

    private void InicializarControles() {
        jugabilidad2_retro_correcta_btn =  (Button) findViewById(R.id.jugabilidad2_retro_correcta_btn);
        jugabilidad2_retro_incorrecta_btn = (Button) findViewById(R.id.jugabilidad2_retro_incorrecta_btn);
        retro_correcta = (View) findViewById(R.id.jugabilidad2_retro_correcta);
        retro_incorrecta = (View)findViewById(R.id.jugabilidad2_retro_incorrecta);
        r_correcta = (TextView) findViewById(R.id.txtRespuesta_correcta);
        r_incorrecta = (TextView) findViewById(R.id.txtRespuesta_incorrecta);
        r_felicidades_correcta = (TextView) findViewById(R.id.txtFelicidades_correcta);
        r_felicidades_incorrecta = (TextView) findViewById(R.id.txtFelicidades_incorrecta);
        r_sonido_correcto = (ImageButton) findViewById(R.id.imgSonido_correcto);
        r_sonido_incorrecto = (ImageButton) findViewById(R.id.imgSonido_incorrecto);
    }

    private void cambiarpantalla(){
        jugabilidad2_retro_correcta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retro_incorrecta.setVisibility(View.VISIBLE);
                retro_correcta.setVisibility(View.GONE);
            }
        });

        jugabilidad2_retro_incorrecta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retro_incorrecta.setVisibility(View.GONE);
                retro_correcta.setVisibility(View.VISIBLE);
            }
        });
    }
}