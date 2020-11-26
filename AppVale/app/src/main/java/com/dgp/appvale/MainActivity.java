package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dgp.appvale.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.botonAccesoLogin);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}
