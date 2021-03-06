package com.dgp.appvale.clases;

import java.io.Serializable;

public class Actividad implements Serializable {
    private String nombre;
    private String descripcion;
    private String direccionFoto;
    private String direccionMultimedia;

    private int id;

    public Actividad(){
        this.id = 0;
        this.nombre = "Nombre Actividad";
        this.descripcion = "Descripcion Actividad";
        this.direccionFoto = "URL Foto";
        this.direccionMultimedia = "URL Multimedia";
    }

    public Actividad(String nombre, String descripcion, String direccionFoto, String direccionMultimedia){
        this.id = 0;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccionFoto = direccionFoto;
        this.direccionMultimedia = direccionMultimedia;
    }

    public Actividad(int id, String nombre, String descripcion, String direccionFoto, String direccionMultimedia){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccionFoto = direccionFoto;
        this.direccionMultimedia = direccionMultimedia;
    }

    public int getID(){ return id; }

    public String getNombre(){ return nombre; }

    public String getDescripcion(){ return descripcion; }

    public String getDireccionFoto(){ return direccionFoto; }

    public String getDireccionMultimedia(){ return direccionMultimedia; }

    @Override
    public String toString() {
        String actividad = "";

        actividad += "ID= " + id + "\n";
        actividad += "Nombre= " + nombre + "\n";
        actividad += "Descripcion= " + descripcion + "\n";
        actividad += "DireccionFoto= " + direccionFoto + "\n";
        actividad += "DireccionMultimedia= " + direccionMultimedia + "\n";

        return actividad;
    }
}