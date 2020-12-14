package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.dgp.appvale.clases.Actividad;
import com.dgp.appvale.clases.AdaptadorObjetivos;
import com.dgp.appvale.clases.Data;
import com.dgp.appvale.clases.Objetivo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ObjetivosActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton botonAtrasObjetivos;
    private ListView lvObjetivos;
    private AdaptadorObjetivos adaptador;
    private Objetivo objetivo;
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

        botonAtrasObjetivos.setOnClickListener(this);

        lvObjetivos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                objetivo = (Objetivo)lvObjetivos.getItemAtPosition(position);
                i.putExtra("objetivo", objetivo);
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