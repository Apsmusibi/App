package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Parent3SuccessActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent3_success);
    }

    public void onParent3MapClick(View view)
    {
        Intent map= new Intent(this, MapsActivity5.class);
        startActivity(map);
    }
}