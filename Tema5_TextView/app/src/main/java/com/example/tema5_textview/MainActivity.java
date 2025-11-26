package com.example.tema5_textview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // Comentado si no tienes esa clase
        setContentView(R.layout.linear);

        List<String> data = Arrays.asList("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4");

        ListView listView = findViewById(R.id.listview);
        ArrayList<String> itemList = new ArrayList<>();
        itemList.add("Elemento 1");
        itemList.add("Elemento 2");
        itemList.add("Elemento 3");
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        TextView textView = findViewById(R.id.texto);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Cambiar el texto del TextView al item seleccionado
                String selectedItem = data.get(position);
                textView.setText("Seleccionado: " + selectedItem);
            }
        });
    }
}
