package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ParentSuccessActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent_success);
    }

    public void onParentMapClick(View view)
    {
        Intent map= new Intent(this, MapsActivity3.class);
        startActivity(map);
    }
}