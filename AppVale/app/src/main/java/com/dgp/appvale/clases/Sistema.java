package com.dgp.appvale.clases;

public class Sistema {
    private Socio socioPrueba;

    public Sistema(){
        socioPrueba = new Socio("Thomas", "Yowwww");
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
}
