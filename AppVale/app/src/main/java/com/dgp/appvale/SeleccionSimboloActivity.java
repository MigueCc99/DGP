package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SeleccionSimboloActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_simbolo);

        findViewById(R.id.botonArbol).setOnClickListener(this);
        findViewById(R.id.botonCorazon).setOnClickListener(this);
        findViewById(R.id.botonEstrella).setOnClickListener(this);
        findViewById(R.id.botonPerro).setOnClickListener(this);
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