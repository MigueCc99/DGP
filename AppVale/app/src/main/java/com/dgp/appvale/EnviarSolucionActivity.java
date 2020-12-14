package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dgp.appvale.clases.Actividad;
import com.dgp.appvale.clases.Data;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Blob;

public class EnviarSolucionActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int VIDEO_REQUEST_CODE = 1;
    private static Uri videoUri = null;

    private TextView tituloActividad, textoVideo;
    private ImageButton botonVideo, botonAtras;
    private Button botonEnviar, botonEliminar;
    private VideoView videoSolucion;

    private Actividad actividad;

    private void init(){
        tituloActividad = findViewById(R.id.tituloActividadEnviar);
        textoVideo = findViewById(R.id.textoVideo);
        botonVideo = findViewById(R.id.botonVideo);
        botonEnviar = findViewById(R.id.botonEnviar);
        botonAtras = findViewById(R.id.botonAtrasEnviarSolucion);
        videoSolucion = findViewById(R.id.videoSolucion);
        botonEliminar = findViewById(R.id.botonEliminar);

        actividad = (Actividad) getIntent().getSerializableExtra("actividad");
    }

    private void haySolucion(){
        //Ocultar botonas para añadir vídeo
        botonVideo.setEnabled(false);
        botonVideo.setVisibility(View.INVISIBLE);
        textoVideo.setVisibility(View.INVISIBLE);

        //Enseñar video
        videoSolucion.setVideoURI(videoUri);
        videoSolucion.setVisibility(View.VISIBLE);
        botonEliminar.setEnabled(true);
        botonEliminar.setVisibility(View.VISIBLE);

        botonEnviar.setEnabled(true);
    }

    private void noHaySolucion(){
        //Ocultar video
        videoUri = null;
        videoSolucion.setVisibility(View.INVISIBLE);
        botonEliminar.setEnabled(false);
        botonEliminar.setVisibility(View.INVISIBLE);

        botonEnviar.setEnabled(false);

        //Enseñamos el boton para enviar solucion
        botonVideo.setEnabled(true);
        botonVideo.setVisibility(View.VISIBLE);
        textoVideo.setVisibility(View.VISIBLE);
    }

    private void enviarSolucion() throws JSONException {
        JSONObject sol = new JSONObject();
        //sol.put("multimedia_solucion", Data.getData().getSolucion().getVideo());
        sol.put("solucion_texto", Data.getData().getSolucion().getTexto());

        String url = Global.URL_FIJA + Global.URL_SOCIOS +  Data.getData().getSocio().getID() + Global.URL_ACTIVIDADES + "solucion/" + actividad.getID();
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(), "Solución enviada!!!", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error.Response", error.toString());
            }
        });
        queue.add(jsonObjectRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_solucion);
        init();

        botonVideo.setOnClickListener(this);
        botonAtras.setOnClickListener(this);
        botonEnviar.setOnClickListener(this);
        botonEliminar.setOnClickListener(this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        //if(videoUri != null || Data.getData().getSolucion().getTexto() != "" || Data.getData().getSolucion().getVideo() != null){
        if(videoUri != null || Data.getData().getSolucion().getTexto() != ""){
            haySolucion();
        }else{
            noHaySolucion();
        }
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonVideo){
            Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if(i.resolveActivity(getPackageManager()) != null){
                startActivityForResult(i, VIDEO_REQUEST_CODE);
            }
        }else if(v.getId() == R.id.botonEnviar){

        }else if(v.getId() == R.id.botonAtrasEnviarSolucion){
            finish();
        }else if(v.getId() == R.id.botonEliminar){
            noHaySolucion();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VIDEO_REQUEST_CODE) {
            videoUri = data.getData();
            if(videoUri != null){
                haySolucion();
            }
        }
    }
}