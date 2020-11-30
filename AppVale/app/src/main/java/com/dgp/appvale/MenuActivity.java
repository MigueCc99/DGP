package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dgp.appvale.clases.Sistema;
import com.dgp.appvale.clases.Socio;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textoHola;
    private ImageButton botonSalida, botonPerfil, botonObjetivos;
    private Sistema sistema;
    private Socio socioSesion;

    private void init(){
        textoHola = findViewById(R.id.textoHola);
        botonSalida = findViewById(R.id.botonSalida);
        botonPerfil = findViewById(R.id.botonPerfil);
        botonObjetivos = findViewById(R.id.botonObjetivos);

        sistema = (Sistema) getIntent().getExtras().getSerializable("sistema");
        //socioSesion = sistema.getSocio("Miguel Ángel");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();

        botonSalida.setOnClickListener(this);
        botonPerfil.setOnClickListener(this);
        botonObjetivos.setOnClickListener(this);

        textoHola.setText("Hola, "+ socioSesion.getNombre());
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonSalida){
            finish();
        }else if(v.getId() == R.id.botonPerfil){
            Intent i = new Intent(this, PerfilActivity.class);
            i.putExtra("sistema", sistema);
            startActivity(i);
        }else if(v.getId() == R.id.botonObjetivos){
            Intent i = new Intent(this, ObjetivosActivity.class);
            i.putExtra("sistema", sistema);
            startActivity(i);
        }
    }
}