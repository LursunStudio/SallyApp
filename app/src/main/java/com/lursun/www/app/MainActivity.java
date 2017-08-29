package com.lursun.www.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void toLogin(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,leftActivity.class);
        startActivity(intent);
    }
    public void toReg(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,registeredActivity.class);
        startActivity(intent);
    }


}
