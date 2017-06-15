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
import android.widget.Toast;

public class setokActivity extends AppCompatActivity {
    private Button normalDialog;
    private Button normalDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setok);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        initView2();
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
        new AlertDialog.Builder(setokActivity.this)
                .setTitle(R.string.lunch_time)
                .setMessage(R.string.want_to_eat)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.gogo, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(setokActivity.this,leftActivity.class);
                        setokActivity.this.startActivity(intent);
                    }
                })

                .setNeutralButton(R.string.not_hungry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.diet, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
    private void normalDialogEvent2(){
        new AlertDialog.Builder(setokActivity.this)
                .setTitle(R.string.lunch_time)
                .setMessage(R.string.set)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.setok, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(setokActivity.this,leftActivity.class);
                        setokActivity.this.startActivity(intent);
                    }
                })

                .setNeutralButton(R.string.not_hungry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.diet, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}
