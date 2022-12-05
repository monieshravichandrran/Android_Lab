package com.example.locationtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.os.Bundle;
import android.location.*;

public class MainActivity extends AppCompatActivity {

    Button submit;
    TextView lat, lng;
    LocationManager lms;
    LocationListener lis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.button);
        lat = findViewById(R.id.lat);
        lng = findViewById(R.id.lng);
        lms = (LocationManager) getSystemService(LOCATION_SERVICE);
        lis = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                lat.setText("Latitude: " + Double.toString(location.getLatitude()));
                lng.setText("Longitude: " + Double.toString(location.getLongitude()));
                Log.d("LOCATION:", Double.toString(location.getLatitude()) + Double.toString(location.getLongitude()));
            }
        };
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            submit.setOnClickListener(view -> {
                lms.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lis);
            });
        }
    }
}