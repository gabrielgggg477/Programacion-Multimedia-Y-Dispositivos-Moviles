package com.example.listacompra;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvItems;
    private Spinner spinnerItems;
    private EditText etNombre, etCantidad;
    private Button btnAgregar;

    private ArrayList<Item> listaItems;
    private ShoppingListAdapter adapter;

    private ArrayList<Item> spinnerItemList;
    private SpinnerAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = findViewById(R.id.lvItems);
        spinnerItems = findViewById(R.id.spinnerItems);
        etNombre = findViewById(R.id.etNombre);
        etCantidad = findViewById(R.id.etCantidad);
        btnAgregar = findViewById(R.id.btnAgregar);

        // Lista para ListView
        listaItems = new ArrayList<>();
        adapter = new ShoppingListAdapter(this, listaItems);
        lvItems.setAdapter(adapter);

        spinnerItemList = new ArrayList<>();
        spinnerItemList.add(new Item(getString(R.string.item_leche), 1, R.drawable.leche));
        spinnerItemList.add(new Item(getString(R.string.item_pan), 1, R.drawable.pan));
        spinnerItemList.add(new Item(getString(R.string.item_huevos), 1, R.drawable.huevos));
        spinnerItemList.add(new Item(getString(R.string.item_manzana), 1, R.drawable.manzana));


        spinnerAdapter = new SpinnerAdapter(this, spinnerItemList);
        spinnerItems.setAdapter(spinnerAdapter);

        // Spinner seleccion
        spinnerItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Item item = spinnerItemList.get(position);
                etNombre.setText(item.getNombre());
                etCantidad.setText(String.valueOf(item.getCantidad()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                etNombre.setText("");
                etCantidad.setText("");
            }
        });

        // Botón agregar
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString().trim();
                String cantidadStr = etCantidad.getText().toString().trim();

                if (nombre.isEmpty() || cantidadStr.isEmpty() || cantidadStr.equals("0")) {
                    Toast.makeText(MainActivity.this, R.string.toast_faltan_datos, Toast.LENGTH_SHORT).show();
                    return;
                }

                int cantidad;
                try {
                    cantidad = Integer.parseInt(cantidadStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, R.string.toast_faltan_datos, Toast.LENGTH_SHORT).show();
                    return;
                }

                Item selectedItem = (Item) spinnerItems.getSelectedItem();
                int imagenResId = selectedItem.getImagenResId();

                listaItems.add(new Item(nombre, cantidad, imagenResId));
                adapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, R.string.btn_agregar, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
