package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;

public class PerfilActivity extends AppCompatActivity implements  View.OnClickListener {
    private TextView nombrePerfil, apellidosPerfil, fechaNacPerfil;
    private ImageView iconoAvatar;
    private ImageButton botonAtrasPerfil;

    private void init(){
        nombrePerfil = findViewById(R.id.nombrePerfil);
        apellidosPerfil = findViewById(R.id.apellidosPerfil);
        fechaNacPerfil = findViewById(R.id.fechaNacPerfil);
        iconoAvatar = findViewById(R.id.iconoAvatar);
        botonAtrasPerfil = findViewById(R.id.botonAtrasPerfil);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        init();

        botonAtrasPerfil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}