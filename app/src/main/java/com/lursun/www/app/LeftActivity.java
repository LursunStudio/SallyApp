package com.lursun.www.app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class LeftActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private Button button04;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LeftActivity.this,SetActivity.class);
                LeftActivity.this.startActivity(intent);
            }
        });
        button04= (Button)findViewById(R.id.button4);
        button04.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LeftActivity.this,LookActivity.class);
                startActivity(intent);
            }
        });
        LayoutInflater li=getLayoutInflater();
        SQLiteDatabase db=SQLiteHelper.getDatabase(LeftActivity.this);
        try {
            Cursor c = db.rawQuery("Select id,body From Contracttable", null);
            c.moveToFirst();
            do {
                c.getInt(0);
                c.getString(1);
                TableRow tr = ((TableRow) li.inflate(R.layout.temp, null));
                ((Button) tr.findViewById(R.id.button)).setText("NO." + String.valueOf(c.getInt(0)) + "\n" + c.getString(1));
                ((TableLayout) findViewById(R.id.listtable)).addView(tr);
            } while (c.moveToNext());
        }catch (Exception e){
            
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.left, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //工具列
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent(this,Accumulation.class);
            startActivity(intent);
            this.finish();
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this,Update.class);
            startActivity(intent);
            this.finish();
        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(this,About.class);
            startActivity(intent);
            this.finish();
        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(this,Setting.class);
            startActivity(intent);
            this.finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
