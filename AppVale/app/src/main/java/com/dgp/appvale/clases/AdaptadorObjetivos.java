package com.dgp.appvale.clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dgp.appvale.R;

import java.util.ArrayList;

public class AdaptadorObjetivos extends BaseAdapter {
    private Context context;
    private ArrayList<Objetivo> listObjetivos;

    public AdaptadorObjetivos (Context context, ArrayList<Objetivo> listObjetivos){
        this.context = context;
        this.listObjetivos = listObjetivos;
    }

    @Override
    public int getCount() {
        return listObjetivos.size();
    }

    @Override
    public Object getItem(int position) {
        return listObjetivos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Objetivo objetivo = (Objetivo) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.objetivo_lista, null);
        ImageView imagenObjetivo = (ImageView) convertView.findViewById(R.id.imagenObjetivo);
        TextView nombreObjetivo = (TextView) convertView.findViewById(R.id.nombreObjetivo);
        TextView descripcionObjetivo = (TextView) convertView.findViewById(R.id.descripcionObjetivo);

        imagenObjetivo.setImageResource(objetivo.getImgFoto());
        nombreObjetivo.setText(objetivo.getNombre());
        descripcionObjetivo.setText(objetivo.getDescripcionObjetivo());

        return convertView;
    }
}
