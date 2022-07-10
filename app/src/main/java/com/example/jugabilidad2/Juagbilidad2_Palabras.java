/*package com.example.jugabilidad2;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.nex3z.flowlayout.FlowLayout;

public class Juagbilidad2_Palabras extends AppCompatTextView {

    private String palabra;

    public Juagbilidad2_Palabras(Context context, String palabra) {
        super(context);
        this.palabra=palabra;

        setText(palabra);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 15,15, 0);
        setTextColor(getResources().getColor(R.color.custom_view_text_color));
        setLayoutParams(layoutParams);
        setTextAlignment(TEXT_ALIGNMENT_CENTER);
        setTextSize(20);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.shape_jugabilidad2_cuadro_de_palabra));
    }*/

    //TAMPOCO LE HAGAS CASO A ESTO XD
    //Colocar las respuestas en la linea
    /*public void goToViewGroup(VistaPalabras vistaPalabras, FlowLayout sentenceLine) {

        ViewParent parent = getParent();
        //cuadrados de palabra estan en su lugar y van a la linea
        if(parent instanceof VistaPalabras){
            vistaPalabras.removerVistaPalabra(this);
            sentenceLine.addView(this);
        }else{
            //cuadros de palabra de la linea regresan a su lugar
            sentenceLine.removeView(this);
            vistaPalabras.agregarVistaA(this);
        }


    }
}*/
