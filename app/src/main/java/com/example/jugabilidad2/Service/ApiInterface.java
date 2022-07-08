package com.example.jugabilidad2.Service;


import java.util.List;

import com.example.jugabilidad2.Modelos.Jugabilidad2_PregResResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("Preguntas/{temaid}")
    Call<List<Jugabilidad2_PregResResponse>>getJ2_PreguntasRespuestas(@Path("temaid") int tema_id);

}
