package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Apollo Musibi on 3/11/2017.
 */

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
    }




    public void onCallTest(View view) {
        String t = "8746523898";
        Intent tes = new Intent(Intent.ACTION_CALL);
        tes.setData(Uri.parse("tel:" + t));
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
        startActivity(tes);
    }




    public void onSMSTest(View view)
    {
        Intent joh = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","8746523898", null));
        joh.putExtra("sms_body","Hello");
        startActivity(joh);
    }
}


