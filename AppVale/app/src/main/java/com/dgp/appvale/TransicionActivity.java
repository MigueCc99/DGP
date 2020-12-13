package com.dgp.appvale;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.dgp.appvale.clases.Actividad;
import com.dgp.appvale.clases.Data;
import com.dgp.appvale.clases.Objetivo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TransicionActivity extends AppCompatActivity {
    private Objetivo objetivo = new Objetivo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        objetivo = (Objetivo) getIntent().getSerializableExtra("objetivo");

        getActividadesObjetivos();
        Intent i = new Intent(this, ActividadesActivityObj.class);
        startActivity(i);
    }

    private void getActividadesObjetivos() {
        String url = Global.URL_FIJA + Global.URL_OBJETIVOS + objetivo.getID() + Global.URL_ACTIVIDADES;
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
                                Data.getData().getActividadesObjetivos().add(actividadAux);
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

}
