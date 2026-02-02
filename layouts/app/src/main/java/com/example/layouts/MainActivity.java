package com.example.layouts;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new fragment_pestana1(), "Pestaña 1");
        adapter.addFragment(new fragment_pestana2(), "Pestaña 2");
        adapter.addFragment(new fragment_pestana3(), "Pestaña 3");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // 🔹 Listener de selección de pestañas
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Toast.makeText(
                        MainActivity.this,
                        "Pestaña " + (position + 1) + " seleccionada",
                        Toast.LENGTH_SHORT
                ).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Acción cuando una pestaña se deselecciona (opcional)
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Acción cuando una pestaña ya seleccionada se vuelve a seleccionar
            }
        });
    }
}
