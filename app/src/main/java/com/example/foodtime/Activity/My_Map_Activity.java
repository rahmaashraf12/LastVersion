package com.example.foodtime.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentActivity;

import com.example.foodtime.R;
import com.example.foodtime.databinding.ActivityMyMapBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class My_Map_Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMyMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void bottomNavigation() {
        LinearLayout homeBtn =findViewById(R.id.homeBtn_Card);
        LinearLayout cartBtn = findViewById(R.id.CardBtn_again);
        LinearLayout map = findViewById(R.id.Google_Map);
        LinearLayout setteings = findViewById(R.id.homebtn_setting);

        homeBtn.setOnClickListener((v -> {
            startActivity(new Intent(My_Map_Activity.this,MainActivity.class));
        }));

        cartBtn.setOnClickListener((v -> {
            startActivity(new Intent(My_Map_Activity.this,CartActivity.class));
        }));

        map.setOnClickListener((v -> {
            startActivity(new Intent(My_Map_Activity.this,My_Map_Activity.class));
        }));

        setteings.setOnClickListener((v -> {
            startActivity(new Intent(My_Map_Activity.this,LogoutActivity.class));
        }));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}