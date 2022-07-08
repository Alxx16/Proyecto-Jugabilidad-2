package com.example.jugabilidad2.Service;

import com.example.jugabilidad2.Entidades.Reponse.ResponsePreguntas;
import com.example.jugabilidad2.Entidades.Reponse.ResponseRespuestas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("Preguntas/{temaid}")
    Call<List<ResponsePreguntas>> getPreguntas(@Path("temaid") int tema_id);

    //@GET("Respuestas/")
    //Call<List<ResponseRespuestas>> getRespuestas(@Path("temaid") int tema_id);
}
