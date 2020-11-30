package com.dgp.appvale.clases;

import java.util.ArrayList;
import java.util.Date;

public class Socio extends Usuario {
    private ArrayList<Actividad> actividades;
    private int[] contrasenia;


    public Socio(String nombre, String apellidos, Date fechaNacimiento, int ID){
        super(nombre, apellidos, fechaNacimiento, ID);
        this.contrasenia = new int[]{1, 1, 1, 1, 1, 1};
    }

    public int[] getContrasenia (){ return this.contrasenia; }
}
