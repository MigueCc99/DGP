package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int SELECCION_REQUEST_CODE = 0;

    private static int[] contraseniaProvisional = {-1, -1, -1, -1, -1, -1};
    private static int ultimaPosContr = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.botonAcceso).setOnClickListener(this);
        findViewById(R.id.botonContra1).setOnClickListener(this);
        findViewById(R.id.botonContra2).setOnClickListener(this);
        findViewById(R.id.botonContra3).setOnClickListener(this);
        findViewById(R.id.botonContra4).setOnClickListener(this);
        findViewById(R.id.botonContra5).setOnClickListener(this);
        findViewById(R.id.botonContra6).setOnClickListener(this);

        // Actualizo la imagen que ha seleccionado el usuario
        int idBotonCambio = -1;

        if(ultimaPosContr != -1){
            if(contraseniaProvisional[ultimaPosContr] != -1){
                switch(ultimaPosContr){
                    case 0:
                        idBotonCambio = R.id.botonContra1;
                        break;
                    case 1:
                        idBotonCambio = R.id.botonContra2;
                        break;
                    case 2:
                        idBotonCambio = R.id.botonContra3;
                        break;
                    case 3:
                        idBotonCambio = R.id.botonContra4;
                        break;
                    case 4:
                        idBotonCambio = R.id.botonContra5;
                        break;
                    case 5:
                        idBotonCambio = R.id.botonContra6;
                }
                int idImage = Global.getIdImagen(contraseniaProvisional[ultimaPosContr]);

                if( idBotonCambio != -11 && idImage != -1){
                    findViewById(idBotonCambio).setBackgroundResource(idImage);
                }
            }
        }
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonAcceso){
            Intent i = new Intent(this, MenuActivity.class);
            // Lanzo Activity Menu
            startActivity(i);
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
                contraseniaProvisional[ultimaPosContr] = codigoContr;
            }
        }
    }
}