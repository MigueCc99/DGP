package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.dgp.appvale.clases.AdaptadorObjetivos;
import com.dgp.appvale.clases.Data;
import com.dgp.appvale.clases.Objetivo;

import java.util.ArrayList;

public class ObjetivosActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton botonAtrasObjetivos;
    private ListView lvObjetivos;
    private AdaptadorObjetivos adaptador;

    private void init(){
        botonAtrasObjetivos = findViewById(R.id.botonHomeObj);
        lvObjetivos = (ListView) findViewById(R.id.listaObjetivos);
        adaptador = new AdaptadorObjetivos(this, Data.getData().getObjetivos());
        lvObjetivos.setAdapter(adaptador);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivos);
        init();

        //lvObjetivos.setOnClickListener(this);
        botonAtrasObjetivos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonHomeObj){
            finish();
        }
    }
}