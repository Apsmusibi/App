package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SuccessActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
    }
    public void onMapClick(View view)
    {
        Intent map= new Intent(this, MapsActivity2.class);
        startActivity(map);
    }

}