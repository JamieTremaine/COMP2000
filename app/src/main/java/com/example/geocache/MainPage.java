package com.example.geocache;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


import com.google.android.material.navigation.NavigationView;
import com.mapbox.mapboxsdk.maps.MapView;

import java.lang.reflect.Array;


public class MainPage extends AppCompatActivity{

    private MapView mView;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private SearchView sView;
    private ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        drawerLayout = findViewById(R.id.main_layout);
        navigationView = findViewById(R.id.main_nav_view);
        toolbar = findViewById(R.id.main_toolbar);
        sView = findViewById(R.id.main_search);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_open,R.string.navigation_close);

        drawerLayout.addDrawerListener(toggle);



        toggle.syncState();




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                NavigationOptions(item);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        sView.setOnSearchClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ShowSearchFragment();
            }
        });
        sView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                OpenMapFragment();
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        sView.setVisibility(View.VISIBLE);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }



    public void onMenuClick(View view) {
        DrawerLayout layout = findViewById(R.id.main_layout);
        layout.open();
    }

    private void ShowSearchFragment() {

        Fragment fragment = new SearchList();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }



    private void NavigationOptions(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.main_menu_map:
                OpenMapFragment();
                break;
            case R.id.main_menu_caches:
                OpenCachesFragment();
                break;
            case R.id.main_menu_settings:
                OpenSettingFragment();
                break;
            case R.id.main_menu_logout:
                Logout();
                break;
        }
    }

    private void OpenMapFragment(){

        sView.setVisibility(View.VISIBLE);
        Fragment fragment = new MapFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();
    }

    private void OpenCachesFragment(){

        sView.setVisibility(View.GONE);

        Fragment fragment = new CachesFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();

    }

    private void OpenSettingFragment(){

        sView.setVisibility(View.GONE);

        Fragment fragment = new SettingsFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.toString());
        fragmentTransaction.commit();

    }

    private void Logout(){

        startActivity(new Intent(this, Homepage.class));
        finish();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(getBaseContext(), "toast", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }







}