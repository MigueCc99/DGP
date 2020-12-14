package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class EnviarSolucionActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int VIDEO_REQUEST_CODE = 1;
    private static Uri videoUri = null;

    private EditText solucionTexto;
    private TextView tituloActividad, textoVideo;
    private ImageButton botonVideo, botonHome, botonObjetivos, botonActividades;
    private Button botonEnviar, botonEliminar;
    private VideoView videoSolucion;

    private Actividad actividad;

    private void init(){
        tituloActividad = findViewById(R.id.tituloActividadEnviar);
        textoVideo = findViewById(R.id.textoVideo);
        botonVideo = findViewById(R.id.botonVideo);
        botonEnviar = findViewById(R.id.botonEnviar);
        botonObjetivos = findViewById(R.id.botonObjetivosEnviar);
        botonActividades = findViewById(R.id.botonActividadesEnviar);
        botonHome = findViewById(R.id.botonHomeEnviarAct);
        videoSolucion = findViewById(R.id.videoSolucion);
        botonEliminar = findViewById(R.id.botonEliminar);
        solucionTexto = findViewById(R.id.SolucionTexto);

        actividad = (Actividad) getIntent().getSerializableExtra("actividad");
        tituloActividad.setText(actividad.getNombre());
        botonEnviar.setEnabled(true);
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

        //Enseñamos el boton para enviar solucion
        botonVideo.setEnabled(true);
        botonVideo.setVisibility(View.VISIBLE);
        textoVideo.setVisibility(View.VISIBLE);
    }

    private void enviarSolucion() throws JSONException {
        //sol.put("multimedia_solucion", Data.getData().getSolucion().getVideo());
        String url = Global.URL_FIJA + Global.URL_SOCIOS + "/" +  Data.getData().getSocio().getID() + Global.URL_ACTIVIDADES + "solucion/" + actividad.getID();
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject sol = new JSONObject();
                try {
                    sol.put("solucion_texto", Data.getData().getSolucion().getTexto());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
        botonHome.setOnClickListener(this);
        botonEnviar.setOnClickListener(this);
        botonObjetivos.setOnClickListener(this);
        botonActividades.setOnClickListener(this);
        botonEliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonVideo){
            Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if(i.resolveActivity(getPackageManager()) != null){
                startActivityForResult(i, VIDEO_REQUEST_CODE);
            }
        }else if(v.getId() == R.id.botonEnviar){
            try {
                if(solucionTexto.getText().toString().length() > 0){
                    haySolucion();
                    Data.getData().getSolucion().setTexto(solucionTexto.getText().toString());
                    enviarSolucion();
                    Intent i = new Intent(this, FeedbackActivity.class);
                    i.putExtra("actividad", actividad);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "Agrega una solución...", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else if(v.getId() == R.id.botonHomeEnviarAct){
            finish();
        }else if(v.getId() == R.id.botonEliminar){
            noHaySolucion();
        }else if(v.getId() == R.id.botonObjetivosEnviar){
            Intent i = new Intent(this, ObjetivosActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.botonActividadesEnviar){
            Intent i = new Intent(this, ActividadesActivity.class);
            startActivity(i);
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