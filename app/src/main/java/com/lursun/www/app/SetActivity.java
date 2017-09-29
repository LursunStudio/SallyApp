package com.lursun.www.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_contract);
        SQLiteDatabase db=SQLiteHelper.getDatabase(SetActivity.this);
        Cursor c=SQLiteHelper.getUser();
        c.moveToFirst();
        String name=c.getString(1);
        ((EditText)findViewById(R.id.contracter)).setText(name);
        c.close();
        db.close();
        Button readybtn=(Button)findViewById(R.id.readybtn);
        readybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toReady(v);
            }
        });
    }
    public void toReady(View view){
        int last_weight =Integer.parseInt(((EditText)findViewById(R.id.last_weight)).getText().toString());
        int target_weight =Integer.parseInt(((EditText)findViewById(R.id.target_weight)).getText().toString());
        int point =Integer.parseInt(((EditText)findViewById(R.id.point)).getText().toString());
        int day =Integer.parseInt(((EditText)findViewById(R.id.day)).getText().toString());
        String body=((EditText)findViewById(R.id.body)).getText().toString();

        SQLiteDatabase db=SQLiteHelper.getDatabase(SetActivity.this);
        SQLiteHelper.createContract(last_weight,target_weight,point,day,body);
        db.close();


        Intent intent = new Intent();
        intent.setClass(SetActivity.this,SetokActivity.class);
        startActivity(intent);
    }
    public void toCancel(View view){
        new AlertDialog.Builder(SetActivity.this)
                .setTitle(R.string.lunch_time)
                .setMessage(R.string.want_to_eat)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.gogo, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(SetActivity.this,LeftActivity.class);
                        SetActivity.this.startActivity(intent);
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
