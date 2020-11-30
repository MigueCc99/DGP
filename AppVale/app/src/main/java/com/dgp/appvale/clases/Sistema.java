package com.dgp.appvale.clases;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

public class Sistema extends AppCompatActivity implements Serializable {

    public Sistema(){
        crearSocioPrueba();
    }

    private void crearSocioPrueba(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1999);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 17);
        Date fecha = cal.getTime();
        Socio socio = new Socio("Miguel Ángel", "Campos", fecha);

        ContentValues register = new ContentValues();

        register.put("nombre", socio.getNombre());
        register.put("apellidos", socio.getApellidos());
        register.put("fechaNacimiento", socio.getFechaNacimiento().toString());

        database.insert("socios",null, register);

        database.close();
    }

    public Socio getSocio (String n){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administration", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        Cursor row = database.rawQuery("SELECT nombre, apellidos, fechaNacimiento FROM socios where nombre = '" + n + "'", null);

        Socio socio = null;
        if(row.moveToFirst()){
            // Arreglar fecha
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 1999);
            cal.set(Calendar.MONTH, Calendar.FEBRUARY);
            cal.set(Calendar.DAY_OF_MONTH, 17);
            Date fecha = cal.getTime();
            socio = new Socio (row.getString(0), row.getString(1), fecha);
        }

        return socio;
    }

    public boolean comparaContrasenia(Socio socio, int[] otra_contrasenia){
        boolean iguales = false;
        if(socio.getContrasenia().length == otra_contrasenia.length){
            iguales = true;
            for(int i = 0; i < otra_contrasenia.length && iguales; i++){
                if(otra_contrasenia[i] != socio.getContrasenia()[i])
                    iguales = false;
            }
        }

        return iguales;
    }

}
