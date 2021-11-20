package com.example.geocache;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

public class MapFragment extends Fragment {

    private MapView mView;

    public MapFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Mapbox.getInstance(getContext(), getString(R.string.mapbox_access_token));

        View view = inflater.inflate(R.layout.fragment_map, container, false);

        mView = (MapView) view.findViewById(R.id.mapView);
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
        });

        return view;
    }

    @Override
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
    public void onPause() {
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
}