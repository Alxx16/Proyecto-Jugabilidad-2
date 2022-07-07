package com.example.jugabilidad2;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.nex3z.flowlayout.FlowLayout;

public class Palabras extends AppCompatTextView {

    private String palabra;

    public Palabras(Context context, String palabra) {
        super(context);
        this.palabra=palabra;

        setText(palabra);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 15,15, 0);
        setTextColor(getResources().getColor(R.color.custom_view_text_color));
        setLayoutParams(layoutParams);
        setTextAlignment(TEXT_ALIGNMENT_CENTER);
        setTextSize(20);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.cuadro_de_palabra));
    }

    //TAMPOCO LE HAGAS CASO A ESTO XD
    public void goToViewGroup(VistaPalabras vistaPalabras, FlowLayout sentenceLine) {

        ViewParent parent = getParent();
        if(parent instanceof VistaPalabras){
            vistaPalabras.removerVistaPalabra(this);
            sentenceLine.addView(this);
        }else{
            sentenceLine.removeView(this);
            vistaPalabras.agregarVistaA(this);
        }


    }
}
