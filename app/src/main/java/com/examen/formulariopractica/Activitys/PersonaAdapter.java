package com.examen.formulariopractica.Activitys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.examen.formulariopractica.R;


import java.util.ArrayList;
import java.util.List;

public class PersonaAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Persona> personas;

    private int layout;

    public PersonaAdapter(Context context,int layout, ArrayList<Persona>persona){

        this.context = context;

        this.personas = persona;

        this.layout = layout;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = view;

        ViewHolder holder;

        if(v==null){

            LayoutInflater layoutInflater = LayoutInflater.from(this.context);

            v = layoutInflater.inflate(this.layout,null);

            holder=new ViewHolder();

            holder.nombre = v.findViewById(R.id.txVNombre);
            holder.edad = v.findViewById(R.id.txvEdad);

            v.setTag(holder);
        }
        else{
            holder = (ViewHolder)v.getTag();
        }
        Persona pers = personas.get(position);
        holder.nombre.setText(pers.getNombre());
        holder.edad.setText(""+pers.getEdad());
        return v;
    }
    static  class ViewHolder{
        private TextView nombre;
        private TextView edad;
    }
}
