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
import com.example.random_project.databinding.ActivityMainBinding;
import com.example.random_project.databinding.ActivityStudentLoginBinding;

public class Student_Login extends AppCompatActivity {

    Button login;
    ActivityStudentLoginBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.loginEmail.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if(email.equals("")|| password.equals(""))
                    Toast.makeText(Student_Login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else
                {
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email,password);
                    if(checkCredentials == true){
                        Toast.makeText(Student_Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Select_Activity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Student_Login.this, "Inavalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }) ;
        binding.signupRedirectText.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Student_Login.this, Student_Sign.class);
                startActivity(intent);
            }
        });
    }
}