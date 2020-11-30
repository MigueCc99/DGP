package com.dgp.appvale.clases;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sistema extends AppCompatActivity {
    private Socio socioPrueba;

    public Sistema(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1999);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 17);
        Date fecha = cal.getTime();
        socioPrueba = new Socio("Miguel Ángel", "Campos", fecha, 100);
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

    public Socio getSocio(){ return socioPrueba; }

}

