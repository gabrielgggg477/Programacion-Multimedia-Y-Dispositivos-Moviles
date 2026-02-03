package com.example.practica5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final int NUM_TABS = 3;

    public MyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOne(); // Tu formulario
            //case 1:
               // return new FragmentTwo(); // El fragment con botón para abrir agenda
            case 2:
                return new FragmentAgenda(); // La calculadora DIRECTAMENTE en un tab
            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "Formulario";
            case 1: return "Inicio";
            case 2: return "Calculadora"; // Nuevo tab para la calculadora
            default: return "Tab " + position;
        }
    }
}