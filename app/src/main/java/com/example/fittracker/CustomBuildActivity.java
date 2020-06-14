package com.example.fittracker;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class CustomBuildActivity extends  AppCompatActivity {

    Button add;
    ListView listProgram;
    Button addProgramButton;
    Database database = new Database(CustomBuildActivity.this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_build);

        add = findViewById(R.id.addBtn);
        listProgram = findViewById(R.id.programList);
        addProgramButton = findViewById(R.id.addProgramBtn);



        Database database = new Database(CustomBuildActivity.this);
        List<Program> allProgram = database.getAllProgram();
        ArrayAdapter programArrayAdapter = new ArrayAdapter<Program>(CustomBuildActivity.this, android.R.layout.simple_list_item_1, allProgram);
        listProgram.setAdapter(programArrayAdapter);





        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buildActivityIntent = new Intent(v.getContext(), BuildYourOwnActivity.class);

                startActivity(buildActivityIntent);
            }

            });

     /*  *//* addProgramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Database database = new Database(CustomBuildActivity.this);
                List<Program> allProgram = database.getAllProgram();
                ArrayAdapter programArrayAdapter = new ArrayAdapter<Program>(CustomBuildActivity.this, android.R.layout.simple_list_item_1, allProgram);
                text.setAdapter(programArrayAdapter);
            }*//*

        });*/
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
            Intent intent = new Intent(CustomBuildActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.program)
        {
            Intent intent = new Intent(CustomBuildActivity.this, ProgramActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.buildyourown)
        {
            Intent intent = new Intent(CustomBuildActivity.this, CustomBuildActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.info)
        {
            Intent intent = new Intent(CustomBuildActivity.this, InfoActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
