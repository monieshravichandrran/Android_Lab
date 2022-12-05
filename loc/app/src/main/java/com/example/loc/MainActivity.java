package com.example.loc;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    LocationManager lmg;
    LocationListener lis;
    Button submit;
    TextView lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lat = (TextView) (findViewById(R.id.lat));
        lng = (TextView) (findViewById(R.id.lng));
        submit = (Button) (findViewById(R.id.submit));
        lmg = (LocationManager)(getSystemService(LOCATION_SERVICE));
        lis = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                lat.setText("Lattitude: " + Double.toString(location.getLatitude()));
                lng.setText("Longitude: " + Double.toString(location.getLongitude()));
            }
        };

        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);

        submit.setOnClickListener(view -> {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Log.d("CHECK: ", "REACH");
                lmg.requestLocationUpdates("gps", 5000, 0, lis);
            }
        });
    }
}