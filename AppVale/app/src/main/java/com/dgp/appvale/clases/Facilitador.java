package com.dgp.appvale.clases;

import java.util.Date;

public class Facilitador extends Usuario {
    private String correo_e;
    private String telefono;
    private String direccion_foto;
    private String contrasenia;

    public Facilitador (String nombre, String apellidos, Date fecha_nacimiento, String direccion_foto,
                 String correo_e, String telefono, String contrasenia){
        super(nombre, apellidos, fecha_nacimiento);
        this.correo_e = correo_e;
        this.telefono = telefono;
        this.direccion_foto = direccion_foto;
        this.contrasenia = contrasenia;
    }

    // Para la app el facilitador apenas tiene funcionalidad
    // Quizás solo sea necesario un getFoto() para el chat
}