package com.dgp.appvale.clases;

public class Objetivo {
    private String nombre;
    private String descripcionObjetivo;
    int imgFoto;

    public Objetivo (){
        this.nombre = "Objetivo por defecto";
        this.descripcionObjetivo = "Descripción por defecto";
        this.imgFoto = 0;
    }

    public Objetivo (String nombre, String descripcionObjetivo, int imgFoto){
        super();
        this.nombre = nombre;
        this.descripcionObjetivo = descripcionObjetivo;
        this.imgFoto = imgFoto;
    }

    public String getNombre (){ return nombre; }

    public String getDescripcionObjetivo (){ return descripcionObjetivo; }

    public int getImgFoto (){ return imgFoto; }

}
