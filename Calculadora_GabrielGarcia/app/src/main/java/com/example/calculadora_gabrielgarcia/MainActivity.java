package com.example.calculadora_gabrielgarcia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.gridlayout);
    }
    protected void onStart(){
        super.onStart();
        TextView texto = findViewById(R.id.texto);
        ArrayList<Double> lista = new ArrayList<>();
        ArrayList<String> operadores = new ArrayList<>();
        final double[] numero1 = {0};
        final double[] numero2 = {0};

        final String[] operador = {""};
        Button boton0 = findViewById(R.id.boton0);
        boton0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int pos = texto.length();
                if(pos == 0){

                }
                else{
                    String primero = texto.getText().toString();
                    if(primero.equals("0")){
                        texto.setText("0");
                    }
                    else{
                        texto.setText( texto.getText() + "0");
                    }
                }
            }

        });
        Button boton1 = findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String primero = texto.getText().toString();
                if(primero.equals("0")){
                    texto.setText("1");
                }
                else{
                    texto.setText( texto.getText() + "1");
                }
            }

        });
        Button boton2 = findViewById(R.id.boton2);
        boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String primero = texto.getText().toString();
                if(primero.equals("0")){
                    texto.setText("2");
                }
                else{
                    texto.setText( texto.getText() + "2");
                }
            }

        });
        Button boton3 = findViewById(R.id.boton3);
        boton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String primero = texto.getText().toString();
                if(primero.equals("0")){
                    texto.setText("3");
                }
                else{
                    texto.setText( texto.getText() + "3");
                }
            }

        });
        Button boton4 = findViewById(R.id.boton4);
        boton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String primero = texto.getText().toString();
                if(primero.equals("0")){
                    texto.setText("4");
                }
                else{
                    texto.setText( texto.getText() + "4");
                }
            }

        });
        Button boton5 = findViewById(R.id.boton5);
        boton5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String primero = texto.getText().toString();
                if(primero.equals("0")){
                    texto.setText("5");
                }
                else{
                    texto.setText( texto.getText() + "5");
                }
            }

        });
        Button boton6 = findViewById(R.id.boton6);
        boton6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String primero = texto.getText().toString();
                if(primero.equals("0")){
                    texto.setText("6");
                }
                else{
                    texto.setText( texto.getText() + "6");
                }
            }

        });
        Button boton7 = findViewById(R.id.boton7);
        boton7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String primero = texto.getText().toString();
                if(primero.equals("0")){
                    texto.setText("7");
                }
                else{
                    texto.setText( texto.getText() + "7");
                }
            }

        });
        Button boton8 = findViewById(R.id.boton8);
        boton8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String primero = texto.getText().toString();
                if(primero.equals("0")){
                    texto.setText("8");
                }
                else{
                    texto.setText( texto.getText() + "8");
                }
            }

        });
        Button boton9 = findViewById(R.id.boton9);
        boton9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String primero = texto.getText().toString();
                if(primero.equals("0")){
                    texto.setText("9");
                }
                else{
                    texto.setText( texto.getText() + "9");
                }
            }

        });
        Button botonpunto = findViewById(R.id.botonpunto);
        botonpunto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(texto.length() != 0){
                    char ultimoChar = texto.getText().toString().charAt(texto.length() - 1);
                    if(ultimoChar == '.'){
                        System.out.println("ladfsfjdsalkj");
                    }
                    else{
                        texto.setText(texto.getText() + ".");
                    }
                }
            }

        });
        Button botondivdir = findViewById(R.id.botonbarra);
        botondivdir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //numero1[0] = Double.parseDouble(texto.getText().toString());
                //operador[0] = "/";
                operadores.add("/");

                String textoActual = texto.getText().toString();
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);

                if(ultimoChar == '*' || ultimoChar == '/' || ultimoChar == '+' || ultimoChar == '-'){
                    System.out.println(ultimoChar);
                    String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
                    texto.setText(nuevoTexto + "/");

                }
                else{
                    texto.setText(texto.getText().toString() + "/");

                }

            }

        });
        Button botonasterisco = findViewById(R.id.botonasterisco);
        botonasterisco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //numero1[0] =  Double.parseDouble(texto.getText().toString());
                //operador[0] = "*";
                operadores.add("*");

                String textoActual = texto.getText().toString();
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);

                if(ultimoChar == '*' || ultimoChar == '/' || ultimoChar == '+' || ultimoChar == '-'){
                    System.out.println(ultimoChar);
                    String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
                    texto.setText(nuevoTexto + "*");
                }
                else{
                    texto.setText(texto.getText().toString() + "*");


                }
            }

        });
        Button botonmenos = findViewById(R.id.botonmenos);
        botonmenos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //numero1[0] =  Double.parseDouble(texto.getText().toString());
                //operador[0] = "-";
                operadores.add("-");

                String textoActual = texto.getText().toString();
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);

                if(ultimoChar == '*' || ultimoChar == '/' || ultimoChar == '+' || ultimoChar == '-'){
                    System.out.println(ultimoChar);
                    String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
                    texto.setText(nuevoTexto + "-");

                }
                else{
                    texto.setText(texto.getText().toString() + "-");

                }
            }

        });
        Button botonmas = findViewById(R.id.botonmas);
        botonmas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //numero1[0] = Double.parseDouble(texto.getText().toString());
                //operador[0] = "+";
                operadores.add("+");

                String textoActual = texto.getText().toString();
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);

                if(ultimoChar == '*' || ultimoChar == '/' || ultimoChar == '+' || ultimoChar == '-'){
                    System.out.println(ultimoChar);
                    String nuevoTexto = textoActual.substring(0, textoActual.length() - 1);
                    texto.setText(nuevoTexto + "+");

                }
                else{
                    texto.setText(texto.getText().toString() + "+");

                }
            }

        });
        Button c = findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int pos = texto.length();
                if(pos == 0){
                    texto.setText("0");
                }
                else{
                    String textofinal = texto.getText().toString();
                    texto.setText(textofinal.substring(0, texto.length() - 1));
                }
            }

        });
        Button ac = findViewById(R.id.ac);
        ac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                texto.setText("0");
            }

        });

        Button botonigual = findViewById(R.id.botonigual);
        botonigual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                System.out.println(lista);
                numero2[0] = Double.parseDouble(texto.getText().toString());
                double numeroFinal = 0;
                if(operador[0] == "*"){
                    numeroFinal = numero1[0] * numero2[0];
                }
                else if(operador[0]== "/"){
                    numeroFinal = numero1[0] / numero2[0];
                }
                else if(operador[0]== "+"){
                    numeroFinal = numero1[0] + numero2[0];
                }
                else if(operador[0]== "-"){
                    numeroFinal = numero1[0] - numero2[0];
                }
                else{
                    numeroFinal = 0;
                }
                texto.setText(String.valueOf(numeroFinal));
            }

        });
    };
}
