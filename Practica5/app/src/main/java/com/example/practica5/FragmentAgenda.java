package com.example.practica5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAgenda extends Fragment {

    private TextView textoPantalla;
    private String operacionActual = "";
    private double numero1 = 0;
    private boolean nuevaOperacion = true;
    private boolean puntoDecimal = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agenda, container, false);

        // Inicializar la pantalla
        textoPantalla = view.findViewById(R.id.texto);

        // Configurar todos los botones
        configurarBotones(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Opcional: Configurar botón de regreso
        configurarBotonRegreso(view);
    }

    private void configurarBotones(View view) {
        // Botones numéricos
        configurarBotonNumerico(view, R.id.boton0, "0");
        configurarBotonNumerico(view, R.id.boton1, "1");
        configurarBotonNumerico(view, R.id.boton2, "2");
        configurarBotonNumerico(view, R.id.boton3, "3");
        configurarBotonNumerico(view, R.id.boton4, "4");
        configurarBotonNumerico(view, R.id.boton5, "5");
        configurarBotonNumerico(view, R.id.boton6, "6");
        configurarBotonNumerico(view, R.id.boton7, "7");
        configurarBotonNumerico(view, R.id.boton8, "8");
        configurarBotonNumerico(view, R.id.boton9, "9");

        // Botón punto decimal
        view.findViewById(R.id.botonpunto).setOnClickListener(v -> {
            if (!puntoDecimal) {
                if (nuevaOperacion) {
                    textoPantalla.setText("0.");
                    nuevaOperacion = false;
                } else {
                    textoPantalla.append(".");
                }
                puntoDecimal = true;
            }
        });

        // Botones de operaciones
        configurarBotonOperacion(view, R.id.botonmas, "+");
        configurarBotonOperacion(view, R.id.botonmenos, "-");
        configurarBotonOperacion(view, R.id.botonbarra, "/");
        configurarBotonOperacion(view, R.id.botonasterisco, "*");

        // Botón igual
        view.findViewById(R.id.botonigual).setOnClickListener(v -> calcularResultado());

        // Botones de limpieza
        view.findViewById(R.id.c).setOnClickListener(v -> {
            String textoActual = textoPantalla.getText().toString();
            if (!textoActual.isEmpty()) {
                if (textoActual.endsWith(".")) {
                    puntoDecimal = false;
                }
                textoPantalla.setText(textoActual.substring(0, textoActual.length() - 1));
                if (textoPantalla.getText().toString().isEmpty()) {
                    nuevaOperacion = true;
                }
            }
        });

        view.findViewById(R.id.ac).setOnClickListener(v -> {
            textoPantalla.setText("");
            numero1 = 0;
            operacionActual = "";
            nuevaOperacion = true;
            puntoDecimal = false;
        });
    }

    private void configurarBotonNumerico(View view, int id, String numero) {
        Button boton = view.findViewById(id);
        boton.setOnClickListener(v -> {
            if (nuevaOperacion) {
                textoPantalla.setText(numero);
                nuevaOperacion = false;
            } else {
                textoPantalla.append(numero);
            }
        });
    }

    private void configurarBotonOperacion(View view, int id, String operacion) {
        Button boton = view.findViewById(id);
        boton.setOnClickListener(v -> {
            try {
                String texto = textoPantalla.getText().toString();
                if (!texto.isEmpty()) {
                    numero1 = Double.parseDouble(texto);
                    operacionActual = operacion;
                    nuevaOperacion = true;
                    puntoDecimal = false;
                }
            } catch (NumberFormatException e) {
                textoPantalla.setText("Error");
            }
        });
    }

    private void calcularResultado() {
        try {
            String texto = textoPantalla.getText().toString();
            if (!texto.isEmpty() && !operacionActual.isEmpty()) {
                double numero2 = Double.parseDouble(texto);
                double resultado = 0;

                switch (operacionActual) {
                    case "+":
                        resultado = numero1 + numero2;
                        break;
                    case "-":
                        resultado = numero1 - numero2;
                        break;
                    case "*":
                        resultado = numero1 * numero2;
                        break;
                    case "/":
                        if (numero2 != 0) {
                            resultado = numero1 / numero2;
                        } else {
                            textoPantalla.setText("Error: Div/0");
                            return;
                        }
                        break;
                }

                // Mostrar resultado
                if (resultado == (long) resultado) {
                    textoPantalla.setText(String.valueOf((long) resultado));
                } else {
                    textoPantalla.setText(String.valueOf(resultado));
                }

                // Resetear variables
                numero1 = resultado;
                operacionActual = "";
                nuevaOperacion = true;
                puntoDecimal = textoPantalla.getText().toString().contains(".");
            }
        } catch (NumberFormatException e) {
            textoPantalla.setText("Error");
        }
    }

    private void configurarBotonRegreso(View view) {
        // Usar doble clic en AC para regresar
        view.findViewById(R.id.ac).setOnLongClickListener(v -> {
            // Regresar al ViewPager
            requireActivity().onBackPressed();
            return true;
        });
    }
}