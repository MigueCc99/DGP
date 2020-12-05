package com.dgp.appvale.clases;

import java.io.Serializable;

public class Actividad implements Serializable {
    private String nombre;
    private String descripcion;
    private String direccionFoto;
    private String direccionMultimedia;

    public Actividad(){
        this.nombre = "Nombre Actividad";
        this.descripcion = "Descripcion Actividad";
        this.direccionFoto = "URL Foto";
        this.direccionMultimedia = "URL Multimedia";
    }

    public Actividad(String nombre, String descripcion, String direccionFoto, String direccionMultimedia){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccionFoto = direccionFoto;
        this.direccionMultimedia = direccionMultimedia;
    }

    public String getNombre(){ return nombre; }

    public String getDescripcion(){ return descripcion; }

    public String getDireccionFoto(){ return direccionFoto; }

    public String getDireccionMultimedia(){ return direccionMultimedia; }
}