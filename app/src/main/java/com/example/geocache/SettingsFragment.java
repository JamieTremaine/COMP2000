package com.example.geocache;

import android.Manifest;
import android.app.ActionBar;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;

import java.util.List;


public class SettingsFragment extends Fragment implements PermissionsListener {

    private Switch switchButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View fragment = inflater.inflate(R.layout.fragment_settings, container, false);
        switchButton = fragment.findViewById(R.id.settings_location);
        switchButton.setChecked(true);


   int permissionLocation = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionLocation != PackageManager.PERMISSION_GRANTED){

            switchButton.setChecked(true);
        }
        else {
            switchButton.setChecked(false);
        }


        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePermission();
            }
        });

        return fragment;
    }


    private void ChangePermission(){

        if (switchButton.isChecked()){
            return;
        }
        else{
            PermissionsManager permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(getActivity());
        }
    }


    @Override
    public void onExplanationNeeded(List<String> list) {
    }

    @Override
    public void onPermissionResult(boolean b) {
        if (b = true){
            switchButton.setChecked(true);
        }
    }
}