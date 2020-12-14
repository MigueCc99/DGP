package com.dgp.appvale.clases;

import androidx.appcompat.app.AppCompatActivity;

import com.dgp.appvale.R;

import java.io.Serializable;

public class Objetivo extends AppCompatActivity implements Serializable {
    private int ID;
    private String imgFoto;
    private String nombre;
    private String descripcionObjetivo;

    public Objetivo (){
        this.ID = 0;
        this.nombre = "Objetivo por defecto";
        this.descripcionObjetivo = "Descripción por defecto";
        this.imgFoto = "objetivo.png";
    }

    public Objetivo (String nombre, String descripcionObjetivo, String imgFoto){
        super();
        this.nombre = nombre;
        this.descripcionObjetivo = descripcionObjetivo;
        this.imgFoto = imgFoto;
    }

    public Objetivo (int ID, String nombre, String descripcionObjetivo, String imgFoto){
        this(nombre, descripcionObjetivo, imgFoto);
        this.ID = ID;
        this.imgFoto = imgFoto;
    }

    public int getID (){ return ID; }

    public String getNombre (){ return nombre; }

    public String getDescripcionObjetivo (){ return descripcionObjetivo; }

    public int getImgFoto (){ return getResources().getIdentifier(imgFoto.split("\\.")[0],"drawable",getApplicationInfo().packageName); }

}
