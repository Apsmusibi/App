package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Apollo Musibi on 3/1/2017.
 */


public class welcomeActivity extends AppCompatActivity
{
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
    }


    public void onAdminClick(View v)
    {
        Intent admin= new Intent(this, MainActivity.class );
        startActivity(admin);
    }

    public void onShowLocation(View d)
    {
        Intent drive= new Intent(this, driverLogin.class );
        startActivity(drive);
    }

    public void onParentClick(View p)
    {
        Intent par= new Intent(this, parentActivity.class );
        startActivity(par);
    }
}
