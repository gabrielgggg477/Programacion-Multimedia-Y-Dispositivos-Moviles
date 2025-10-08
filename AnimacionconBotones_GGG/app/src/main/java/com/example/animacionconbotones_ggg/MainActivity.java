package com.example.animacionconbotones_ggg;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

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
        setContentView(R.layout.linear);

    }
    protected void onStart(){
        super.onStart();
        TextView texto = findViewById(R.id.texto);
        Button boton1 = findViewById(R.id.button1);
        Button boton2 = findViewById(R.id.button2);
        Button boton3 = findViewById(R.id.button3);
        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.translate);
        Animation segundaAnimacion = AnimationUtils.loadAnimation(this, R.anim.rotate);
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.startAnimation(miAnimacion);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.startAnimation(segundaAnimacion);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(miAnimacion != null || segundaAnimacion != null){
                   texto.clearAnimation();
                   miAnimacion.cancel();
                   segundaAnimacion.cancel();
               }
            }
        });

    }

}