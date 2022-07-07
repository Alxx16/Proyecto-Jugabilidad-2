package com.example.jugabilidad2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView jugabilidad2_txtPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
    }

    private void InicializarControles() {

        jugabilidad2_txtPregunta = (TextView)findViewById(R.id.jugabilidad2_txtPregunta);
    }



}