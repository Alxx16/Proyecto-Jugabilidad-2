package com.example.jugabilidad2.Entidades.Reponse;

public class ResponsePreguntas {
    private int id;
    private int tematica_id;
    private int modo_id;
    private String pregunta;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getTematica_id() {
        return tematica_id;
    }
    public void setTematica_id(int tematica_id) {
        this.tematica_id = tematica_id;
    }

    public int getModo_id() {
        return modo_id;
    }
    public void setModo_id(int modo_id) {
        this.modo_id = modo_id;
    }

    public String getPregunta() {
        return pregunta;
    }
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

}
