package com.examen.formulariopractica.Activitys;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.examen.formulariopractica.R;

import java.util.ArrayList;

import Controladores.Controlador;

public class MainActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText edad;
    private EditText valoracion;
    private RadioButton masc;
    private RadioButton fem;
    private Button validar;
    private Controlador ctrl;
    private Button lista;
    private int incorrecto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        cargarElementosGraficos();

        incorrecto = getColor(R.color.color_error);

        ctrl = new Controlador(this);

        validar.setOnClickListener(ctrl);

        lista.setOnClickListener(ctrl);

    }
    private void cargarElementosGraficos(){

        nombre = findViewById(R.id.edtxNombre);

        edad = findViewById(R.id.edtxEdad);

        valoracion = findViewById(R.id.edtxValoracion);

        masc = findViewById(R.id.rdBtnMasc);

        fem = findViewById(R.id.rdBtnFem);

        validar = findViewById(R.id.btnValidar);

        lista = findViewById(R.id.btnMostrarLista);
    }



    public String getNombre(){
        return String.valueOf(nombre.getText());
    }

    public String getEdad(){
        return String.valueOf(edad.getText());
    }

    public String getValoracion(){
        return String.valueOf(valoracion.getText());
    }

    public boolean getFem() {
        return fem.isChecked();
    }

    public boolean getMasc() {
        return masc.isChecked();
    }

    public void resetCampos(){
        edad.setText("");
        nombre.setText("");
        valoracion.setText("");
        masc.setChecked(false);
        fem.setChecked(false);
    }

    public void mostrarMensaje(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }


    public void cambiarColorMal(EditText campo){
        campo.setTextColor(incorrecto);
    }
}