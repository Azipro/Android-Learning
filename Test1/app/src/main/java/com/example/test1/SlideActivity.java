package com.example.test1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{

    ImageView imageView;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = findViewById(R.id.name);
        imageView = findViewById(R.id.image1);
        //imageView1.setOnClickListener(this);
        //imageView1


        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(this);

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView =  findViewById(R.id.nav_view);
        View drawerView =navigationView.inflateHeaderView(R.layout.nav_header_slide);
        ImageButton imageView1 = drawerView.findViewById(R.id.imageView);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("阿吱吱吱吱");
                imageView.setImageDrawable(getResources().getDrawable(R.mipmap.l2));

            }
        });


        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.slide, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            name.setText("1111111111");
            imageView.setImageDrawable(getResources().getDrawable(R.mipmap.banji));
        } else if (id == R.id.nav_gallery) {
            name.setText("2222222222");
            imageView.setImageDrawable(getResources().getDrawable(R.mipmap.l2));
        } else if (id == R.id.nav_slideshow) {
            name.setText("3333333333");
            imageView.setImageDrawable(getResources().getDrawable(R.mipmap.l3));
        } else if (id == R.id.nav_manage) {
            name.setText("4444444444");
            imageView.setImageDrawable(getResources().getDrawable(R.mipmap.l4));
        } else if (id == R.id.nav_ywl){
            name.setText("5555555555");
            imageView.setImageDrawable(getResources().getDrawable(R.mipmap.l5));
        }else if (id == R.id.imageView){
            name.setText("6666666666");
            imageView.setImageDrawable(getResources().getDrawable(R.mipmap.l5));
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView:
                name.setText("2222222222");
                imageView.setImageDrawable(getResources().getDrawable(R.mipmap.l1));
                break;
            default:
                break;
        }

    }
}
