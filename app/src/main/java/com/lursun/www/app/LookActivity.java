package com.lursun.www.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class LookActivity extends AppCompatActivity {
    private Button button01;
    private Button listDialog;
    private List<String> lunch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_contract);
        initData();
        initView();
        button01= (Button)findViewById(R.id.button);

        button01.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LookActivity.this,joinActivity.class);
                startActivity(intent);
            }
        });

    }
    private void initView() {
        listDialog = (Button) findViewById(R.id.button2);
        listDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listDialog();
            }
        });
    }
    private void listDialog(){
        new AlertDialog.Builder(LookActivity.this)
                .setItems(lunch.toArray(new String[lunch.size()]), new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = lunch.get(which);

                    }
                })
                .show();
    }
    private void initData() {
        lunch = new ArrayList<>();
        lunch.add(getString(R.string.talk));
        lunch.add(getString(R.string.talk2));
        lunch.add(getString(R.string.talk3));
        lunch.add(getString(R.string.talk4));
        lunch.add(getString(R.string.talk5));

    }
}
