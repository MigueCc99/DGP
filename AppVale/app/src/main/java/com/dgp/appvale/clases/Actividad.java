package com.dgp.appvale.clases;

public class Actividad{
    private String nombre;
    private String descripcion;
    private String direccion_foto;
    private String direccion_multimedia;

    public Actividad(String nombre, String descripcion, String direccion_foto, String direccion_multimedia){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion_foto = direccion_foto;
        this.direccion_multimedia = direccion_multimedia;
    }

    public void mostrarActividad(){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
}