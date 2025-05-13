package Controladores;

import android.content.Intent;
import android.view.View;

import com.examen.formulariopractica.Activitys.ActivityLista;
import com.examen.formulariopractica.Activitys.MainActivity;
import com.examen.formulariopractica.Activitys.Persona;
import com.examen.formulariopractica.R;

import java.util.ArrayList;

public class Controlador implements View.OnClickListener {

    private MainActivity activity;

    private final int EDADMAX = 110;

    private final int EDADMIN = 18;

    private final int VALMAX = 10;

    private final int VALMIN = 1;

    private ArrayList<Persona> listaPersonas;

    private int correcto;

    private int incorrecto;

    private Intent intent;

    public Controlador(MainActivity activity) {


        this.activity = activity;

        this.listaPersonas = new ArrayList<>();

        correcto = activity.getColor(R.color.color_correcto);

        incorrecto = activity.getColor(R.color.color_error);


    }



    @Override
    public void onClick(View view) {
        boolean datoCorrecto = false;

        if(view.getId() == R.id.btnMostrarLista){
            intent = new Intent(activity, ActivityLista.class);
            intent.putExtra("listaPersonas",listaPersonas);
            activity.startActivity(intent);
        }

        if(view.getId() == R.id.btnValidar){
            if (!validarNombre()) {
                activity.mostrarMensaje("Por favor, ingresa un nombre válido.");
                return;
            }

            if (!validarEdad()) {
                activity.mostrarMensaje("Por favor, ingresa una edad válida (1 - 110).");
                return;
            }

            if (!validarValoracion()) {
                activity.mostrarMensaje("Por favor, ingresa una valoración válida (1 - 10).");
                return;
            }

            if (!validarSexo()) {
                activity.mostrarMensaje("Por favor, selecciona un género.");
                return;
            }

            activity.mostrarMensaje("Datos correctos, formulario enviado.");

            String nombre = activity.getNombre();
            String anyos = activity.getEdad();
            Persona persona = new Persona(nombre,anyos);

            listaPersonas.add(persona);


            activity.resetCampos();
        }

    }




    public boolean validarNombre(){

        String nombre = activity.getNombre();
        return !nombre.trim().isEmpty();
    }

    public boolean validarEdad(){
        String edadStr = activity.getEdad();
        if (edadStr.trim().isEmpty()) {
            return false;
        }

        try {
            int edad = Integer.parseInt(activity.getEdad());
            return edad >= EDADMIN && edad <= EDADMAX;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public boolean validarValoracion(){
        String valoracionStr = activity.getValoracion();
        if (valoracionStr.trim().isEmpty()) {
            return false;
        }
        try {
            int valoracion = Integer.parseInt(activity.getValoracion());
            return valoracion >= VALMIN && valoracion <= VALMAX;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public boolean validarSexo(){
        return activity.getFem() || activity.getMasc();
    }

}
