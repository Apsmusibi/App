package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Apollo Musibi on 3/12/2017.
 */

public class parentActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent);
    }


    public void onJaneClick(View view)
    {
        Intent jan= new Intent(this, parent1login.class );
        startActivity(jan);
    }


    public void onJohnClick(View view)
    {
        Intent john= new Intent(this, parent2login.class );
        startActivity(john);
    }


    public void onAliceClick(View view)
    {
        Intent alice= new Intent(this, parent3login.class );
        startActivity(alice);
    }


    public void onJennClick(View view)
    {
        Intent jen= new Intent(this, parent4login.class );
        startActivity(jen);
    }


    public void onNoneClick(View view)
    {
        Intent non= new Intent(this, NoneActivity.class );
        startActivity(non);
    }
}
