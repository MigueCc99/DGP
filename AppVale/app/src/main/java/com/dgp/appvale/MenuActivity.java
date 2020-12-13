package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.dgp.appvale.clases.Actividad;
import com.dgp.appvale.clases.Data;
import com.dgp.appvale.clases.Objetivo;
import com.dgp.appvale.clases.Sistema;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textoHola;
    private ImageButton botonSalida, botonPerfil, botonObjetivos, botonActividades;

    private void init(){
        textoHola = findViewById(R.id.textoHola);
        botonSalida = findViewById(R.id.botonSalida);
        botonPerfil = findViewById(R.id.botonPerfil);
        botonObjetivos = findViewById(R.id.botonObjetivos);
        botonActividades = findViewById(R.id.botonActividades);

        getActividadesSocio();
        getObjetivosSocio();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();

        textoHola.setText("Hola, " + Data.getData().getSocio().getNombre());

        botonSalida.setOnClickListener(this);
        botonPerfil.setOnClickListener(this);
        botonObjetivos.setOnClickListener(this);
        botonActividades.setOnClickListener(this);
    }

    private void getActividadesSocio(){
        String url = Global.URL_FIJA + Global.URL_SOCIOS + "/" + Data.getData().getSocio().getID() + Global.URL_ACTIVIDADES;

        //final RequestQueue requestQueue = SingletonRequestQueue.getInstance(getApplicationContext()).getRequestQueue();
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject jsonObject;
                        Actividad actividadAux;
                        String nombreActividad = "";
                        String descripcionActividad = "";
                        String imagenActividad = "";
                        String multimediaActividad = "";
                        int idActividad = 0;
                        for(int i=0; i<response.length(); i++){
                            try {
                                jsonObject = (JSONObject) response.get(i);
                                idActividad = jsonObject.getInt("id");
                                nombreActividad = jsonObject.getString("nombre");
                                descripcionActividad = jsonObject.getString("descripcion");
                                imagenActividad = jsonObject.getString("imagen");
                                multimediaActividad = jsonObject.getString("multimedia");
                                actividadAux = new Actividad(idActividad, nombreActividad, descripcionActividad, imagenActividad, multimediaActividad);
                                System.out.println("Actividad: " + actividadAux.toString());
                                Data.getData().addActividad(actividadAux);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );
        queue.add(jsonArrayRequest);
    }

    private void getObjetivosSocio(){
        String url = Global.URL_FIJA + Global.URL_SOCIOS + "/" + Data.getData().getSocio().getID() + Global.URL_OBJETIVOS;

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject jsonObject;
                        int id = 0;
                        String nombreObjetivo, descripcionObjetivo, imgFoto;
                        Objetivo objetivo;
                        for(int i=0; i<response.length(); i++){
                            try {
                                jsonObject = (JSONObject) response.get(i);
                                id = jsonObject.getInt("id");
                                nombreObjetivo = jsonObject.getString("nombre");
                                descripcionObjetivo = jsonObject.getString("descripcion");
                                //imgFoto = jsonObject.getString("imagen");
                                objetivo = new Objetivo(id, nombreObjetivo, descripcionObjetivo, R.drawable.objetivo);
                                Data.getData().getObjetivos().add(objetivo);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );
        queue.add(jsonArrayRequest);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonSalida){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.botonPerfil){
            Intent i = new Intent(this, PerfilActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.botonObjetivos){
            Intent i = new Intent(this, ObjetivosActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.botonActividades){
            Intent i = new Intent(this, ActividadesActivity.class);
            startActivity(i);
        }
    }
}