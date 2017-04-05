package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.IOException;
import java.util.List;

import static com.example.apollomusibi.ballobustracking.R.id.map;

public class MapsActivity1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps3);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }

    public void onSearch(View view) {
        EditText location_tf = (EditText) findViewById(R.id.TFadress);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);

            try {

                addressList = geocoder.getFromLocationName(location, 3);


            } catch (IOException e) {

            }
            ;
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }

    public void onNormalMap(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void onSatelliteMap(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void onHybridMap(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void onLogOutClick(View view) {
        Intent log = new Intent(this, welcomeActivity.class);
        startActivity(log);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        LatLng dago = new LatLng(-1.302061, 36.687210);
        LatLng sch= new LatLng(-1.296421, 36.798415);

        mMap.addMarker(new MarkerOptions().position(sch).title("School")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.school)));

        mMap.addMarker(new MarkerOptions().position(dago).title("Bus 1")
                .snippet("Reg:KBC 123B" + "," +
                        " Driver: Macharia Mbugua" + "," + "Location: Dagoretti Road")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.bus1)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(dago));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dago, 15));


        mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 200, null);

        mMap.addPolyline(new PolylineOptions().add(
               dago,
                new LatLng(-1.296421, 36.798415)
                )
                        .width(10)
                        .color(Color.RED)

        );



        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }
        mMap.setMyLocationEnabled(true);

    }

    public void onCallDriver(View view) {
        Intent con= new Intent(this, Parent3ContactActivity.class);
        startActivity(con);
    }

    public void onCallSchool(View view) {
        String number = "254711502614";
        Intent sch = new Intent(Intent.ACTION_CALL);
        sch.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(sch);

    }
}
