package com.example.jugabilidad2.Entidades;

public class Respuestas {
    private int id;
    private int pregunta_id;
    private String opcion_resp;
    private String retroalimentacion;
    private String respuesta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPregunta_id() {
        return pregunta_id;
    }

    public void setPregunta_id(int pregunta_id) {
        this.pregunta_id = pregunta_id;
    }

    public String getOpcion_resp() {
        return opcion_resp;
    }

    public void setOpcion_resp(String opcion_resp) {
        this.opcion_resp = opcion_resp;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
