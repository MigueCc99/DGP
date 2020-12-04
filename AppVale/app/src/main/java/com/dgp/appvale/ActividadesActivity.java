package com.dgp.appvale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ActividadesActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton botonAtrasActividades, botonActActividades, botonFlechaDerecha, botonFlechaIzquierda;

    private void init(){
        botonActActividades = findViewById(R.id.botonActActividades);
        botonAtrasActividades = findViewById(R.id.botonAtrasActividades);
        botonFlechaDerecha = findViewById(R.id.botonFlechaDerecha);
        botonFlechaIzquierda = findViewById(R.id.botonFlechaIzquierda);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        init();

        botonActActividades.setOnClickListener(this);
        botonAtrasActividades.setOnClickListener(this);
        botonFlechaDerecha.setOnClickListener(this);
        botonFlechaIzquierda.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.botonActActividades){
            // Intent a Actividad concreta
        }else if(v.getId() == R.id.botonAtrasActividades){
            Intent i = new Intent(this, ObjetivosActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.botonFlechaDerecha){
            /* Enlaza a actividad siguiente si la hay
               ACT1 -- ACT2 -- ACT3 (array 3 actividades)
               Si estamos en ACT1 (pantalla muestra ACT1)
               Si pulsamos botonFlechaDerecha pasamos a mostrar ACT2
             */
        }else if(v.getId() == R.id.botonFlechaIzquierda){
            /* Enlaza a actividad anterior si la hay
               ACT1 -- ACT2 -- ACT3 (array 3 actividades)
               Si estamos en ACT2 (pantalla muestra ACT2)
               Si pulsamos botonFlechaDerecha pasamos a mostrar ACT1
             */
        }
    }
}
