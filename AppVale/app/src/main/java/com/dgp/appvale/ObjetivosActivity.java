package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.dgp.appvale.clases.AdaptadorObjetivos;
import com.dgp.appvale.clases.Objetivo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ObjetivosActivity extends AppCompatActivity {
    private ListView lvObjetivos;
    private AdaptadorObjetivos adaptador;

    private void init(){
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
    }
}