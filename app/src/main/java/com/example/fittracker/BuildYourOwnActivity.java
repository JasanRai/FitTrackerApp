package com.example.fittracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class BuildYourOwnActivity extends AppCompatActivity {

    CheckBox barbellCurlCB, crunchesCB, oneLegCB, frontSquatCB, bentOverCB, sumoCB;
    Button addProgram;
    EditText enterName;
    ListView listProgram;

    ArrayAdapter programArrayAdapter;
    Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buildyourown);

        addProgram = findViewById(R.id.addProgramBtn);

        barbellCurlCB = findViewById(R.id.barbellCurlCB);
        crunchesCB = findViewById(R.id.crunchesCB);
        oneLegCB = findViewById(R.id.oneLegCB);
        frontSquatCB = findViewById(R.id.frontSquatCB);
        bentOverCB = findViewById(R.id.bentOverCB);
        sumoCB = findViewById(R.id.sumoCB);
        enterName =findViewById(R.id.enterName);
        listProgram = findViewById(R.id.programList);

        database = new Database(BuildYourOwnActivity.this);
        ShowCustomProgramList(database);


        addProgram.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {



                String s = "";


                if(barbellCurlCB.isChecked())
                {
                    s += "\n Barbell Curl";
                }
                if(crunchesCB.isChecked())
                {
                    s += "\n Crunches";
                }
                if(oneLegCB.isChecked())
                {
                    s += "\n One Leg Dumbbell Squat";
                }
                if(frontSquatCB.isChecked())
                {
                    s += "\n Front Squat";
                }
                if(bentOverCB.isChecked())
                {
                    s += "\n BentOver Dumbbell Raise";
                }
                if(sumoCB.isChecked())
                {
                    s += "\n Sumo Deadlift";
                }
               /* customOutput.setText(s);*/
                Program program = new Program();
                    program.setProgramName(s);
                try{
                     program = new Program(enterName.getText().toString(), -1, s);
                    Toast.makeText(BuildYourOwnActivity.this, program.toString(), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e)
                {
                    Toast.makeText(BuildYourOwnActivity.this, "Error Creating Program", Toast.LENGTH_SHORT).show();
                     program = new Program("error", -1, "error");
                }


                database = new Database(BuildYourOwnActivity.this);


                ShowCustomProgramList(database);

                boolean success = database.addOne(program);

;



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
            Intent intent = new Intent(BuildYourOwnActivity.this, HomeActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.program)
        {
            Intent intent = new Intent(BuildYourOwnActivity.this, ProgramActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.buildyourown)
        {
            Intent intent = new Intent(BuildYourOwnActivity.this, BuildYourOwnActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    private void ShowCustomProgramList(Database databases) {

        programArrayAdapter = new ArrayAdapter<Program>(BuildYourOwnActivity.this, android.R.layout.simple_list_item_1, databases.getAllProgram());
        listProgram.setAdapter(programArrayAdapter);
    }
}