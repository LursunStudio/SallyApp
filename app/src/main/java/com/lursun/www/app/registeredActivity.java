package com.lursun.www.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registeredActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void registeredEvent(View view){
        String name=((EditText)findViewById(R.id.name)).getText().toString();
        String account=((EditText)findViewById(R.id.account)).getText().toString();
        String passwd=((EditText)findViewById(R.id.passwd)).getText().toString();
        String passwd2=((EditText)findViewById(R.id.passwd2)).getText().toString();
        if(passwd.equals(passwd2)&&!passwd.equals("")){
            SQLiteHelper.getDatabase(registeredActivity.this);
            SQLiteHelper.regUser(name,account,passwd);
        }
        Intent intent = new Intent();
        intent.setClass(registeredActivity.this,leftActivity.class);
        startActivity(intent);
    }

}
