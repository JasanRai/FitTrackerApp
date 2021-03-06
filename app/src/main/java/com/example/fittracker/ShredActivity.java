package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ShredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shred);
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
            Intent intent = new Intent(ShredActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.program)
        {
            Intent intent = new Intent(ShredActivity.this, ProgramActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.buildyourown)
        {
            Intent intent = new Intent(ShredActivity.this, BuildYourOwnActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }
}