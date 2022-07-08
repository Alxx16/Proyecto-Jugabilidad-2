package com.example.jugabilidad2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jugabilidad2.Adapter.PareoListviewAdapter;
import com.example.jugabilidad2.Entidades.Pareo;
import com.example.jugabilidad2.Entidades.Responses.PareoResponse;
import com.example.jugabilidad2.Services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityPareo extends AppCompatActivity {

    private ListView lstPareo;
    private ListView lstPareo2;
    private String opcPareo1,opcPareo2;
    private int idPareo1,idPareo2,avance=0;
    private View view1,view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InicializarControles();
        CargarDbTablaPareo();
        //startActivity(new Intent(this, PareoActivity.class));
    }

    private void InicializarControles() {
        lstPareo = (ListView)findViewById(R.id.lstPareo1);
        lstPareo2 = (ListView)findViewById(R.id.lstPareo2);
        CargarListView();
        CargarListView2();
        AttachEvent();
    }

    private void CargarListView() {
        List<Pareo> pareo = new Pareo().obtenerPareo(31,getApplicationContext());
        List<Pareo> pareosdivision = new ArrayList<>();
        PareoListviewAdapter adapter = new PareoListviewAdapter(getApplicationContext(),pareosdivision);
        for (int i= 0; i < 5; i++){
            pareosdivision.add(pareo.get(i));
        }
        lstPareo.setAdapter(adapter);
    }

    private void CargarListView2() {
        List<Pareo> pareo = new Pareo().obtenerPareo(31,getApplicationContext());
        List<Pareo> pareosdivision = new ArrayList<>();
        PareoListviewAdapter adapter = new PareoListviewAdapter(getApplicationContext(),pareosdivision);
        for (int i= 5; i < 10; i++){
            pareosdivision.add(pareo.get(i));
        }
        lstPareo2.setAdapter(adapter);
    }

    private void AttachEvent(){
        Pareo pareo = new Pareo();
        lstPareo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //lstPareo.setBackgroundColor(getColor(R.color.white));
                //view.setBackgroundColor(getColor(R.color.teal_200)) ;
                view.setBackgroundColor(Color.CYAN) ;
                TextView txt = (TextView) view.findViewById(R.id.lblPareoTemplate);
                view1=view.findViewById(R.id.lblPareoTemplate);
                //String s = txt.getText().toString();
                opcPareo1 = txt.getText().toString();
                //System.out.println(opcPareo1);
                idPareo1= pareo.compararPareo(opcPareo1,getApplicationContext());
                System.out.println(idPareo1);
                compararPreguntas(idPareo1,idPareo2);
            }
        });

        lstPareo2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setBackgroundColor(Color.CYAN) ;
                TextView txt = (TextView) view.findViewById(R.id.lblPareoTemplate);
                view2=view.findViewById(R.id.lblPareoTemplate);
                //String s = txt.getText().toString();
                opcPareo2 = txt.getText().toString();
                //System.out.println(opcPareo2);
                idPareo2= pareo.compararPareo(opcPareo2,getApplicationContext());
                System.out.println(idPareo2);
                compararPreguntas(idPareo1,idPareo2);
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void compararPreguntas(int p1, int p2){
        if(opcPareo1!=null && opcPareo2!=null){
            if(p1==p2){
                view1.setBackgroundColor(Color.WHITE);
                view2.setBackgroundColor(Color.WHITE);
                view1.setEnabled(false);
                view2.setEnabled(false);
                view1.setClickable(false);
                view2.setClickable(false);
                view1.setFocusableInTouchMode(false);
                view2.setFocusableInTouchMode(false);
                view1.setFocusable(false);
                view2.setFocusable(false);
                //view1.setSelected(false);
                //view1.setSelected(false);
                //view1.setVisibility(View.INVISIBLE);
                //view2.setVisibility(View.INVISIBLE);
                view1= null;
                view2= null;
                opcPareo1=null;
                opcPareo2=null;
                avance = avance + 1;
                if(avance == 5){
                    Toast.makeText(this,"CARAIJO MUCHACHO TERMINASTE MARAVILLOSO",Toast.LENGTH_LONG).show();
                }
                //return 1;
            }else{
                view1.setBackgroundColor(Color.WHITE) ;
                view2.setBackgroundColor(Color.WHITE) ;
                //view2.setBackgroundColor(getColor(R.color.white));
                view1= null;
                view2= null;
                opcPareo1=null;
                opcPareo2=null;
                //return 0;
            }
        }
        //return 3;
    }

    private void CargarDbTablaPareo(){
        //LLAMADA DE END POINT PARA OBTENER DATOS
        //DECLARACIÓN DE LIST IGUAL AL DE RESPONSE PARA GUARDADO DE DATOS
        Call<List<PareoResponse>> llamadoPareo = ApiService.getApiService().obtenerListadoPareo();
        llamadoPareo.enqueue(new Callback<List<PareoResponse>>() {
            @Override
            public void onResponse(Call<List<PareoResponse>> call, Response<List<PareoResponse>> response) {
                //PASAR DATOS DEL CUERPO HACIA UNA LISTA SIN EL CALL
                List<PareoResponse> listaProductos = response.body();
                //PRIMERAMENTE SE PONE EL PareoResponse y se le asigna un nombre de variable y luego : la variable lista
                for(PareoResponse PareoB : listaProductos ){
                    //Se utiliza una entidad Pareo con el constructor ya definido y se utilizan los gets
                    Pareo pareo = new Pareo(
                            PareoB.getPregunta_id(),
                            PareoB.getTematica_id(),
                            PareoB.getOrden_pareo(),
                            PareoB.getTexto()
                            );
                    //Se inserta los datos en la base de datos
                    pareo.pareoInsert(getApplicationContext());
                }
            }
            @Override
            public void onFailure(Call<List<PareoResponse>> call, Throwable t) {
                int x=1;
            }
        });
    }
}