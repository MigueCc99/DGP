package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.dgp.appvale.clases.AdaptadorObjetivos;
import com.dgp.appvale.clases.Objetivo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ObjetivosActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton botonAtrasObjetivos;
    private ImageButton botonActividades;

    private ListView lvObjetivos;
    private AdaptadorObjetivos adaptador;

    private void init(){
        botonAtrasObjetivos = findViewById(R.id.botonAtrasObj);
        botonActividades = findViewById(R.id.botonActividades);
        lvObjetivos = (ListView) findViewById(R.id.listaObjetivos);
        adaptador = new AdaptadorObjetivos(this, getArrayItems());
        lvObjetivos.setAdapter(adaptador);
    }

    private ArrayList<Objetivo> getArrayItems(){
        ArrayList<Objetivo> lObjetivos = new ArrayList<>();
        lObjetivos.add(new Objetivo("Tareas del Hogar", "Descripcion...", R.drawable.objetivo));
        return lObjetivos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivos);
        init();

        botonAtrasObjetivos.setOnClickListener(this);
        botonActividades.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonActividades){
            Intent i = new Intent(this, ActividadesActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.botonAtrasObj){
            finish();
        }
    }
}