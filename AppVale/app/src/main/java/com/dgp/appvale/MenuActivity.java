package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dgp.appvale.clases.Sistema;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textoHola;
    private ImageButton botonSalida, botonPerfil, botonObjetivos;
    private Sistema sistema;

    private void init(){
        textoHola = findViewById(R.id.textoHola);
        botonSalida = findViewById(R.id.botonSalida);
        botonPerfil = findViewById(R.id.botonPerfil);
        botonObjetivos = findViewById(R.id.botonObjetivos);

        sistema = new Sistema();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();

        botonSalida.setOnClickListener(this);
        botonPerfil.setOnClickListener(this);
        botonObjetivos.setOnClickListener(this);

        textoHola.setText("Hola, "+ sistema.getSocio().getNombre());
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonSalida){
            finish();
        }else if(v.getId() == R.id.botonPerfil){
            Intent i = new Intent(this, PerfilActivity.class);
            startActivity(i);
        }else if(v.getId() == R.id.botonObjetivos){
            Intent i = new Intent(this, ObjetivosActivity.class);
            startActivity(i);
        }
    }
}