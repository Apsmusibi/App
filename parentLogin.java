package com.example.apollomusibi.ballobustracking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;


public class parentLogin extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.Login);
        login.setOnClickListener(this);


    }

    @Override
    public void processFinish(String result) {
        if(result.equals("success"))
        {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ParentSuccessActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onClick(View p)
    {

        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("username", username.getText().toString());
        postData.put("password", password.getText().toString() );

        PostResponseAsyncTask task= new PostResponseAsyncTask(this, postData);
        task.execute("http://10.51.13.113/Ballobus/conn/bustracking/parent_login.php");
    }

}