package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SeleccionSimboloActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton et_botonArbol, et_botonCorazon, et_botonEstrella, et_botonPerro;

    private void init(){
        et_botonArbol = (ImageButton)findViewById(R.id.botonArbol);
        et_botonCorazon = (ImageButton)findViewById(R.id.botonCorazon);
        et_botonEstrella = (ImageButton)findViewById(R.id.botonEstrella);
        et_botonPerro = (ImageButton)findViewById(R.id.botonPerro);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_simbolo);
        init();

        et_botonArbol.setOnClickListener(this);
        et_botonCorazon.setOnClickListener(this);
        et_botonEstrella.setOnClickListener(this);
        et_botonPerro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int codigoContr = -1;
        switch(v.getId()){
            case R.id.botonArbol:
                codigoContr = Global.CODIGO_ARBOL;
                break;
            case R.id.botonCorazon:
                codigoContr = Global.CODIGO_CORAZON;
                break;
            case R.id.botonEstrella:
                codigoContr = Global.CODIGO_ESTRELLA;
                break;
            case R.id.botonPerro:
                codigoContr = Global.CODIGO_PERRO;
                break;
        }

        //Instanciamos el intent que vamos a devolver y acabamos con la activity
        Intent i = new Intent();
        i.putExtra("codigoContr", codigoContr);
        setResult(RESULT_OK, i);
        finish();
    }
}