package com.example.tema5_adaptadores;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Datos[] datos = new Datos[]{
                new Datos("España", "Madrid"),
                new Datos("Francia", "Lisboa"),
                new Datos("Rusia", "Moscu"),
                new Datos("Alemania", "Berlín")
        };
        ListView listado = findViewById(R.id.listView);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);
    }
}