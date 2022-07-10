/*package com.example.jugabilidad2;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.nex3z.flowlayout.FlowLayout;

import java.util.ArrayList;

public class VistaPalabras extends FlowLayout {

    Palabras palabras;

    private ArrayList<View> words = new ArrayList<>();

    public VistaPalabras(Context context) {
        super(context);
    }

    public void push(View word) {
        words.add(word);
        addView(word);
    }

    public void removerVistaPalabra(View view){
        palabras = new Palabras(getContext(),"");
        palabras.setBackgroundColor(getResources().getColor(R.color.empty_view));
        LinearLayout.LayoutParams parametros = new LinearLayout.LayoutParams(view.getWidth(),view.getHeight());
        parametros.setMargins(15,15,15,0);
        palabras.setLayoutParams(parametros);
        removeView(view);
        addView(palabras, words.indexOf(view));
    }

    public void agregarVistaA(View view) {
        if (getChildAt(words.indexOf(view)) != null){
            removeViewAt(words.indexOf(view));
            addView(view, words.indexOf(view));
        }else{
            addView(view,getChildCount());
        }
    }

    public boolean empty() {
        return words.isEmpty();
    }
}*/
