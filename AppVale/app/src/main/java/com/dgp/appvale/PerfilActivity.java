package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;

import com.dgp.appvale.clases.Sistema;
import com.dgp.appvale.clases.Socio;

public class PerfilActivity extends AppCompatActivity implements  View.OnClickListener {
    private TextView nombrePerfil, apellidosPerfil, fechaNacPerfil;
    private ImageView iconoAvatar;
    private ImageButton botonAtrasPerfil;

    private Sistema sistema;
    private Socio socioSesion;

    private void init(){
        nombrePerfil = findViewById(R.id.nombrePerfil);
        apellidosPerfil = findViewById(R.id.apellidosPerfil);
        fechaNacPerfil = findViewById(R.id.fechaNacPerfil);
        iconoAvatar = findViewById(R.id.iconoAvatar);
        botonAtrasPerfil = findViewById(R.id.botonAtrasPerfil);

        sistema = (Sistema) getIntent().getExtras().getSerializable("sistema");
        socioSesion = sistema.getSocio("Miguel Ángel");
    }

    private void generarDatosPerfil(){
        if(socioSesion != null){
            nombrePerfil.setText("Nombre: " + socioSesion.getNombre());
            apellidosPerfil.setText("Apellidos: " + socioSesion.getApellidos());
            fechaNacPerfil.setText("FechaNac: " + socioSesion.getFechaNacimiento().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        init();
        generarDatosPerfil();

        botonAtrasPerfil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }
}