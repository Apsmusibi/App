package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Parent4SuccessActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent4_success);
    }

    public void onParent4MapClick(View view)
    {
        Intent map= new Intent(this, MapsActivity1.class);
        startActivity(map);
    }
}