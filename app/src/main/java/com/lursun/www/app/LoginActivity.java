package com.lursun.www.app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db=SQLiteHelper.getDatabase(LoginActivity.this);
        Cursor c=SQLiteHelper.getUser();
        if (c.getCount()>0){
            c.close();
            db.close();
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this,LeftActivity.class);
            startActivity(intent);
            this.finish();
        }
    }
    public void toLogin(View view){
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this,LeftActivity.class);
        startActivity(intent);
        this.finish();
    }
    public void toReg(View view){
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
        this.finish();
    }


}
