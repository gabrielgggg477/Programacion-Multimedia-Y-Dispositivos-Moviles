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

    /**
     * Este método se utiliza para recibir una cadena de texto y devuelve la cadena que se encuentre después de cualquier operador hasta el final
     * @param texto
     * @return
     */
    private String obtenerUltimoNumero(String texto) {
        int ultimaPos = -1;
        for (int i = texto.length() - 1; i >= 0; i--) {
            char c = texto.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                ultimaPos = i;
                break;
            }
        }
        return texto.substring(ultimaPos + 1);
    }

    /**
     * Este método sirve para evitar varios puntos simultaneos, devuelve verdadero o falso, según si ya contiene un "." o no
     * @param textoActual
     * @return
     */
    private boolean puedeAgregarPunto(String textoActual) {
        String ultimoNumero = obtenerUltimoNumero(textoActual);
        return !ultimoNumero.contains(".");
    }

    /**
     * Este comprueba que el caracter anterior al que vas a escribir y valida si es un operador, si es un operador devuelve "false"
     * @param textActual
     * @return
     */
    private boolean anteriorCaract(String textActual){
        char ultimoNumero = textActual.charAt(textActual.length()-1);
        if(ultimoNumero == '+' || ultimoNumero == '-' || ultimoNumero == '*' || ultimoNumero == '/' ){
            return false;
        }
        return true;
    }

    protected void onStart(){
        super.onStart();
        /**
         * Este textView, sirve para almacenar el contenido escrito
         */
        TextView texto = findViewById(R.id.texto);
        /**
         * Sirve para cada uno de los botones enlazarlos con los del diseño, y cada uno de ellos con su onClickListener
         */
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
        /**
         * Dentro del botón de ".", compruebo antes de escribirlo, si es posible según la cantidad de . que haya dentro del número, si el anterior es un operador, además si el tamaño es diferente a 0 (para evitar escribir un . al principio)
         */
        botonpunto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String textoActual = texto.getText().toString();
                    if (puedeAgregarPunto(textoActual) && anteriorCaract(textoActual)) {
                        if(texto.length() != 0){
                            char ultimoChar = texto.getText().toString().charAt(texto.length() - 1);
                            if(ultimoChar == '.'){

                            }
                            else{
                                texto.setText(texto.getText() + ".");
                            }
                        }
                    }
            }

        });
        /**
         * En todos los operadores cada vez que se pulsa en el botón, analiza si el ultimo caracter escrito es igual a un punto, en caso de ser así mantiene el texto como está
         * En caso de que el ultimo caracter sea cualquier operador elimina la ultima posición (con el substring coge toda la cadena, menos el ultimo) y agrega el operador pulsado
         * En caso de que no sea ninguno de estos casos escribe el operador
         */
        Button botondivdir = findViewById(R.id.botonbarra);
        botondivdir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String textoActual = texto.getText().toString();
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);
                if(ultimoChar == '.'){
                    texto.setText(textoActual);
                    return;
                }
                if(ultimoChar == '*' || ultimoChar == '/' || ultimoChar == '+' || ultimoChar == '-'){
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

                String textoActual = texto.getText().toString();
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);

                if(ultimoChar == '.'){
                    texto.setText(textoActual);
                    return;
                }
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

                String textoActual = texto.getText().toString();
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);

                if(ultimoChar == '.'){
                    texto.setText(textoActual);
                    return;
                }
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

                String textoActual = texto.getText().toString();
                char ultimoChar = textoActual.charAt(textoActual.length() - 1);

                if(ultimoChar == '.'){
                    texto.setText(textoActual);
                    return;
                }
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
        /**
         * En el botón de C, en caso de que el tamaño del texto es 0, se escribirá un 0
         * En cualquier otro caso suprimirá la ultima posición es decir, coge desde la posición 0 hasta la ultima - 1
         */
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
        /**
         * Este cuando se pulsa el texto del textView se muestra en 0
         */
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

            }

        });
    };
}
