package com.example.practica2_gabrielgarcia;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Componentes de la interfaz
        AutoCompleteTextView autoCamarero = findViewById(R.id.autoCamarero);
        EditText editTotal = findViewById(R.id.editTotal);
        CheckBox checkPropina = findViewById(R.id.checkPropina);
        SeekBar seekPropina = findViewById(R.id.seekPropina);
        TextView textPorcentaje = findViewById(R.id.textPorcentaje);
        RadioGroup radioPago = findViewById(R.id.radioPago);
        RatingBar ratingServicio = findViewById(R.id.ratingServicio);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        TextView textResultado = findViewById(R.id.textResultado);

        String[] camareros = {"Laura", "Juan", "Marta", "Pedro", "Lucía", "Mario", "Jose"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, camareros);
        autoCamarero.setAdapter(adapter);
        autoCamarero.setThreshold(3);

        seekPropina.setMax(30);
        seekPropina.setProgress(10);
        textPorcentaje.setText("Porcentaje de propina: 10%");

        seekPropina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textPorcentaje.setText("Porcentaje de propina: " + progress + "%");
            }
            @Override public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // Botón calcular
        btnCalcular.setOnClickListener(v -> {
            String totalStr = editTotal.getText().toString().trim();

            // Validaciones
            if (totalStr.isEmpty()) {
                textResultado.setTextColor(Color.RED);
                textResultado.setText("Falta introducir el valor de la cuenta.");
                return;
            }

            double total;
            try {
                total = Double.parseDouble(totalStr);
            } catch (NumberFormatException e) {
                textResultado.setTextColor(Color.RED);
                textResultado.setText("Introduce un número válido.");
                return;
            }

            if (total <= 0) {
                textResultado.setTextColor(Color.RED);
                textResultado.setText("El valor de la cuenta debe ser mayor que 0.");
                return;
            }

            // Calcular propina si está seleccionada
            double totalConPropina = total;
            if (checkPropina.isChecked()) {
                int porcentaje = seekPropina.getProgress();
                totalConPropina += total * porcentaje / 100.0;
            }

            // Método de pago
            int selectedId = radioPago.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(selectedId);
            String metodoPago = radioButton != null ? radioButton.getText().toString() : "Desconocido";

            // Calificación
            float estrellas = ratingServicio.getRating();

            // Mostrar resultado simple
            textResultado.setTextColor(Color.BLACK);
            textResultado.setText("Total final: " + String.format("%.2f", totalConPropina) + "\nMétodo de pago: " + metodoPago +  "\nCalificación: " + estrellas);
        });
    }
}
