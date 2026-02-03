package com.example.practica5;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.practica5.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        tabLayout = binding.tabLayout;
        viewPager = binding.viewPager;

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        binding.fab.setOnClickListener(view -> {

            FragmentOne fragment = (FragmentOne)
                    getSupportFragmentManager().findFragmentByTag(
                            "android:switcher:" + binding.viewPager.getId() + ":0"
                    );

            if (fragment != null) {
                fragment.limpiarFormulario();
            }

            Snackbar.make(view, "Formulario limpiado", Snackbar.LENGTH_SHORT).show();
        });
    }

    public void abrirAgendaInterna() {

        binding.viewPager.setVisibility(View.GONE);
        binding.tabLayout.setVisibility(View.GONE);

        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);

        Fragment fragmentAgenda = new FragmentAgenda();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragmentAgenda)
                .addToBackStack(null)
                .commit();
    }
}