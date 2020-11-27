package com.dgp.appvale.clases;

import com.dgp.appvale.clases.Actividad;

import java.util.Date;

public class Usuario {
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;

    public Usuario (String nombre, String apellidos){
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
    }


    public String getNombre(){
        return nombre + " " + apellidos;
    }

}
