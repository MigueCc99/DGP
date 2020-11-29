package com.dgp.appvale.clases;

import java.util.Date;

public class Usuario {
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;

    public Usuario (String nombre, String apellidos, Date fechaNacimiento){
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellidos() { return apellidos; }

    public Date getFechaNacimiento() { return fechaNacimiento; }

}
