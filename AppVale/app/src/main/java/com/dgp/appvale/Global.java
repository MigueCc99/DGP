package com.dgp.appvale;

public class Global {
    //static final String URL_FIJA = "https://10.0.2.2:3000/api/vale/socios";
    static final String URL_FIJA = "http://192.168.1.64:3000/api/vale";
    static final String URL_SOCIOS = "/socios";
    static final String URL_LOGIN = "/login/";
    static final String URL_ACTIVIDADES = "/actividades/";

    public static final int CODIGO_ARBOL = 1;
    public static final int CODIGO_CORAZON = 2;
    public static final int CODIGO_ESTRELLA = 3;
    public static final int CODIGO_PERRO = 4;

    public static int getIdImagen(int codigo){
        switch(codigo){
            case CODIGO_ARBOL:
                return R.drawable.icono_arbol;
            case CODIGO_CORAZON:
                return R.drawable.icono_corazon;
            case CODIGO_ESTRELLA:
                return R.drawable.icono_estrella;
            case CODIGO_PERRO:
                return R.drawable.icono_perro;
            default:
                throw new IllegalStateException("Unexpected value: " + codigo);
        }
    }
}
