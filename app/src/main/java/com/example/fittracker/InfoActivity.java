package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        int id = menuItem.getItemId();
        if(id == R.id.home)
        {
            Intent intent = new Intent(InfoActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.program)
        {
            Intent intent = new Intent(InfoActivity.this, ProgramActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.buildyourown)
        {
            Intent intent = new Intent(InfoActivity.this, CustomBuildActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.info)
        {
            Intent intent = new Intent(InfoActivity.this, InfoActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
