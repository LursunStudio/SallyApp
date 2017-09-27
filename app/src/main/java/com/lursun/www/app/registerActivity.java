package com.lursun.www.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;

public class registerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void registerEvent(View view){
        String name=((EditText)findViewById(R.id.name)).getText().toString();
        String account=((EditText)findViewById(R.id.account)).getText().toString();
        String passwd=((EditText)findViewById(R.id.passwd)).getText().toString();
        String passwd2=((EditText)findViewById(R.id.passwd2)).getText().toString();
        if(!name.equals("")&& !account.equals("") &&passwd.equals(passwd2)&&!passwd.equals("")){
            HttpURLConnection conn = Share.getConn( String.format("/createAccount?name=%s&account=%s&passwd=%s" ,name,account,passwd)  );
            String result=Share.getBody(conn);
            if(result.equals("")){
                Toast.makeText(registerActivity.this,"網路問題",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(registerActivity.this,"Register:"+result,Toast.LENGTH_SHORT).show();
                SQLiteHelper.getDatabase(registerActivity.this);
                SQLiteHelper.regUser(name,account,passwd);
                Intent intent = new Intent();
                intent.setClass(registerActivity.this,leftActivity.class);
                startActivity(intent);
                this.finish();
            }
        }else if(name.equals("") || account.equals("") || passwd.equals("")){
            Toast.makeText(registerActivity.this,"訊息不完整",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(registerActivity.this,"密碼不一樣",Toast.LENGTH_SHORT).show();
        }


    }

}
