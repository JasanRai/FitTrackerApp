package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class ProgramActivity extends  AppCompatActivity {

ImageButton shredButton, cardioButton, caliButton, bulkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        shredButton = findViewById(R.id.shredButton);
        cardioButton = findViewById(R.id.cardioButton);
        caliButton = findViewById(R.id.caliButton);
        bulkButton = findViewById(R.id.bulkButton);


        shredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shredActivityIntent = new Intent(v.getContext(), ShredActivity.class);
                startActivity(shredActivityIntent);

            }
        });
        cardioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardioActivityIntent = new Intent(v.getContext(), CardioActivity.class);
                startActivity(cardioActivityIntent);

            }
        });
        caliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent caliActivityIntent = new Intent(v.getContext(), CaliActivity.class);
                startActivity(caliActivityIntent);

            }
        });

        bulkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bulkActivityIntent = new Intent(v.getContext(),  BulkActivity.class);
                startActivity(bulkActivityIntent);

            }
        });
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
            Intent intent = new Intent(ProgramActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.program)
        {
            Intent intent = new Intent(ProgramActivity.this, ProgramActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.buildyourown)
        {
            Intent intent = new Intent(ProgramActivity.this, BuildYourOwnActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

}
