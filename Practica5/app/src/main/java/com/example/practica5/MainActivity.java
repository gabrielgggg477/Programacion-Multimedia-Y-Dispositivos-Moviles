package com.example.practica5;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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

        // Iconos en los Tabs (extra)


        // FAB con Snackbar
        binding.fab.setOnClickListener(view -> {
            Snackbar.make(view, "Acción realizada", Snackbar.LENGTH_LONG)
                    .setAction("OK", v -> {
                        Toast.makeText(MainActivity.this, "Confirmado", Toast.LENGTH_SHORT).show();
                    })
                    .show();
        });
    }
}