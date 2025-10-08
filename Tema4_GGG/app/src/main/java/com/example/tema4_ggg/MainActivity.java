package com.example.tema4_ggg;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    }
    protected void onStart(){
        super.onStart();
        TextView miTexto = findViewById(R.id.texto);
        miTexto.setText("Nuevo texto a mostrar");
        miTexto.setTextColor(Color.parseColor("#CDDC39"));
        miTexto.setTextColor(Color.RED);
        miTexto.setTypeface(null, Typeface.ITALIC);
        miTexto.setTextSize(24);
        miTexto.setTypeface(Typeface.SANS_SERIF);
        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        miTexto.startAnimation(miAnimacion);



    }
}