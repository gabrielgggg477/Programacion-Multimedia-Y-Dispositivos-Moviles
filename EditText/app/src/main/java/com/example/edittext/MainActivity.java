package com.example.edittext;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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
        String[] opciones ={ "Griezmann", "Alvarez", "Oblak", "Llorente", "Koke"};
        AutoCompleteTextView textoLeido = findViewById(R.id.autocomplet);
        Spinner mySpinner = findViewById(R.id.miSpinner);
        CheckBox checkBox = findViewById(R.id.checkbox);
        EditText texto1 = findViewById(R.id.editNumber);

        Button buttonChecked = findViewById(R.id.buttonCheck);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Switch switch1 = findViewById(R.id.switch1);

        SeekBar seekBar = findViewById(R.id.slider);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        ProgressBar pb1 = findViewById(R.id.progressBarIndeterminate2);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, opciones);
        textoLeido.setAdapter(adaptador);
        mySpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones));
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Has seleccionado la opción"+mySpinner.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "No has seleccionado ninguna opción", Toast.LENGTH_SHORT).show();
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    Toast.makeText(MainActivity.this, "Has seleccionado el checkBox", Toast.LENGTH_SHORT).show();
                }
                else{

                }
            }
        });
        buttonChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId == 1){
                    findViewById(android.R.id.content).setBackgroundColor(android.graphics.Color.RED);
                }
                if(selectedId == 2){
                    findViewById(android.R.id.content).setBackgroundColor(android.graphics.Color.BLUE);
                }
                if(selectedId == 3){
                    findViewById(android.R.id.content).setBackgroundColor(android.graphics.Color.GREEN);
                }
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    findViewById(android.R.id.content).setBackgroundColor(android.graphics.Color.BLACK);
                }
                else{
                    findViewById(android.R.id.content).setBackgroundColor(android.graphics.Color.WHITE);
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this, "El volumen es: " + progress , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Slider se ha movido", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Estrellas: " + rating, Toast.LENGTH_SHORT).show();
            }
        });

        // ✅ Handler corregido
        Handler handler = new Handler(Looper.getMainLooper());
        final int[] v = {0};
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (v[0] <= 100) {
                    pb1.setProgress(v[0] += 5);
                    handler.postDelayed(this, 200);
                }
            }
        }, 200);

    }

}
