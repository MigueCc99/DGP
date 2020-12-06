package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.dgp.appvale.clases.Data;
import com.dgp.appvale.clases.Sistema;
import com.dgp.appvale.clases.Socio;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int SELECCION_REQUEST_CODE = 0;
    private static String[] contraseniaProvisional = {"0","0","0","0","0","0"};
    private static int ultimaPosContr;

    private ImageButton et_botonContra1, et_botonContra2, et_botonContra3, et_botonContra4, et_botonContra5, et_botonContra6, et_botonCambio;
    private Button et_botonAcceso;

    private void init (){
        et_botonAcceso = (Button)findViewById(R.id.botonAcceso);
        et_botonContra1 = (ImageButton)findViewById(R.id.botonContra1);
        et_botonContra2 = (ImageButton)findViewById(R.id.botonContra2);
        et_botonContra3 = (ImageButton)findViewById(R.id.botonContra3);
        et_botonContra4 = (ImageButton)findViewById(R.id.botonContra4);
        et_botonContra5 = (ImageButton)findViewById(R.id.botonContra5);
        et_botonContra6 = (ImageButton)findViewById(R.id.botonContra6);
        et_botonCambio = null;
    }

    private void reset (){
        for(int i = 0; i < contraseniaProvisional.length; i++)
            contraseniaProvisional[i] = "0";

        ultimaPosContr = -1;

        et_botonContra1.setImageResource(R.drawable.imagen_gris);
        et_botonContra2.setImageResource(R.drawable.imagen_gris);
        et_botonContra3.setImageResource(R.drawable.imagen_gris);
        et_botonContra4.setImageResource(R.drawable.imagen_gris);
        et_botonContra5.setImageResource(R.drawable.imagen_gris);
        et_botonContra6.setImageResource(R.drawable.imagen_gris);

        et_botonAcceso.setEnabled(false);
    }

    private boolean checkUser(){
        String url = Global.URL_FIJA + Global.URL_LOGIN + contraseniaProvisional;

        new JsonObjectRequest(Request.Method.GET, url , null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        String nombreSocio = null;
                        String apellidoSocio = null;
                        String nacimiento = null;
                        String contraseniaSocio = null;
                        int idSocio = 0;
                        try {
                            nombreSocio = response.getString("nombre");
                            apellidoSocio = response.getString("apellidos");
                            nacimiento = response.getString("nacimiento");
                            contraseniaSocio = response.getString("contrasena");
                            idSocio = response.getInt("id");
                            Data.getData().setRegistrado(true);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Data.getData().setRegistrado(false);
                        }

                        Data.getData().setSocio(new Socio(nombreSocio, apellidoSocio, new Date(), idSocio));
                    }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), e + "Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                            Data.getData().setRegistrado(false);
                        }
                    });

        return Data.getData().getRegistrado();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        reset();

        et_botonAcceso.setOnClickListener(this);
        et_botonContra1.setOnClickListener(this);
        et_botonContra2.setOnClickListener(this);
        et_botonContra3.setOnClickListener(this);
        et_botonContra4.setOnClickListener(this);
        et_botonContra5.setOnClickListener(this);
        et_botonContra6.setOnClickListener(this);

        et_botonAcceso.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    @Override
    protected void onStart(){
        super.onStart();

        // Actualizo la imagen que ha seleccionado el usuario
        if(ultimaPosContr != -1) {
            if (contraseniaProvisional[ultimaPosContr] != "-1") {
                switch (ultimaPosContr) {
                    case 0:
                        et_botonCambio = et_botonContra1;
                        break;
                    case 1:
                        et_botonCambio = et_botonContra2;
                        break;
                    case 2:
                        et_botonCambio = et_botonContra3;
                        break;
                    case 3:
                        et_botonCambio = et_botonContra4;
                        break;
                    case 4:
                        et_botonCambio = et_botonContra5;
                        break;
                    case 5:
                        et_botonCambio = et_botonContra6;
                }
                int idImage = Global.getIdImagen( Integer.parseInt(contraseniaProvisional[ultimaPosContr]));

                et_botonCambio.setImageResource(idImage);
            }
        }

        boolean contrCompleta = true;
        for(int i = 0; i < contraseniaProvisional.length && contrCompleta; i++){
            if(contraseniaProvisional[i] == "-1")
                contrCompleta = false;
        }

        if(contrCompleta) {
            et_botonAcceso.setEnabled(true);
        }
    }

    @Override
    public void onClick(View v){

        if(v.getId() == R.id.botonAcceso){
            Sistema sistema = new Sistema();

            if(checkUser()){
                reset();
                Intent i = new Intent(this, MenuActivity.class);
                // Lanzo Activity Menu
                startActivity(i);
            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT);
                toast.show();
                reset();
            }
        }else {
            // Guardo la última posición donde clicka el usuario

            switch(v.getId()){
                case R.id.botonContra1:
                    ultimaPosContr = 0;
                    break;
                case R.id.botonContra2:
                    ultimaPosContr = 1;
                    break;
                case R.id.botonContra3:
                    ultimaPosContr = 2;
                    break;
                case R.id.botonContra4:
                    ultimaPosContr = 3;
                    break;
                case R.id.botonContra5:
                    ultimaPosContr = 4;
                    break;
                case R.id.botonContra6:
                    ultimaPosContr = 5;
                    break;
            }

            Intent i = new Intent(this, SeleccionSimboloActivity.class);
            // Lanzo la Activity de seleccion símbolos para que devuelva un resultado.
            // Tiene que tener un Request Code asociado.
            startActivityForResult(i, SELECCION_REQUEST_CODE);

        }
    }

    // Para recoger el resultado cuando la actividad llamada se finaliza hay que implementar este Override
    // Se llama cuando la actividad llamada se finaliza
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECCION_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                int codigoContr = data.getIntExtra("codigoContr",-1); // -1 como default
                contraseniaProvisional[ultimaPosContr] = Integer.toString(codigoContr);
            }
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        reset();
    }
}