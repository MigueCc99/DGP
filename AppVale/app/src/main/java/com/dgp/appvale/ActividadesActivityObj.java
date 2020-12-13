package com.dgp.appvale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dgp.appvale.clases.Actividad;
import com.dgp.appvale.clases.Data;

import java.util.ArrayList;

    public class ActividadesActivityObj extends AppCompatActivity implements View.OnClickListener{
        ImageButton botonActActividadesObj, botonFlechaDerechaObj, botonFlechaIzquierdaObj;
        ArrayList<Actividad> actividadesTest;
        TextView tituloActAct;
        Actividad actividad;
        int actividadActual = 0;

        private void init(){
            botonActActividadesObj = findViewById(R.id.botonActActividadesObj);
            botonFlechaDerechaObj = findViewById(R.id.botonFlechaDerechaObj);
            botonFlechaIzquierdaObj = findViewById(R.id.botonFlechaIzquierdaObj);
            tituloActAct = findViewById(R.id.tituloActActObj);

            actividad = new Actividad();
            generarArrayActividadesTest();
            gestiónActividadActual();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_actividades_objetivos);
            init();

            botonActActividadesObj.setOnClickListener(this);
            botonFlechaDerechaObj.setOnClickListener(this);
            botonFlechaIzquierdaObj.setOnClickListener(this);
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
            actividad = Data.getData().getActividadesObjetivos().get(actividadActual);
            System.out.println("Actividad actual= " + actividad.toString());
            if(actividad.getDireccionFoto() == "cordones.png")
                botonActActividadesObj.setImageResource(R.drawable.cordon);
            else if(actividad.getDireccionFoto() == "lavadora.png")
                botonActActividadesObj.setImageResource(R.drawable.lavadora);
            else
                botonActActividadesObj.setImageResource(R.drawable.activity);

            tituloActAct.setText(actividad.getNombre());
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.botonActActividadesObj){
                // Intent a Actividad concreta
                Intent i = new Intent(this, ActividadActivity.class);
                gestiónActividadActual();
                startActivity(i);
            }else if(v.getId() == R.id.botonAtrasActividades){
                finish();
            }else if(v.getId() == R.id.botonFlechaDerechaObj){
            /* Enlaza a actividad siguiente si la hay
               ACT1 -- ACT2 -- ACT3 (array 3 actividades)
               Si estamos en ACT1 (pantalla muestra ACT1)
               Si pulsamos botonFlechaDerecha pasamos a mostrar ACT2
             */
                if(actividadActual+1 < Data.getData().getActividadesObjetivos().size()){
                    actividadActual += 1;
                    gestiónActividadActual();
                }
            }else if(v.getId() == R.id.botonFlechaIzquierdaObj){
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