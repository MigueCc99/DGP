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

import java.util.Calendar;
import java.util.Date;

import com.dgp.appvale.clases.Sistema;
import com.dgp.appvale.clases.Socio;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int SELECCION_REQUEST_CODE = 0;
    private static int[] contraseniaProvisional = new int[6];
    private static int ultimaPosContr;

    private ImageButton et_botonContra1, et_botonContra2, et_botonContra3, et_botonContra4, et_botonContra5, et_botonContra6, et_botonCambio;
    private Button et_botonAcceso;

    private Socio socioSesion;
    private Sistema sistema;

    private void init (){
        et_botonAcceso = (Button)findViewById(R.id.botonAcceso);
        et_botonContra1 = (ImageButton)findViewById(R.id.botonContra1);
        et_botonContra2 = (ImageButton)findViewById(R.id.botonContra2);
        et_botonContra3 = (ImageButton)findViewById(R.id.botonContra3);
        et_botonContra4 = (ImageButton)findViewById(R.id.botonContra4);
        et_botonContra5 = (ImageButton)findViewById(R.id.botonContra5);
        et_botonContra6 = (ImageButton)findViewById(R.id.botonContra6);
        et_botonCambio = null;

        sistema = (Sistema) getIntent().getExtras().getSerializable("sistema");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1999);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 17);
        Date fecha = cal.getTime();
        socioSesion = new Socio("Miguel Ángel", "Campos", fecha, 100);
    }

    private void reset (){
        for(int i = 0; i < contraseniaProvisional.length; i++)
            contraseniaProvisional[i] = -1;

        ultimaPosContr = -1;

        et_botonContra1.setImageResource(R.drawable.imagen_gris);
        et_botonContra2.setImageResource(R.drawable.imagen_gris);
        et_botonContra3.setImageResource(R.drawable.imagen_gris);
        et_botonContra4.setImageResource(R.drawable.imagen_gris);
        et_botonContra5.setImageResource(R.drawable.imagen_gris);
        et_botonContra6.setImageResource(R.drawable.imagen_gris);

        et_botonAcceso.setEnabled(false);
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
            if (contraseniaProvisional[ultimaPosContr] != -1) {
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
                int idImage = Global.getIdImagen(contraseniaProvisional[ultimaPosContr]);

                et_botonCambio.setImageResource(idImage);
            }
        }

        boolean contrCompleta = true;
        for(int i = 0; i < contraseniaProvisional.length && contrCompleta; i++){
            if(contraseniaProvisional[i] == -1)
                contrCompleta = false;
        }

        if(contrCompleta) {
            et_botonAcceso.setEnabled(true);
        }
    }

    @Override
    public void onClick(View v){

        if(v.getId() == R.id.botonAcceso){

            if(sistema.comparaContrasenia(socioSesion,contraseniaProvisional)){
                reset();
                Intent i = new Intent(this, MenuActivity.class);
                i.putExtra("sistema", sistema);
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
                contraseniaProvisional[ultimaPosContr] = codigoContr;
            }
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        reset();
    }
}