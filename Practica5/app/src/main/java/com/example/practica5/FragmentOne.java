package com.example.practica5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

public class FragmentOne extends Fragment {

    TextInputLayout textInputLayout;
    Button btnValidar;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        textInputLayout = view.findViewById(R.id.textInputLayout);
        btnValidar = view.findViewById(R.id.btnValidar);

        btnValidar.setOnClickListener(v -> {
            String texto = textInputLayout.getEditText().getText().toString();

            if (texto.isEmpty()) {
                textInputLayout.setError("Campo obligatorio");
            } else {
                textInputLayout.setError(null);
                Toast.makeText(getActivity(), "Correcto", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void limpiarFormulario() {
        if (textInputLayout != null && textInputLayout.getEditText() != null) {
            textInputLayout.getEditText().setText("");
            textInputLayout.setError(null);
        }
    }
}