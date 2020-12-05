package com.dgp.appvale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dgp.appvale.clases.Actividad;

import java.util.ArrayList;

public class ActividadesActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton botonAtrasActividades, botonActActividades, botonFlechaDerecha, botonFlechaIzquierda;
    ArrayList<Actividad> actividadesTest;
    TextView tituloActAct;
    Actividad actividad;
    int actividadActual = 0;;

    private void init(){
        botonActActividades = findViewById(R.id.botonActActividades);
        botonAtrasActividades = findViewById(R.id.botonAtrasActividades);
        botonFlechaDerecha = findViewById(R.id.botonFlechaDerecha);
        botonFlechaIzquierda = findViewById(R.id.botonFlechaIzquierda);
        tituloActAct = findViewById(R.id.tituloActAct);

        actividad = new Actividad();
        generarArrayActividadesTest();
    }

    private void generarArrayActividadesTest(){
        Actividad actividadAux = new Actividad();
        actividadesTest = new ArrayList<>();

        actividadAux = new Actividad("Atarse los cordones", "Debes atarte los cordones y enviar un vídeo", "cordones.png", "URL Multimedia");
        actividadesTest.add(actividadAux);

        actividadAux = new Actividad("Poner la lavadora", "Debes poner la lavadora y enviar un vídeo", "lavadora.png", "URL Multimedia");
        actividadesTest.add(actividadAux);
    }

    private void gestiónActividadActual() {

        actividad = actividadesTest.get(actividadActual);
        System.out.println("Actividad actual= " + actividadActual);
        if(actividad.getDireccionFoto() == "cordones.png")
            botonActActividades.setImageResource(R.drawable.cordon);
        else if(actividad.getDireccionFoto() == "lavadora.png")
            botonActActividades.setImageResource(R.drawable.lavadora);
        else
            botonActActividades.setImageResource(R.drawable.activity);

        tituloActAct.setText(actividad.getNombre());
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
            if(actividadActual+1 < actividadesTest.size()){
                actividadActual += 1;
                gestiónActividadActual();
            }
        }else if(v.getId() == R.id.botonFlechaIzquierda){
            /* Enlaza a actividad anterior si la hay
               ACT1 -- ACT2 -- ACT3 (array 3 actividades)
               Si estamos en ACT2 (pantalla muestra ACT2)
               Si pulsamos botonFlechaDerecha pasamos a mostrar ACT1
             */
            if(actividadActual-1 >= 0){
                actividadActual -= 1;
                gestiónActividadActual();
            }
        }
    }
}
