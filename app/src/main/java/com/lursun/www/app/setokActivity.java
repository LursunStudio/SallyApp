package com.lursun.www.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class setokActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setok);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SQLiteDatabase db=SQLiteHelper.getDatabase(setokActivity.this);
        Cursor c = db.rawQuery("Select * From Contracttable Where 1=1 Order By id DESC Limit 1", null);
        c.moveToFirst();
        ((TextView) findViewById(R.id.id)).setText( "編號："+String.valueOf(c.getInt(0)));
        ((TextView) findViewById(R.id.last_weight)).setText( "目前體重："+String.valueOf(c.getInt(1)));
        ((TextView) findViewById(R.id.target_weight)).setText( "目標體重："+String.valueOf(c.getInt(2)));
        ((TextView) findViewById(R.id.day)).setText( String.valueOf(c.getInt(4))+"天");
        ((TextView) findViewById(R.id.body)).setText( c.getString(5));
        c.close();
        c=SQLiteHelper.getUser();
        c.moveToFirst();
        ((TextView) findViewById(R.id.contracter)).setText( c.getString(1) );
        c.close();
    }
    public void toCancelSetok(View view){
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
    public void toSubmitSetok(View view){
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
