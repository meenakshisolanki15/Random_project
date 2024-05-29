package com.example.random_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class User_Choice extends AppCompatActivity {


    private Button stdbtn;
    private Button teabtn;
    private Button emgbtn;
    private Button useful;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);
        stdbtn = findViewById(R.id.stdbtn);
        stdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Choice.this, Student_Login.class );
                startActivity(intent);
            }
        });

        teabtn = findViewById(R.id.teabtn);
        teabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Choice.this, Teacher_Login.class );
                startActivity(intent);
            }
        });

        emgbtn = findViewById(R.id.emgbtn);
        emgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Choice.this, teacher_attendence.class );
                startActivity(intent);
            }
        });

        useful = findViewById(R.id.useful);
        useful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User_Choice.this, MainActivity2.class );
                startActivity(intent);
            }
        });
    }
}