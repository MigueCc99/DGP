package com.dgp.appvale;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dgp.appvale.clases.Actividad;
import com.dgp.appvale.clases.Data;
import com.dgp.appvale.clases.Socio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        gestiónActividadActual();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_objetivos);
        init();

        botonActActividades.setOnClickListener(this);
        botonAtrasActividades.setOnClickListener(this);
        botonFlechaDerecha.setOnClickListener(this);
        botonFlechaIzquierda.setOnClickListener(this);
    }

    private void generarArrayActividadesTest(){
        Actividad actividadAux;
        actividadesTest = new ArrayList<>();

        actividadAux = new Actividad("Atarse los cordones", "Debes atarte los cordones y enviar un vídeo", "cordones.png", "QmjQAl_-tiI");
        actividadesTest.add(actividadAux);

        actividadAux = new Actividad("Poner la lavadora", "Debes poner la lavadora y enviar un vídeo", "lavadora.png", "XGKF5hxTnfo");
        actividadesTest.add(actividadAux);
    }

    private void gestiónActividadActual() {
        actividad = Data.getData().getActividades().get(actividadActual);
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
    public void onClick(View v) {
        if(v.getId() == R.id.botonActActividades){
            // Intent a Actividad concreta
            Intent i = new Intent(this, ActividadActivity.class);
            gestiónActividadActual();
            i.putExtra("actividad", actividad);
            startActivity(i);
        }else if(v.getId() == R.id.botonAtrasActividades){
            finish();
        }else if(v.getId() == R.id.botonFlechaDerecha){
            /* Enlaza a actividad siguiente si la hay
               ACT1 -- ACT2 -- ACT3 (array 3 actividades)
               Si estamos en ACT1 (pantalla muestra ACT1)
               Si pulsamos botonFlechaDerecha pasamos a mostrar ACT2
             */
            if(actividadActual+1 < Data.getData().getActividades().size()){
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
