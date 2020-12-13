package com.dgp.appvale.clases;

import com.dgp.appvale.R;

public class Objetivo {
    private int ID;
    private int imgFoto;
    private String nombre;
    private String descripcionObjetivo;

    public Objetivo (){
        this.ID = 0;
        this.nombre = "Objetivo por defecto";
        this.descripcionObjetivo = "Descripción por defecto";
        this.imgFoto = R.drawable.objetivo;
    }

    public Objetivo (String nombre, String descripcionObjetivo, int imgFoto){
        super();
        this.nombre = nombre;
        this.descripcionObjetivo = descripcionObjetivo;
        this.imgFoto = imgFoto;
    }

    public Objetivo (int ID, String nombre, String descripcionObjetivo, int imgFoto){
        this(nombre, descripcionObjetivo, imgFoto);
        this.ID = ID;
    }

    public int getID (){ return ID; }

    public String getNombre (){ return nombre; }

    public String getDescripcionObjetivo (){ return descripcionObjetivo; }

    public int getImgFoto (){ return imgFoto; }

}
