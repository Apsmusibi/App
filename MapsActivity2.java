package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
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

import java.io.IOException;
import java.util.List;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void onSearch(View view){
        EditText location_tf=(EditText)findViewById(R.id.TFadress);
        String location=location_tf.getText().toString();
        List<Address> addressList= null;

        if (location !=null|| !location.equals("")){
            Geocoder geocoder= new Geocoder(this);

            try {

                addressList= geocoder.getFromLocationName(location, 3);



            } catch (IOException e) {

            };
            Address address= addressList.get(0);
            LatLng latLng= new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng ));
        }
    }
    public void onNormalMap(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
    public void onSatelliteMap(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
    public void onHybridMap(View view){
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
    public void onLogOutClick(View view)
    {
        Intent log= new Intent(this, welcomeActivity.class);
        startActivity(log);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Strathmore and move the camera
        LatLng dago = new LatLng(-1.302061, 36.687210);
        LatLng chiromo= new LatLng(-1.264839, 36.801880);
        LatLng rongai= new LatLng(-1.396916, 36.760292);
        LatLng msa= new LatLng(-1.318586, 36.836879);
        mMap.addMarker(new MarkerOptions().position(dago).title("Bus 1")
                .snippet("Reg:KBC 123B" +","+
                        " Driver: Macharia Mbugua" + "," + "Location: Dagoretti Road")
        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.bus1)));
        mMap.addMarker(new MarkerOptions().position(chiromo).title("Bus 2")
                .snippet("Reg:KBX 925X" +","+
                        " Driver: Jack Bauer" + "," + "Location: Chiromo Road")
        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.bus1)));
        mMap.addMarker(new MarkerOptions().position(rongai).title("Bus 3")
                .snippet("Reg:KBY 543P" +","+
                        " Driver: Johnny Test" + "," + "Location: Ongata Rongai")
        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.bus1)));
        mMap.addMarker(new MarkerOptions().position(msa).title("Bus 4")
                .snippet("Reg:KCA 345T" +","+
                        " Driver: James Mwangi" + "," + "Location: Mombasa Rd")
        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.bus1)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dago));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chiromo));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rongai));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(msa));
        //Move camera instantly to Strathmore with a zoom of 15
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dago, 15));
        //Move camera instantly to Uhuru Highway with a zoom of 15
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chiromo, 20));
        //zoom in, animating the camera
        //Move camera instantly to Strathmore with a zoom of 15
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rongai, 15));
        //Move camera instantly to Uhuru Highway with a zoom of 15
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(msa, 20));
        //zoom in, animating the camera
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 200, null);


        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }
        mMap.setMyLocationEnabled(true);

    }
}
