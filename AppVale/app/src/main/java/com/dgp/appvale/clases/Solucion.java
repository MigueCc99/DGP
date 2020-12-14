package com.dgp.appvale.clases;

import java.sql.Blob;

public class Solucion {
    private String texto;
    private Blob video;

    public Solucion(){
        texto = "";
        video = null;
    }

    public String getTexto(){ return texto; }

    public Blob getVideo(){ return video; }

    public void setTexto(String texto){ this.texto = texto; }

    public void setVideo(Blob video){ this.video = video; }

}
