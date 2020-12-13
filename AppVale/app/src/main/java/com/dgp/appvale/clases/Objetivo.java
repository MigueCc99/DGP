package com.dgp.appvale.clases;

public class Objetivo {
    private int ID;
    private String nombre;
    private String descripcionObjetivo;
    private String imgFoto;

    public Objetivo (){
        this.ID = 0;
        this.nombre = "Objetivo por defecto";
        this.descripcionObjetivo = "Descripción por defecto";
        this.imgFoto = "";
    }

    public Objetivo (String nombre, String descripcionObjetivo, String imgFoto){
        super();
        this.nombre = nombre;
        this.descripcionObjetivo = descripcionObjetivo;
        this.imgFoto = imgFoto;
    }

    public Objetivo (int ID, String nombre, String descripcionObjetivo, String imgFoto){
        this(nombre, descripcionObjetivo, imgFoto);
        this.ID = ID;
    }

    public int getID (){ return ID; }

    public String getNombre (){ return nombre; }

    public String getDescripcionObjetivo (){ return descripcionObjetivo; }

    public String getImgFoto (){ return imgFoto; }

}
