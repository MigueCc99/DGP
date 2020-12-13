package com.dgp.appvale;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.dgp.appvale.clases.Actividad;
import com.dgp.appvale.clases.Data;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class ActividadActivity  extends AppCompatActivity implements View.OnClickListener{
    TextView tituloActividad;
    ImageButton botonEnviar, botonAtrasActividad;
    YouTubePlayerView youtubePlayer;

    Actividad actividad;

    private void init(){
        tituloActividad = findViewById(R.id.tituloActividad);
        botonEnviar = findViewById(R.id.botonActividadEnviar);
        botonAtrasActividad = findViewById(R.id.botonAtrasActividad);
        youtubePlayer = findViewById(R.id.youtubePlayer);
        actividad = (Actividad) getIntent().getSerializableExtra("actividad");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);
        init();

        botonEnviar.setOnClickListener(this);
        botonAtrasActividad.setOnClickListener(this);

        tituloActividad.setText(actividad.getNombre());

        getLifecycle().addObserver(youtubePlayer);

        youtubePlayer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onApiChange(YouTubePlayer youTubePlayer) {
                super.onApiChange(youTubePlayer);

                String id = actividad.getDireccionMultimedia();
                //youTubePlayer.loadVideo(id,0);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.botonActividadEnviar){
            Intent i = new Intent(this, EnviarSolucionActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.botonAtrasActividad){
            finish();
        }
    }
}
