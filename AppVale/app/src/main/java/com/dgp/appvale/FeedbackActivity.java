package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dgp.appvale.clases.Actividad;

import java.util.ArrayList;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener{
    Button botonEnviar, botonAtras;
    ImageButton botonSi1, botonSi2, botonSi3, botonNo1, botonNo2, botonNo3;
    TextView tituloActividad;

    ArrayList<Boolean> contestado;
    ArrayList<Boolean> feedback;

    private void init(){
        botonEnviar = findViewById(R.id.botonEnviarFeedback);
        botonAtras = findViewById(R.id.botonAtrasFeedback);

        botonSi1 = findViewById(R.id.botonSi1);
        botonSi2 = findViewById(R.id.botonSi2);
        botonSi3 = findViewById(R.id.botonSi3);

        botonNo1 = findViewById(R.id.botonNo1);
        botonNo2 = findViewById(R.id.botonNo2);
        botonNo3 = findViewById(R.id.botonNo3);

        tituloActividad = findViewById(R.id.textoNombreActividad);

        feedback = new ArrayList<>(3);
        contestado = new ArrayList<>(3);
        for(int i=0; i<feedback.size(); i++){
            System.out.println("eh: "+i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        init();
        actualiza();

        botonEnviar.setEnabled(false);

        botonEnviar.setOnClickListener(this);
        botonAtras.setOnClickListener(this);

        botonSi1.setOnClickListener(this);
        botonSi2.setOnClickListener(this);
        botonSi3.setOnClickListener(this);

        botonNo1.setOnClickListener(this);
        botonNo2.setOnClickListener(this);
        botonNo3.setOnClickListener(this);

        Actividad actividad = (Actividad)getIntent().getSerializableExtra("actividad");

        tituloActividad.setText(actividad.getNombre());

    }

    private void actualiza(){
        if(contestado.get(0) && contestado.get(1) && contestado.get(2))
            botonEnviar.setEnabled(true);
    }

    @Override
    public void onClick(View v){

        if(v.getId() == R.id.botonEnviarFeedback){
            // Enviar por http
        }else if(v.getId() == R.id.botonAtrasFeedback){
            finish();
        }else if(v.getId() == R.id.botonSi1){
            // Almacenar pregunta 1 -> Si
            contestado.set(0,true);
            botonSi1.setEnabled(false);
            botonNo1.setEnabled(true);
            feedback.set(0,true);
            actualiza();
        }else if(v.getId() == R.id.botonSi2){
            contestado.set(1,true);
            botonSi2.setEnabled(false);
            botonNo2.setEnabled(true);
            feedback.set(1,true);
            actualiza();
        }else if(v.getId() == R.id.botonSi3){
            contestado.set(2,true);
            botonSi3.setEnabled(false);
            botonNo3.setEnabled(true);
            feedback.set(2,true);
            actualiza();
        }else if(v.getId() == R.id.botonNo1){
            contestado.set(0,true);
            botonSi1.setEnabled(true);
            botonNo1.setEnabled(false);
            feedback.set(0,false);
            actualiza();
        }else if(v.getId() == R.id.botonNo2){
            contestado.set(1,true);
            botonSi2.setEnabled(true);
            botonNo2.setEnabled(false);
            feedback.set(1,false);
            actualiza();
        }else if(v.getId() == R.id.botonNo3){
            contestado.set(2,true);
            botonSi3.setEnabled(true);
            botonNo3.setEnabled(false);
            feedback.set(2,false);
            actualiza();
        }
    }
}