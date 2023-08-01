package com.example.navdrawerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
FrameLayout container;
ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        container = (FrameLayout) findViewById(R.id.container);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(MainActivity.this, "Home clicked...", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.contact) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new ContactFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(MainActivity.this, "Contact clicked...", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.about) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(MainActivity.this, "About clicked...", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.logout) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(MainActivity.this, "Logout clicked...", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.share) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(MainActivity.this, "Share clicked...", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.rateus) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(MainActivity.this, "Rate us clicked...", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}