package com.example.jugabilidad2.Modelos;

public class Jugabilidad2_PregResResponse {

        private int modo_id;
        private int tematica_id;
        private String pregunta;
        private String opcion_resp;
        private String retroalimentacion;
        private int respuesta;

        public int getModo_id() {
            return modo_id;
        }
        public void setModo_id(int modo_id) {
            this.modo_id = modo_id;
        }

        public int getTematica_id() {
            return tematica_id;
        }
        public void setTematica_id(int tematica_id) {
            this.tematica_id = tematica_id;
        }

        public String getPregunta() {
            return pregunta;
        }
        public void setPregunta(String pregunta) {
            this.pregunta = pregunta;
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
        public void setRetroalimentacion(String retroalimentacion) {this.retroalimentacion = retroalimentacion;}

        public int getRespuesta() {
            return respuesta;
        }
        public void setRespuesta(int respuesta) {
            this.respuesta = respuesta;
        }

    }
