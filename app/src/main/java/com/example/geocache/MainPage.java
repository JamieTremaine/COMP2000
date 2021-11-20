package com.example.geocache;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;


import com.google.android.material.appbar.AppBarLayout;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;


public class MainPage extends AppCompatActivity{

    private MapView mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* Mapbox.getInstance(this, getString(R.string.mapbox_access_token));*/
        setContentView(R.layout.activity_main_page);

      /*  mView = (MapView) findViewById(R.id.mapView);
        mView.onCreate(savedInstanceState);

        mView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {
                    }

                });
            }
        });*/

    }

    /*@Override
    public void onStart(){
        super.onStart();
        mView.onStart();
    }

    @Override
    public void onResume(){
        super.onResume();
        mView.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        mView.onPause();
    }

    @Override
    public void onStop(){
        super.onStop();
        mView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        mView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory(){
        super.onLowMemory();
        mView.onLowMemory();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mView.onDestroy();
    }
     */



    public void onMenuClick(View view){
        DrawerLayout layout = findViewById(R.id.main_layout);
        layout.open();
    }
}