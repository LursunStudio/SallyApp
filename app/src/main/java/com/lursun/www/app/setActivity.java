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
    private Button normalDialog;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_contract);
         initView();
        button2= (Button)findViewById(R.id.button2);

        button2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(setActivity.this,setokActivity.class);
                startActivity(intent);
            }
        });
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

    private void normalDialogEvent(){
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
