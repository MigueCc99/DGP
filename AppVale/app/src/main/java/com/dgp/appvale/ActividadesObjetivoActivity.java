package com.dgp.appvale;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonArrayRequest;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.Volley;
        import com.dgp.appvale.clases.Actividad;
        import com.dgp.appvale.clases.Data;
        import com.dgp.appvale.clases.Socio;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;

public class ActividadesObjetivoActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton botonAtrasActividades, botonActActividades, botonFlechaDerecha, botonFlechaIzquierda;
    TextView tituloActAct;
    Actividad actividad;
    int actividadActual = 0;;

    private void init(){
        botonActActividades = findViewById(R.id.botonActActividades);
        botonAtrasActividades = findViewById(R.id.botonAtrasActividades);
        botonFlechaDerecha = findViewById(R.id.botonFlechaDerecha);
        botonFlechaIzquierda = findViewById(R.id.botonFlechaIzquierda);
        tituloActAct = findViewById(R.id.tituloActAct);

        actividad = new Actividad();
        getActividadesObjetivos();
        gestiónActividadActual();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        init();

        botonActActividades.setOnClickListener(this);
        botonAtrasActividades.setOnClickListener(this);
        botonFlechaDerecha.setOnClickListener(this);
        botonFlechaIzquierda.setOnClickListener(this);
    }

    private void gestiónActividadActual() {
        actividad = Data.getData().getActividades().get(actividadActual);
        System.out.println("Actividad actual= " + actividadActual);
        if(actividad.getDireccionFoto() == "cordones.png")
            botonActActividades.setImageResource(R.drawable.cordon);
        else if(actividad.getDireccionFoto() == "lavadora.png")
            botonActActividades.setImageResource(R.drawable.lavadora);
        else
            botonActActividades.setImageResource(R.drawable.activity);

        tituloActAct.setText(actividad.getNombre());
    }

    private void getActividadesObjetivos(){
        for(int i=0; i<Data.getData().getObjetivos().size(); i++){
            String url = Global.URL_FIJA + Global.URL_OBJETIVOS + "/" + Data.getData().getActividades().get(i).getID() + Global.URL_ACTIVIDADES;
            RequestQueue queue = Volley.newRequestQueue(this);

            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>(){
                        @Override
                        public void onResponse(JSONArray response) {
                            JSONObject jsonObject;
                            int idActividad = 0;
                            String nombreActividad, descripcionActividad, imagenActividad, multimediaActividad;
                            Actividad actividad;
                            for(int i=0; i<response.length(); i++){
                                try {
                                    jsonObject = (JSONObject) response.get(i);
                                    idActividad = jsonObject.getInt("id");
                                    nombreActividad = jsonObject.getString("nombre");
                                    descripcionActividad = jsonObject.getString("descripcion");
                                    imagenActividad = jsonObject.getString("imagen");
                                    multimediaActividad = jsonObject.getString("multimedia");
                                    actividad = new Actividad(idActividad, nombreActividad, descripcionActividad, imagenActividad, multimediaActividad);
                                    Data.getData().getActividadesObjetivos().get(i).add(actividad);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    },
                    new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error.Response", error.toString());
                        }
                    }
            );
            queue.add(jsonArrayRequest);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.botonActActividades){
            // Intent a Actividad concreta
            Intent i = new Intent(this, ActividadActivity.class);
            gestiónActividadActual();
            i.putExtra("actividad", actividad);
            startActivity(i);
        }else if(v.getId() == R.id.botonAtrasActividades){
            finish();
        }else if(v.getId() == R.id.botonFlechaDerecha){
            /* Enlaza a actividad siguiente si la hay
               ACT1 -- ACT2 -- ACT3 (array 3 actividades)
               Si estamos en ACT1 (pantalla muestra ACT1)
               Si pulsamos botonFlechaDerecha pasamos a mostrar ACT2
             */
            if(actividadActual+1 < Data.getData().getActividades().size()){
                actividadActual += 1;
                gestiónActividadActual();
            }
        }else if(v.getId() == R.id.botonFlechaIzquierda){
            /* Enlaza a actividad anterior si la hay
               ACT1 -- ACT2 -- ACT3 (array 3 actividades)
               Si estamos en ACT2 (pantalla muestra ACT2)
               Si pulsamos botonFlechaDerecha pasamos a mostrar ACT1
             */
            if(actividadActual-1 >= 0){
                actividadActual -= 1;
                gestiónActividadActual();
            }
        }
    }
}
