package com.example.tema5_adaptadores;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        View miCabecera = getLayoutInflater().inflate(R.layout.cabezera, null);

        Datos[] datos = new Datos[]{
                new Datos("España", "Madrid"),
                new Datos("Francia", "Lisboa"),
                new Datos("Rusia", "Moscu"),
                new Datos("Alemania", "Berlín")
        };
        ListView listado = findViewById(R.id.listView);
        listado.addHeaderView(miCabecera);
        Adaptador miAdaptador = new Adaptador(this, datos);

        listado.setAdapter(miAdaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectItem = ((Datos) parent.getItemAtPosition(position)).getTexto1();
                Toast.makeText(MainActivity.this, "Pais pulsado: " + selectItem, Toast.LENGTH_SHORT).show();
                String Capital = ((Datos) parent.getItemAtPosition(position)).getTexto2();
                Toast.makeText(MainActivity.this, "Capital: " + Capital, Toast.LENGTH_SHORT).show();
            }
        });
    }
}