package com.lursun.www.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio:
                if (checked)
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    break;
        }
    }

    public void cancle(View view){
        new AlertDialog.Builder(JoinActivity.this)
            .setTitle(R.string.lunch_time)
            .setMessage(R.string.cancel)
            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), R.string.cancel2, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(JoinActivity.this,LookActivity.class);
                    JoinActivity.this.startActivity(intent);
                }
            }).show();
    }
    public void submit(View view){
        new AlertDialog.Builder(JoinActivity.this)
            .setTitle(R.string.lunch_time)
            .setMessage(R.string.joinok)
            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), R.string.settok, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(JoinActivity.this,LeftActivity.class);
                    JoinActivity.this.startActivity(intent);
                }
            }).show();
    }
}
