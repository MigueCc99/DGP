package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    private Intent i;

    private void init(){
        botonAtrasObjetivos = findViewById(R.id.botonHomeObj);
        lvObjetivos = (ListView) findViewById(R.id.listaObjetivos);
        adaptador = new AdaptadorObjetivos(this, Data.getData().getObjetivos());
        lvObjetivos.setAdapter(adaptador);

        i = new Intent(this, TransicionActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivos);
        init();

        //lvObjetivos.setOnClickListener(this);
        botonAtrasObjetivos.setOnClickListener(this);

        lvObjetivos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i.putExtra("objetivo", (Objetivo)lvObjetivos.getItemAtPosition(position));
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonHomeObj){
            finish();
        }
    }
}