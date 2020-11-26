package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.botonAcceso).setOnClickListener(this);
        findViewById(R.id.botonContra1).setOnClickListener(this);
        findViewById(R.id.botonContra2).setOnClickListener(this);
        findViewById(R.id.botonContra3).setOnClickListener(this);
        findViewById(R.id.botonContra4).setOnClickListener(this);
        findViewById(R.id.botonContra5).setOnClickListener(this);
        findViewById(R.id.botonContra6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.botonAcceso){
            Intent i = new Intent(this, MenuActivity.class)
        }else {
            Intent i = new Intent(this, SeleccionSimboloActivity.class)
        }
    }
}