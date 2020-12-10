package com.dgp.appvale.clases;

import java.util.ArrayList;

public class Data{
    Socio socio;
    ArrayList<Objetivo> objetivos;
    ArrayList<Actividad> actividades;
    boolean registrado = false;

    private static final Data data = new Data();

    public  static Data getData(){
        return data;
    }

    private Data(){
        socio = new Socio();
        objetivos = new ArrayList<>();
        actividades = new ArrayList<>();
    }

    private Data(Socio socio, ArrayList<Objetivo> objetivos, ArrayList<Actividad> actividades){
        this.socio = socio;
        this.objetivos = objetivos;
        this.actividades = actividades;
    }

    public void setSocio(Socio socio){
        this.socio = socio;
    }

    public void setRegistrado(boolean registrado){ this.registrado = registrado; }

    public Socio getSocio() { return socio; }

    public boolean getRegistrado(){ return registrado; }

/*
    cargarSocio(JSON)
    getIdSocio()

    cargarObjetivos(JSON)
    cargarActividades(JSON)

    getNombreSocio()
    getApellidosSocio()
    getFechNacimientoSocio()

    getObjetivos()
    getObtivo(id) *Optativo

    getActividades()
    getActividad(idActividad)

    setSolucion(Video)
*/
}