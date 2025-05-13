package com.examen.formulariopractica.Activitys;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.examen.formulariopractica.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityLista extends AppCompatActivity {
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);

        cargarElementosGraficos();

        Bundle bundle = getIntent().getExtras();
        ArrayList<Persona> personas2 = bundle.getSerializable("personas", ArrayList.class);
        ArrayList<Persona> personas = null;

        if (bundle != null && bundle.getSerializable("listaPersonas", ArrayList.class) != null) {
            personas = bundle.getSerializable("personas", ArrayList.class);
        } else {
            Toast.makeText(ActivityLista.this, "Intent no esperado", Toast.LENGTH_LONG).show();
        }


        PersonaAdapter adaptador = new PersonaAdapter(this, R.layout.item_persona, personas);

        listView.setAdapter(adaptador);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_lista), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void cargarElementosGraficos(){
        listView = findViewById(R.id.vistaLista);
    }
}