package com.example.jugabilidad2.Service;

import com.example.jugabilidad2.Entidades.Preguntas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("Preguntas/{temaid}")
    Call<List<Preguntas>> getPreguntas(@Path("temaid") int tema_id);

}
