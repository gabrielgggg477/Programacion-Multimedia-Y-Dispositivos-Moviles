package com.example.practica5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    private boolean calculadoraVisible = false;
    private FrameLayout contenedorCalculadora;
    private LinearLayout mainLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        Button btn = view.findViewById(R.id.btn);

        // Crear contenedor dinámicamente si no existe en el XML
        mainLayout = (LinearLayout) view;

        // Crear FrameLayout para la calculadora
        contenedorCalculadora = new FrameLayout(requireContext());
        contenedorCalculadora.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        contenedorCalculadora.setId(View.generateViewId()); // Generar ID único

        // Inflar la calculadora dentro del contenedor
        FragmentAgenda fragmentAgenda = new FragmentAgenda();
        getChildFragmentManager().beginTransaction()
                .replace(contenedorCalculadora.getId(), fragmentAgenda)
                .commit();

        // Ocultar inicialmente
        contenedorCalculadora.setVisibility(View.GONE);

        // Agregar contenedor al layout principal
        mainLayout.addView(contenedorCalculadora);

        btn.setOnClickListener(v -> {
            if (contenedorCalculadora != null) {
                if (calculadoraVisible) {
                    contenedorCalculadora.setVisibility(View.GONE);
                    btn.setText("Mostrar Calculadora");
                } else {
                    contenedorCalculadora.setVisibility(View.VISIBLE);
                    btn.setText("Ocultar Calculadora");
                }
                calculadoraVisible = !calculadoraVisible;
            }
        });

        return view;
    }
}