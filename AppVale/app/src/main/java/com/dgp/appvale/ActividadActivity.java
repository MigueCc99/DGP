package com.dgp.appvale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class ActividadActivity  extends AppCompatActivity implements View.OnClickListener{
    TextView tituloActividad;
    ImageButton botonEnviar, botonAtrasActividad;
    VideoView videoActividad;

    private void init(){
        tituloActividad = findViewById(R.id.tituloActividad);
        botonEnviar = findViewById(R.id.botonActividadEnviar);
        botonAtrasActividad = findViewById(R.id.botonAtrasActividad);
        videoActividad = findViewById(R.id.videoActividad);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        init();

        botonEnviar.setOnClickListener(this);
        botonAtrasActividad.setOnClickListener(this);
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
