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

public class Parent3ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parent3_contact);
    }




    public void onCallMacharia(View view) {
        String m = "0987654321";
        Intent mbug = new Intent(Intent.ACTION_CALL);
        mbug.setData(Uri.parse("tel:" + m));
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
        startActivity(mbug);
    }





    public void onSMSMacharia(View view)
    {
        Intent mach = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","0987654321", null));
        mach.putExtra("sms_body","Hello");
        startActivity(mach);
    }


}


