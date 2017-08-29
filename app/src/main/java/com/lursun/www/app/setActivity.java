package com.lursun.www.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class setActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_contract);
    }
    public void toReady(View view){
        Intent intent = new Intent();
        intent.setClass(setActivity.this,setokActivity.class);
        startActivity(intent);
    }
    public void toCancel(View view){
        new AlertDialog.Builder(setActivity.this)
                .setTitle(R.string.lunch_time)
                .setMessage(R.string.want_to_eat)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.gogo, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(setActivity.this,leftActivity.class);
                        setActivity.this.startActivity(intent);
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
