package com.dgp.appvale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dgp.appvale.clases.Actividad;
import com.dgp.appvale.clases.Data;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Blob;

public class ActividadActivity  extends AppCompatActivity implements View.OnClickListener{
    TextView tituloActividad, descripcionActividad;
    ImageButton botonEnviar, botonHomeActividad, botonObjetivosActividad, botonActividadesActividad;
    YouTubePlayerView youtubePlayer;

    Actividad actividad;
    boolean cargado = false;

    private void init(){
        tituloActividad = findViewById(R.id.tituloActividad);
        descripcionActividad = findViewById(R.id.DescripcionActividad);
        botonEnviar = findViewById(R.id.botonActividadEnviar);
        botonHomeActividad = findViewById(R.id.botonHomeActividad);
        botonObjetivosActividad = findViewById(R.id.botonObjetivoActividad);
        botonActividadesActividad = findViewById(R.id.botonActividadesActividad);
        youtubePlayer = findViewById(R.id.youtubePlayer);
        actividad = (Actividad) getIntent().getSerializableExtra("actividad");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);
        init();

        botonEnviar.setOnClickListener(this);
        botonHomeActividad.setOnClickListener(this);
        botonObjetivosActividad.setOnClickListener(this);
        botonActividadesActividad.setOnClickListener(this);

        tituloActividad.setText(actividad.getNombre());
        descripcionActividad.setText(actividad.getDescripcion());

        getLifecycle().addObserver(youtubePlayer);

        youtubePlayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onApiChange(YouTubePlayer youTubePlayer) {
                super.onApiChange(youTubePlayer);

                if(!cargado){
                    String id = actividad.getDireccionMultimedia();
                    youTubePlayer.cueVideo(id,0);
                    cargado = true;
                }
            }
        });
    }

            @Override
    protected void onStart(){
        super.onStart();
        cargado = false;
    }

    private void getSolucionActual(){
        String url = Global.URL_FIJA + Global.URL_SOCIOS + Data.getData().getSocio().getID() + Global.URL_ACTIVIDADES + "solucion/" + actividad.getID();
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                String solucionTexto = "";
                Blob solucionVideo = null;
                try {
                    solucionTexto = response.getString("solucion_texto");
                    solucionVideo = (Blob)response.get("multimedia_solucion");
                    if(solucionTexto != "")
                        Data.getData().getSolucion().setTexto(solucionTexto);
                    if(solucionVideo != null)
                        Data.getData().getSolucion().setVideo(solucionVideo);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.botonActividadEnviar){
            Intent i = new Intent(this, EnviarSolucionActivity.class);
            i.putExtra("actividad", actividad);
            startActivity(i);
        }else if(v.getId() == R.id.botonHomeActividad){
            finish();
        }else if(v.getId() == R.id.botonActividadesActividad){
            Intent i = new Intent(this, ActividadesActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.botonObjetivoActividad){
            Intent i = new Intent(this, ObjetivosActivity.class);
            startActivity(i);
        }
    }
}
