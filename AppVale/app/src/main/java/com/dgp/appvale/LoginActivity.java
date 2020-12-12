package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.dgp.appvale.clases.Data;
import com.dgp.appvale.clases.Sistema;
import com.dgp.appvale.clases.Socio;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int SELECCION_REQUEST_CODE = 0;
    private ArrayList<Integer> contraseniaProvisional = new ArrayList<>();
    private static int ultimaPosContr;

    private ImageButton et_botonContra1, et_botonContra2, et_botonContra3, et_botonContra4, et_botonContra5, et_botonContra6, et_botonCambio;
    private Button et_botonAcceso;

    private void init() {
        et_botonAcceso = (Button) findViewById(R.id.botonAcceso);
        et_botonContra1 = (ImageButton) findViewById(R.id.botonContra1);
        et_botonContra2 = (ImageButton) findViewById(R.id.botonContra2);
        et_botonContra3 = (ImageButton) findViewById(R.id.botonContra3);
        et_botonContra4 = (ImageButton) findViewById(R.id.botonContra4);
        et_botonContra5 = (ImageButton) findViewById(R.id.botonContra5);
        et_botonContra6 = (ImageButton) findViewById(R.id.botonContra6);
        et_botonCambio = null;

        contraseniaProvisional.clear();
        for (int i = 0; i < 6; i++)
            contraseniaProvisional.add(-1);
    }

    private void reset() {

        for (int i = 0; i < contraseniaProvisional.size(); i++)
            contraseniaProvisional.set(i, -1);

        ultimaPosContr = -1;

        et_botonContra1.setImageResource(R.drawable.imagen_gris);
        et_botonContra2.setImageResource(R.drawable.imagen_gris);
        et_botonContra3.setImageResource(R.drawable.imagen_gris);
        et_botonContra4.setImageResource(R.drawable.imagen_gris);
        et_botonContra5.setImageResource(R.drawable.imagen_gris);
        et_botonContra6.setImageResource(R.drawable.imagen_gris);

        et_botonAcceso.setEnabled(false);
    }

    private void updateAndroidSecurityProvider() {
        try {
            ProviderInstaller.installIfNeeded(this);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void checkUser() {
        String url = Global.URL_FIJA + Global.URL_SOCIOS +Global.URL_LOGIN;
        for (int i = 0; i < contraseniaProvisional.size(); i++) {
            url += Integer.toString(contraseniaProvisional.get(i));
        }
        final Intent i = new Intent(this, MenuActivity.class);

        updateAndroidSecurityProvider();

        RequestQueue requestQueue = SingletonRequestQueue.getInstance(getApplicationContext()).getRequestQueue();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                String nombreSocio = "";
                String apellidoSocio = "";
                String fechaNacimiento = "";
                int contrasena = 0;
                int idSocio = 0;
                try {
                    nombreSocio = response.getString("nombre");
                    apellidoSocio = response.getString("apellidos");
                    fechaNacimiento = response.getString("nacimiento");
                    idSocio = response.getInt("id");
                    contrasena = response.getInt("contrasena");
                    Data.getData().setSocio(new Socio(nombreSocio, apellidoSocio, new SimpleDateFormat("dd/MM/YYYY").parse(fechaNacimiento), idSocio, contrasena));
                    reset();
                    // Lanzo Activity Menu
                    startActivity(i);
                } catch (JSONException | ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    reset();
                    Toast.makeText(getApplicationContext(), "Contraseña Incorrecta", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                System.out.println("error... " + e.toString());
                Data.getData().setRegistrado(false);
                reset();
                Toast.makeText(getApplicationContext(), "Contraseña Incorrecta", Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(jsonObjectRequest);
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
    protected void onStart() {
        super.onStart();

        // Actualizo la imagen que ha seleccionado el usuario
        if (ultimaPosContr != -1) {
            if (contraseniaProvisional.get(ultimaPosContr) != -1) {
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
                int idImage = Global.getIdImagen(contraseniaProvisional.get(ultimaPosContr));

                et_botonCambio.setImageResource(idImage);
            }
        }

        boolean contrCompleta = true;
        for (int i = 0; i < contraseniaProvisional.size() && contrCompleta; i++) {
            if (contraseniaProvisional.get(i) != -1)
                contrCompleta = false;
        }

        if (contrCompleta) {
            et_botonAcceso.setEnabled(true);
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.botonAcceso) {
            Sistema sistema = new Sistema();
            checkUser();
        } else {
            // Guardo la última posición donde clicka el usuario

            switch (v.getId()) {
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
        if (requestCode == SELECCION_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                int codigoContr = data.getIntExtra("codigoContr", -1); // -1 como default
                contraseniaProvisional.set(ultimaPosContr, codigoContr);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        reset();
    }
}