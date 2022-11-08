package com.example.javalabandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddStudentsGropsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students_grops);
    }

    public void onGrpAddClick(View view){
        EditText number = (EditText) findViewById(R.id.txtGrpNumber2);
        EditText faculty = (EditText) findViewById(R.id.facultyEdit2);
        Groups.addGroup(
                new Groups(number.getText().toString(),faculty.getText().toString(),0,false,false)
        );
        NavUtils.navigateUpFromSameTask(this);
    }
}