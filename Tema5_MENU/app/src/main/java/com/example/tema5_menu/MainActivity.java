package com.example.tema5_menu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import androidx.activity.EdgeToEdge;

public class MainActivity extends AppCompatActivity {

    // Solo declaramos la variable aquí
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.TEXT);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);

        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_refrescar) {
            Toast.makeText(this, "Refrescando...", Toast.LENGTH_SHORT).show();
            textView.setText("Refrescando");
            return true;
        } else if (id == R.id.action_ajustes) {
            Toast.makeText(this, "Ajustes...", Toast.LENGTH_SHORT).show();
            textView.setText("Ajustes");
            return true;
        } else if (id == R.id.action_info) {
            Toast.makeText(this, "Información", Toast.LENGTH_SHORT).show();
            textView.setText("Información");
            return true;
        } else if (id == R.id.action_acercade) {
            Toast.makeText(this, "Acerca de...", Toast.LENGTH_SHORT).show();
            textView.setText("Acerca de");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refrescar) {
            Toast.makeText(this, "Refrescando...", Toast.LENGTH_SHORT).show();
            textView.setText("Refrescando");
            return true;
        } else if (id == R.id.action_ajustes) {
            Toast.makeText(this, "Ajustes...", Toast.LENGTH_SHORT).show();
            textView.setText("Ajustes");
            return true;
        } else if (id == R.id.action_info) {
            Toast.makeText(this, "Información", Toast.LENGTH_SHORT).show();
            textView.setText("Información");
            return true;
        } else if (id == R.id.action_acercade) {
            Toast.makeText(this, "Acerca de...", Toast.LENGTH_SHORT).show();
            textView.setText("Acerca de");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
