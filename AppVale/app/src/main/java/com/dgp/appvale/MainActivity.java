package com.dgp.appvale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dgp.appvale.clases.Sistema;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Sistema sistema;
    private boolean debug = true;

    private void init (){
        sistema = new Sistema();
        //ejecutarServicio("http://192.168.1.101:80/appVale/insertar_socio.php");
    }

    private void ejecutarServicio(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                System.out.println(error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("nombre", sistema.getSocio().getNombre());
                parametros.put("apellidos", sistema.getSocio().getApellidos());
                parametros.put("fecha", sistema.getSocio().getFechaNacimiento().toString());
                parametros.put("id", String.valueOf(sistema.getSocio().getID()));
                return super.getParams();
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        Button boton = (Button) findViewById(R.id.botonAccesoLogin);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(!debug){
            Intent i = new Intent(this, LoginActivity.class);
            //Lanzo activity Login
            startActivity(i);
        }else{
            Intent i = new Intent(this, ActividadesActivity.class);
            //Lanzo activity Login
            startActivity(i);
        }
    }
}
