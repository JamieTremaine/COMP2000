package com.example.geocache;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.location.LocationEngineProvider;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.maps.extension.observable.model.RenderMode;

import java.util.List;

public class MapFragment extends Fragment implements PermissionsListener {

    private MapView mView;
    private PermissionsManager permissionsManager;

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

                    LocationEngine locationEngine = LocationEngineProvider.getBestLocationEngine(getContext());

                    @Override
                    public void onStyleLoaded(@NonNull Style style) {
                        GetLocation(mapboxMap,style);
                        }

                });
            }
        });

        return view;
    }


    public void GetLocation(@NonNull MapboxMap mapboxMap, @NonNull Style style){

        permissionsManager = new PermissionsManager(this);
        permissionsManager.requestLocationPermissions(getActivity());
            LocationComponent locationComponent = mapboxMap.getLocationComponent();
            locationComponent.activateLocationComponent(
                    LocationComponentActivationOptions.builder(getContext(), style).build()
            );

            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            locationComponent.setLocationComponentEnabled(true);



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

    @Override
    public void onExplanationNeeded(List<String> list) {

    }



    @Override
    public void onPermissionResult(boolean b) {

    }
}