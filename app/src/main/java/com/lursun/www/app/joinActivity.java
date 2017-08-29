package com.lursun.www.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class joinActivity extends AppCompatActivity {
    private Button normalDialog;
    private Button normalDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        initView2();
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
    private void initView() {
        normalDialog = (Button) findViewById(R.id.button);
        normalDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalDialogEvent();
            }
        });
    }
    private void initView2() {
        normalDialog2 = (Button) findViewById(R.id.button2);
        normalDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalDialogEvent2();
            }
        });
    }
    private void normalDialogEvent(){
        new AlertDialog.Builder(joinActivity.this)
                .setTitle(R.string.lunch_time)
                .setMessage(R.string.cancel)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.cancel2, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(joinActivity.this,LookActivity.class);
                        joinActivity.this.startActivity(intent);
                    }
                }).show();
    }
    private void normalDialogEvent2(){
        new AlertDialog.Builder(joinActivity.this)
                .setTitle(R.string.lunch_time)
                .setMessage(R.string.joinok)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.settok, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(joinActivity.this,leftActivity.class);
                        joinActivity.this.startActivity(intent);
                    }
                }).show();
    }
}
