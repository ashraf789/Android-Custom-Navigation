package com.ashraf.navigrationpractice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.support.design.widget.Snackbar.LENGTH_LONG;
import static android.support.design.widget.Snackbar.make;

/*
* developer: Lazy Coder
* email: syedashrafullah15@gmail
* Date 10.04.17
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private RelativeLayout navRl,navGuideRl,navAboutUrlRl,navSeoulVpnUrlRl;
    private LinearLayout navRightUkLayout,navRightFrLayout,navRightUsLayout;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton menuRight = (ImageButton) findViewById(R.id.navbar_right);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        menuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(GravityCompat.END)) {
                    drawer.closeDrawer(GravityCompat.END);
                } else {
                    drawer.openDrawer(GravityCompat.END);
                }
            }
        });

        initializeAll();

    }

    private void initializeAll() {


        navRightUkLayout = (LinearLayout) findViewById(R.id.navRightUkLayout);
        navRightFrLayout = (LinearLayout) findViewById(R.id.navRightFrLayout);
        navRightUsLayout = (LinearLayout) findViewById(R.id.navRightUsLayout);

        navRightUkLayout.setOnClickListener(this);
        navRightFrLayout.setOnClickListener(this);
        navRightUsLayout.setOnClickListener(this);


        navGuideRl = (RelativeLayout) findViewById(R.id.navGuideRl);
        navAboutUrlRl = (RelativeLayout) findViewById(R.id.navAboutUrlRl);
        navSeoulVpnUrlRl = (RelativeLayout) findViewById(R.id.navUrlRl);
        navRl = (RelativeLayout) findViewById(R.id.navRl);

        navGuideRl.setOnClickListener(this);
        navAboutUrlRl.setOnClickListener(this);
        navSeoulVpnUrlRl.setOnClickListener(this);
        navRl.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            //if you want to use fragment you can use that on each option i just use a toast message
            case R.id.navRl:
                showMessage("Navigation Home");
                closeDrawer();
                break;
            case R.id.navGuideRl:
                showMessage("Navigation Guide");
                closeDrawer();
                break;
            case R.id.navAboutUrlRl:
                showMessage("Navigation About");
                closeDrawer();

                break;
            case R.id.navUrlRl:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lazycoder.6te.net/"));
                startActivity(browserIntent);
                break;
            case R.id.navRightUkLayout:
                showMessage("Navigation Location UK");
                closeDrawer();

                break;
            case R.id.navRightFrLayout:
                showMessage("Navigation Location FR");
                closeDrawer();

                break;
            case R.id.navRightUsLayout:
                showMessage("Navigation Location US");
                closeDrawer();
                break;


        }
    }
    public void closeDrawer(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if (drawer.isDrawerOpen(GravityCompat.END)){
            drawer.closeDrawer(GravityCompat.END);
        }
    }

    public void showMessage(String message){
        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
    }
}
