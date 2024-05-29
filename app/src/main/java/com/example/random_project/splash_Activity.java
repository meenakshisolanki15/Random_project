package com.example.random_project;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.random_project.User_Choice;

public class splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread() {
            public void run(){
                try {
                    sleep(2500);
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    Intent intent = new Intent(splash_Activity.this, User_Choice.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();
    }
}