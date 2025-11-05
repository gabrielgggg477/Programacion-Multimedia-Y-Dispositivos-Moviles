package com.example.tema4;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txtEstado;
    private ToggleButton toggleBtn;
    private ImageButton txtImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.linearlayout);
        txtEstado = findViewById(R.id.txtEstado);
        toggleBtn = findViewById(R.id.boton);
        txtImg = findViewById(R.id.imagen);
        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    txtEstado.setText("Estado : pulsado");
                }
                else{
                    txtEstado.setText("Estado : no Pulsado");
                }
            }
        });
        txtImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Has pulsado el ImageButton", Toast.LENGTH_SHORT).show();
                txtImg.setImageResource(R.drawable.pausa);
                if(txtImg.isActivated()){
                    txtImg.setImageResource(R.drawable.continua);
                }
                else{
                    txtImg.setImageResource(R.drawable.pausa);
                }
            }
        });
    }

}