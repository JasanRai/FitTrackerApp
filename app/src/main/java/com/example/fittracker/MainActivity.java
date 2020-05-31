package com.example.fittracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Button proceedButton;

    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toogle;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navi_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer = findViewById(R.id.drawer);
        toogle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open, R.string.close);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        drawerLayout.addDrawerListener(toogle);
        toogle.setDrawerIndicatorEnabled(true);
        toogle.syncState();

      /*  proceedButton = findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivityIntent = new Intent(v.getContext(), SecondActivity.class);

                startActivity(secondActivityIntent);
            }*/
        /*});*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       switch (menuItem.getItemId())
       {
           case R.id.home:
               drawerLayout.closeDrawer(GravityCompat.START);
               break;
           case R.id.program:
               drawerLayout.closeDrawer(GravityCompat.START);
               break;
           case R.id.buildyourown:
               drawerLayout.closeDrawer(GravityCompat.START);
               break;
           case R.id.info:
               drawerLayout.closeDrawer(GravityCompat.START);
               break;

       }
        return false;
    }
}
