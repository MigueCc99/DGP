package com.dgp.appvale.clases;

import java.util.ArrayList;
import java.util.Date;

public class Socio extends Usuario {
    private ArrayList<Simbolo> contrasenia;
    private ArrayList<Actividad> actividades;


    private ArrayList<Simbolo> generarContrasenia(){
        //Generamos aleatoriamente 6 simbolos y comprobamos que no es igual a ninguna contraseña del sistema
        //Si no coincide se la asignamos al usuario.
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public Socio(String nombre, String apellidos, Date fecha_nacimiento){
        super(nombre, apellidos, fecha_nacimiento);
        this.contrasenia = generarContrasenia();
    }

    public ArrayList<Simbolo> getContraseña (){ return this.contrasenia; }

    public void mostrarPerfil() {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

}
