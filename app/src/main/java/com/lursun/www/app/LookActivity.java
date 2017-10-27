package com.lursun.www.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class LookActivity extends AppCompatActivity {
    private List<String> lunch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_contract);
        initData();

    }
    public void toJoin(View view){
        Intent intent = new Intent();
        intent.setClass(LookActivity.this,JoinActivity.class);
        startActivity(intent);
    }
    public void showListDialog(View view){
        new AlertDialog.Builder(LookActivity.this)
            .setItems(lunch.toArray(new String[lunch.size()]), new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String name = lunch.get(which);
                }
            }).show();
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
