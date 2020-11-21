package com.dgp.appvale;

import java.util.Date;

public class Usuario {
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;

    Usuario (){
        this.nombre = new String();
        this.apellidos = new String();
        this.fecha_nacimiento = new Date();
    }

    Usuario (String nombre, String apellidos, Date fecha_nacimiento){
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    void mandarMensaje (String mensaje, Actividad act){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    chat mandarMultimedia(Actividad act){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    chat leerChat(Actividad act){
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

}
