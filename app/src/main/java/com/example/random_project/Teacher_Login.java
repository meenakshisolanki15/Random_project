package com.example.random_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.random_project.databinding.ActivityTeacherLoginBinding;

public class Teacher_Login extends AppCompatActivity {

    Button login;
    ActivityTeacherLoginBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeacherLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.loginEmail.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if(email.equals("")|| password.equals(""))
                    Toast.makeText(Teacher_Login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email,password);
                    if(checkCredentials == true){
                        Toast.makeText(Teacher_Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Select_teacher.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Teacher_Login.this, "Inavalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }) ;
        binding.signupRedirectText.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Teacher_Login.this, Teacher_Sign.class);
                startActivity(intent);
            }
        });

    }

}