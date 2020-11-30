package com.dgp.appvale.clases;

import java.util.Calendar;
import java.util.Date;

public class Sistema {
    private Socio socioPrueba;

    public Sistema(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1999);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 17);
        Date fecha = cal.getTime();
        socioPrueba = new Socio("Thomas", "Yowwww", fecha, 100);
    }

    public boolean comparaContrasenia(int[] otra_contrasenia){
        boolean iguales = false;
        if(socioPrueba.getContrasenia().length == otra_contrasenia.length){
            iguales = true;
            for(int i = 0; i < otra_contrasenia.length && iguales; i++){
                if(otra_contrasenia[i] != socioPrueba.getContrasenia()[i])
                    iguales = false;
            }
        }

        return iguales;
    }

    public String getNombreSocio(){
        return socioPrueba.getNombre();
    }
    public Socio getSocio(){ return socioPrueba; }
}

