package com.dgp.appvale.clases;

import java.util.ArrayList;
import java.util.Date;

public class Socio extends Usuario {
    private ArrayList<Actividad> actividades;
    private String[] contrasenia = {"1", "1", "1", "1", "1", "1"};

    public Socio(){
        super("Nombre socio", "Apellido socio", new Date(), 1);
    }

    public Socio(String nombre, String apellidos, Date fechaNacimiento, int ID){
        super(nombre, apellidos, fechaNacimiento, ID);
    }

    public String[] getContrasenia (){ return this.contrasenia; }
}
