package com.usu.drawernavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, HomeFragment.class, null)
                    .setReorderingAllowed(true)
                    .commit();
        }

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView drawer = findViewById(R.id.navigation_view);
        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.open();
        });

        drawer.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);
            drawerLayout.close();
            if(menuItem.getItemId() == R.id.home_item) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
            if(menuItem.getItemId() == R.id.profile_item) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
            if(menuItem.getItemId() == R.id.settings_item) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, SettingsFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
            return true;
        });


    }
}