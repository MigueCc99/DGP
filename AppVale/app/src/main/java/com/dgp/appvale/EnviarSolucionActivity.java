package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

public class EnviarSolucionActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int VIDEO_REQUEST_CODE = 1;
    private static Uri videoUri = null;

    TextView tituloActividad, textoVideo;
    ImageButton botonVideo, botonAtras;
    Button botonEnviar, botonEliminar;
    VideoView videoSolucion;

    private void init(){
        tituloActividad = findViewById(R.id.tituloActividadEnviar);
        textoVideo = findViewById(R.id.textoVideo);
        botonVideo = findViewById(R.id.botonVideo);
        botonEnviar = findViewById(R.id.botonEnviar);
        botonAtras = findViewById(R.id.botonAtrasEnviarSolucion);
        videoSolucion = findViewById(R.id.videoSolucion);
        botonEliminar = findViewById(R.id.botonEliminar);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_solucion);
        init();

        botonVideo.setOnClickListener(this);
        botonAtras.setOnClickListener(this);
        botonEnviar.setOnClickListener(this);
        botonEliminar.setOnClickListener(this);

        if(videoUri != null){
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